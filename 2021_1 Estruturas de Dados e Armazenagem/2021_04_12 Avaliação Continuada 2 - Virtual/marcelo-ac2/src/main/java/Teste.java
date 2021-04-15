import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teste {

    public static void gravaLista(ListaObj<Carta> lista, boolean isCSV, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;

        if (isCSV) {
            nomeArquivo += ".csv";
        }
        else {
            nomeArquivo += ".txt";
        }

        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Carta carta = lista.getElemento(i);

                if (isCSV) {
                    saida.format("%d;%s;%.2f;%s;%s;%s%n",
                            carta.getIdCarta(),
                            carta.getNome(),
                            carta.getPreco(),
                            carta.getTipo(),
                            carta.getRaridade(),
                            carta.getCodigo());
                }
                else {
                    saida.format("%d;%s;%.2f;%s;%s;%s%n",
                            carta.getIdCarta(),
                            carta.getNome(),
                            carta.getPreco(),
                            carta.getTipo(),
                            carta.getRaridade(),
                            carta.getCodigo());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivo(boolean isCSV, String nomeArquivo) {
        FileReader arq= null;
        Scanner entrada = null;
        boolean deuRuim= false;

        if (isCSV) {
            nomeArquivo += ".csv";
        }
        else {
            nomeArquivo += ".txt";
        }

        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n|\\n");
            }
            else {
                entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%8s%-10s%7s%-11s%-10s%-8s\n",
                    "ID_CARTA",
                    "NOME",
                    "PRECO",
                    "TIPO",
                    "RARIDADE",
                    "CODIGO");
            while (entrada.hasNext()) {
                int idcarta = entrada.nextInt();
                String nome = entrada.next();
                double preco = entrada.nextDouble();
                String tipo = entrada.next();
                String raridade = entrada.next();
                String codigo = entrada.next();
                System.out.printf("%8d%-10s%7.2f%-11s%-10s%-8s\n",
                        idcarta,
                        nome,
                        preco,
                        tipo,
                        raridade,
                        codigo);
            }
        }
        catch (NoSuchElementException erro){
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro){
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {

        ListaObj<Carta> lista = new ListaObj(10);

        boolean fim = false;
        int opcao;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        while (!fim){
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionando Item a Lista");
            System.out.println("2- Exibir a lista");
            System.out.println("3- Gravando a lista em CSV");
            System.out.println("4- Lendo arquivo CSV");
            System.out.println("5- Gravando Lista em TXT");
            System.out.println("6- Fim");

            opcao = leitor.nextInt();
            switch (opcao){

                case 1:
                    System.out.println("-- Adicionando Item a Lista --");
                    System.out.println("Digite o ID da carta:");
                    Integer id = leitor.nextInt();
                    System.out.println("Digite o NOME da carta:");
                    String nome = leitorNL.nextLine();
                    System.out.println("Digit o PREÇO da carta:");
                    Double preco =leitor.nextDouble();
                    System.out.println("Digite o TIPO da carta:");
                    String tipo = leitorNL.nextLine();
                    System.out.println("Digite o RARIDADE da carta:");
                    String raridade = leitorNL.nextLine();
                    System.out.println("Digite o CODIGO da carta:");
                    String codigo = leitorNL.nextLine();

                    Carta carta = new Carta(id, nome, preco, tipo, raridade, codigo);
                    lista.adiciona(carta);

                    break;

                case 2:
                    System.out.println("-- Exibindo Lista --");
                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                case 3:
                    System.out.println("-- Gravando Lista em CSV --");
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, true, "listaCarta");
                    }
                    break;

                case 4:
                    System.out.println("-- Lendo arquivo CSV --");
                    leExibeArquivo(true, "listaCarta");

                    break;

                case 5:
                    System.out.println("-- Gravando Lista em TXT --");
                    gravaLista(lista, false, "listaCarta");
                    break;

                case 6:
                    fim = true;
                    break;


            }
        }

    }

}
