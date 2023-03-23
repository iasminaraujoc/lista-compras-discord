import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ListaCompras {
    public static void main(String[] args) throws FileNotFoundException {
        var leitorArquivo = new LeitorItensArquivo(new File("lista.csv"));
        List<Item> itensArquivo = leitorArquivo.recuperaItens();

        System.out.println("Lista de compras");
        System.out.println("------------------------------------");
        System.out.println();

        int contador = 1;

        for (var item : itensArquivo){
            System.out.println("Item " + contador);
            System.out.println("Nome: " + item.nome());
            System.out.println("Quantidade: " + item.quantidade());
            System.out.println("Observação: " + item.observacao());
            System.out.println();

            contador++;

        }
    }
}