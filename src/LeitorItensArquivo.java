import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeitorItensArquivo {
    Scanner scanner;
    List<Item> itens;

    public LeitorItensArquivo(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.itens = new ArrayList<>();
    }

    public void leArquivo(){
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();

            var leitorDeLinha = new Scanner(linha);
            leitorDeLinha.useDelimiter(",");

            String nome = leitorDeLinha.next();
            double quantidade = Double.parseDouble(String.valueOf(leitorDeLinha.next()));
            String observacao;
            try{
                observacao = leitorDeLinha.next();
            } catch (NoSuchElementException exception){
                observacao = "";
            }

            itens.add(new Item(nome, quantidade,observacao));
        }
    }

    public List<Item> recuperaItens() {
        leArquivo();
        return itens;
    }
}
