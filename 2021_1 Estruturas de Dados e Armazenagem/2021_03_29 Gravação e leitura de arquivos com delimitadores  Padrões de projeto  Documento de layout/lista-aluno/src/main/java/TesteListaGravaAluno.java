import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteListaGravaAluno {

    /* Método gravaLista - recebe uma lista de objetos Cachorro
     * e uma variável isCSV que indica se é arquivo CSV ou não
     * Se for arquivo CSV, grava os campos delimitados por ';'
     * Se for arquivo TXT, grava os campos delimitados por ' '
     */
    public static void gravaLista(ListaObj<Aluno> lista, boolean isCSV, String nomeArquivo) {
        FileWriter arq = null;		// objeto FileWriter - representa o arquivo
        Formatter saida = null;		// objeto Formatter para executar saída formatada
        boolean deuRuim = false;	// indica se deu erro

        if (isCSV) {
            nomeArquivo += ".csv";	// nome do arquivo, se for CSV
        }
        else {
            nomeArquivo += ".txt";	// nome do arquivo, se for TXT
        }

        /* Abre o arquivo para escrita e de forma
         * que grave sempre no final do arquivo, sem apagar o que
         * já está gravado no arquivo (append)
         *
         * Vamos tratar esse arquivo como um objeto Formatter
         * para poder gravar usando format
         */
        try {
            arq = new FileWriter(nomeArquivo, true);  // true indica que vai fazer "append"
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);  // encerra o programa, com status de erro
        }

        // Grava no arquivo os dados dos objetos Cachorro que estão na lista
        try {
            // percorre a lista de objetos Cachorro
            for (int i=0; i< lista.getTamanho(); i++) {
                Aluno aluno = lista.getElemento(i);
                // Grava os atributos do objeto Cachorro no arquivo
                // O %n indica que será gravado um fim de registro
                // No Windows, o fim de registro é um \r\n
                // No Linux e no MacOS, o fim de registro é um \n
                if (isCSV) {
                    saida.format("%05d;%-14s;%.2f%n",aluno.getRa(),	            // grava os atributos do objeto aluno
                            aluno.getNome(),aluno.getNota());	// separados por ';'
                }
                else {
                    saida.format("%05d %-14s %.2f%n",aluno.getRa(),	            // grava os atributos do objeto aluno
                            aluno.getNome(),aluno.getNota());	// separados por ' '
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally { // bloco finally é executado independente de dar erro ou não
            // usado para fechar os objetos saida e close.
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

    /* Método leExibeArquivo - lê e exibe os registros de um arquivo
     * Recebe true se o arquivo a ser lido é o .csv e false se for o .txt
     */
    public static void leExibeArquivo(boolean isCSV, String nomeArquivo) {
        FileReader arq= null;		// objeto FileReader - representa o arquivo a ser lido
        Scanner entrada = null;		// objeto Scanner - para ler do arquivo
        boolean deuRuim= false;		// indica se deu erro

        if (isCSV) {
            nomeArquivo += ".csv";	// nome do arquivo, se for CSV
        }
        else {
            nomeArquivo += ".txt";	// nome do arquivo, se for TXT
        }

        // Abre o arquivo para leitura
        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                // se o arquivo for CSV, usa como delimitador de campo o ';' e o fim de registro
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }
            else {
                // se o arquivo for TXT, usa como delimitador de campo o ' ' e o fim de registro
                entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1); // encerra o programa, com status de erro
        }

        // Lê os registros do arquivo e exibe os dados lidos na console
        try {
            // Exibe na console os títulos das colunas
            System.out.printf("%-4s%-14s%7s\n","RA","NOME","NOTA" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                Integer ra = entrada.nextInt();			// Lê o id
                String nome = entrada.next();			// Lê o nome
                Double nota = entrada.nextDouble();          // Lê o porte
                System.out.printf("%-4d%-14s%7.2f\n",ra,nome,nota);	// Exibe na console em colunas
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
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

        boolean fim = false;
        int raAtual;
        String nomeAtual;
        double notaAtual;

        ListaObj<Aluno> lista = new ListaObj(10);

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);
        int opcao;

        while(!fim){
            System.out.println("\nEscolha um das opções a seguir: ");
            System.out.println("1 - Adicionar um aluno");
            System.out.println("2 - Exibir a lista");
            System.out.println("3 - Exibir um aluno da lista");
            System.out.println("4 - Gravar a lista num arquivo txt");
            System.out.println("5 - Gravar a lista num arquivo csv");
            System.out.println("6 - Ler e exibir arquivo txt");
            System.out.println("7 - Ler e exibir arquivo csv");
            System.out.println("8 - Fim");

            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o ra do aluno:");
                    raAtual = leitor.nextInt();
                    System.out.println("\nDigite o nome do aluno:");
                    nomeAtual = leitorNL.nextLine();
                    System.out.println("\nDigite a nota do aluno:");
                    notaAtual = leitor.nextDouble();

                    Aluno aluno = new Aluno(raAtual,nomeAtual,notaAtual);
                    lista.adiciona(aluno);
                    break;

                case 2:
                    System.out.println("\nLista de alunos: ");
                    lista.exibe();
                    break;

                case 3:
                    System.out.println("\nDigite o indice que procura:");
                    int indice;
                    indice = leitor.nextInt();
                    lista.getElemento(indice);
                    break;

                case 4:
                    System.out.println("\nGravando a lista num arquivo txt...");
                    if (lista.getTamanho() <= 0){
                        System.out.println("Lista se econtra vazia, não há nada a gravar");
                    } else {
                        gravaLista(lista,false, "Alunos");
                        lista.limpa();
                    }
                    break;

                case 5:
                    System.out.println("\nGravando a lista num arquivo csv...");
                    if (lista.getTamanho() <= 0){
                        System.out.println("Lista se econtra vazia, não há nada a gravar");
                    } else {
                        gravaLista(lista,true, "Alunos");
                        lista.limpa();
                    }
                    break;

                case 6:
                    System.out.println("\nLendo e exibindo o arquivo txt...");
                    leExibeArquivo(false, "Alunos");
                    break;

                case 7:
                    System.out.println("\nLendo e exibindo o arquivo csv...");
                    leExibeArquivo(true,"Alunos");
                    break;

                case 8:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }
    }
}