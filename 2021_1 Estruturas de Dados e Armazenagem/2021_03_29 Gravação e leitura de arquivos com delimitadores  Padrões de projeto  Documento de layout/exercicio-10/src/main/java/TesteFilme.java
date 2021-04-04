import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFilme {

    /* Método gravaLista - recebe uma lista de objetos Cachorro
     * e uma variável isCSV que indica se é arquivo CSV ou não
     * Se for arquivo CSV, grava os campos delimitados por ';'
     * Se for arquivo TXT, grava os campos delimitados por ' '
     */
    public static void gravaLista(ListaObj<Filme> lista, boolean isCSV, String nomeArquivo, String genero) {
        int count = 0;
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
            if (genero.equals("All")){
                for (int i=0; i< lista.getTamanho(); i++) {
                    Filme filme = lista.getElemento(i);
                    // Grava os atributos do objeto Cachorro no arquivo
                    // O %n indica que será gravado um fim de registro
                    // No Windows, o fim de registro é um \r\n
                    // No Linux e no MacOS, o fim de registro é um \n
                    if (isCSV) {
                        saida.format("%05d;%-14s;%.2f;%10s;%d%n",filme.getIdFilme(),	            // grava os atributos do objeto aluno
                                filme.getNome(),filme.getNota(), filme.getGenero(), filme.getIdade());	// separados por ';'
                    }
                    else {
                        saida.format("%05d %-14s %.2f %10s %d%n",filme.getIdFilme(),	            // grava os atributos do objeto aluno
                                filme.getNome(),filme.getNota(), filme.getGenero(), filme.getIdade());	// separados por ' '
                    }
                }
            } else {
                for (int i = 0; i < lista.getTamanho(); i++){
                    Filme filme = lista.getElemento(i);
                    if (filme.getGenero().equals(genero)){
                        count++;
                        if (isCSV) {
                            saida.format("%05d;%-14s;%.2f;%10s;%d%n",filme.getIdFilme(),	            // grava os atributos do objeto aluno
                                    filme.getNome(),filme.getNota(), filme.getGenero(), filme.getIdade());	// separados por ';'
                        }
                        else {
                            saida.format("%05d %-14s %.2f %10s %d%n",filme.getIdFilme(),	            // grava os atributos do objeto aluno
                                    filme.getNome(),filme.getNota(), filme.getGenero(), filme.getIdade());	// separados por ' '
                        }
                    }
                }
                if (count == 0){
                    System.out.println("Não há filmes desse genêro na lista");
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
            System.out.printf("%-4s%-14s%7s%10s%10s\n","ID","NOME","NOTA","GENERO","IDADE" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();			// Lê o id
                String nome = entrada.next();			// Lê o nome
                Double nota = entrada.nextDouble();          // Lê o porte
                String genero = entrada.next();
                Integer idade = entrada.nextInt();
                System.out.printf("%-4s%-14s%7s%10s%10d\n",id,nome,nota,genero,idade);	// Exibe na console em colunas
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

        ListaObj<Filme> lista = new ListaObj(10);

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);
        boolean fim = false;
        int opcao;

        Integer idFilmeAtual;
        String nomeAtual;
        Double notaAtual;
        String generoAtual;
        Integer idadeAtual;

        while (!fim){
            System.out.println("\n----- Escolha uma das opções a seguir ----- ");
            System.out.println("1 - Adicionar um filme");
            System.out.println("2 - Exibir lista");
            System.out.println("3 - Gravar a lista em arquivo CSV");
            System.out.println("4 - Ler e exibir um arquivo CSV");
            System.out.println("5 - Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero");
            System.out.println("6 - Sair");

            opcao = leitor.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("\nDigite o id do filme:");
                    idFilmeAtual = leitor.nextInt();
                    System.out.println("\nDigite o nome do filme");
                    nomeAtual = leitorNL.nextLine();
                    System.out.println("\nDigite a nota do filme");
                    notaAtual = leitor.nextDouble();
                    System.out.println("\nDigite o gênero do filme");
                    generoAtual = leitorNL.nextLine();
                    System.out.println("\nDigite a idade miníma do filme");
                    idadeAtual = leitor.nextInt();

                    Filme filme = new Filme(idFilmeAtual,nomeAtual,notaAtual,generoAtual,idadeAtual);
                    lista.adiciona(filme);
                    break;

                case 2:
                    System.out.println("---------- Lista de Filmes ---------- ");
                    if (lista.getTamanho() <= 0){
                        System.out.println("A lista se econtra vazia");
                    } else {
                        lista.exibe();
                    }
                    break;

                case 3:
                    System.out.println("\nGravando a lista num arquivo csv...");
                    if (lista.getTamanho() <= 0){
                        System.out.println("Lista se econtra vazia, não há nada a gravar");
                    } else {
                        gravaLista(lista,true, "Filmes", "All");
                        lista.limpa();
                    }
                    break;

                case 4:
                    System.out.println("\nLendo e exibindo o arquivo csv...");
                    leExibeArquivo(true,"Filmes");
                    break;

                case 5:
                    System.out.println("\nGravando arquivo CSV de um terminado genero...");
                    if (lista.getTamanho() <= 0){
                        System.out.println("\nLista se econtra vazia, não há nada a gravar");
                    } else {
                        System.out.println("\nQual o nome do arquivo?");
                        String nomeArq = leitorNL.nextLine();
                        System.out.println("\nQual é o gênero?");
                        String genero = leitorNL.nextLine();
                        gravaLista(lista,true, nomeArq, genero);
                    }
                    break;

                case 6:
                    System.out.println("Encerrando programa..");
                    fim = true;
                    break;

            }
        }

    }

}
