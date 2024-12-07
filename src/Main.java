import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        System.out.println("Digite o CEP desejado (apenas números): ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consulta.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.geraJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação.");
        }

    }
}
