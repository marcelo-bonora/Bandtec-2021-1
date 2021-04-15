import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFilme {

    public static void gravaLista(ListaObj<Filme> lista, String nomeDoArquivo) {
        FileWriter arquivo = null;
        Formatter saida = null;
        boolean deuRuim = false;

        try {
            arquivo = new FileWriter(nomeDoArquivo, true);
            saida = new Formatter(arquivo);
        } catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Filme filme = lista.getElemento(i);
                saida.format("%d;%s;%s;%d;%.2f%n",
                        filme.getIdFilme(),
                        filme.getNome(),
                        filme.getGenero(),
                        filme.getIdade(),
                        filme.getNota());
            }
        } catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arquivo.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim)
                System.exit(1);
        }
    }

    public static void leExibeArquivo(String nomeDoArquivo) {
        FileReader arquivo = null;
        Scanner entrada = null;
        boolean deuRuim = false;

        try {
            arquivo = new FileReader(nomeDoArquivo);
            entrada = new Scanner(arquivo).useDelimiter(";|\\r\\n|\\n");
        } catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%-8s %-20s%-20s%7s %6s\n", "ID FILME", "NOME", "GÊNERO", "IDADE", "NOTA");
            while (entrada.hasNext()) {
                int idFilme = entrada.nextInt();
                String nome = entrada.next();
                String genero = entrada.next();
                int idade = entrada.nextInt();
                double nota = entrada.nextDouble();
                System.out.printf("%8d %-20s%-20s%7d %6.2f\n", idFilme, nome, genero, idade, nota);
            }
        } catch (NoSuchElementException erro) {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arquivo.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim)
                System.exit(1);
        }
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);   // leitor para uso geral, menos nextLine()
        Scanner leitorNL = new Scanner(System.in); // leitor para usar para ler com nextLine()

        boolean fim = false;

        int id;
        String nome;
        double nota;
        String genero;
        int idade;

        ListaObj<Filme> filmes = new ListaObj<Filme>(10);

        while (!fim) {
            System.out.println("\n" +
                    "1.\tAdicionar um filme\n" +
                    "2.\tExibir a lista\n" +
                    "3.\tGravar a lista em arquivo CSV\n" +
                    "4.\tLer e exibir um arquivo CSV\n" +
                    "5.\tGravar em arquivo CSV apenas filmes do gênero...\n" +
                    "6.\tSair\n"
            );

            int opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do filme: ");
                    id = leitor.nextInt();
                    System.out.print("Digite o NOME do filme: ");
                    nome = leitorNL.nextLine();
                    System.out.print("Digite a NOTA do filme: ");
                    nota = leitor.nextDouble();
                    System.out.print("Digite o GÊNERO do filme: ");
                    genero = leitor.next();
                    System.out.print("Digite a IDADE mínima para ver o filme: ");
                    idade = leitor.nextInt();
                    filmes.adiciona(new Filme(id, nome, nota, genero, idade));
                    System.out.println("\nFilme cadastrado");
                    break;
                case 2:
                    if (filmes.getTamanho() == 0) {
                        System.out.println("\nLista vazia");
                    } else {
                        filmes.exibe();
                    }
                    break;
                case 3:
                    if (filmes.getTamanho() == 0) {
                        System.out.println("\nLista vazia, não há nada para gravar");
                    } else {
                        gravaLista(filmes, "filme.csv");
                        filmes.limpa();
                        System.out.println("\nArquivo gravado com sucesso");
                    }
                    break;
                case 4:
                    System.out.print("\nDigite o nome do arquivo a ser lido, com extensão csv: ");
                    String nomeDoArquivo = leitor.next();
                    leExibeArquivo(nomeDoArquivo);
                    break;
                case 5:
                    if (filmes.getTamanho() == 0)
                        System.out.println("\nLista vazia, não há nada para gravar");
                    else {
                        System.out.println("\nDigite o nome do arquivo a ser gravado, com extensão csv: ");
                        String nomeArquivo = leitor.next();
                        System.out.println("\nDigite o gênero dos filmes a serem gravados: ");
                        String generoParaGravar = leitor.next();
                        // Cria uma lista para filtrar os filmes desse gênero
                        ListaObj<Filme> filmesFiltrados = new ListaObj<Filme>(10);
                        for (int i = 0; i < filmes.getTamanho(); i++) {
                            Filme filme = filmes.getElemento(i);
                            if (filme.getGenero().equals(generoParaGravar)) {
                                filmesFiltrados.adiciona(filme);
                            }
                        }

                        if (filmesFiltrados.getTamanho() == 0) {
                            System.out.println("\nNão há filmes desse gênero na lista");
                        } else {
                            gravaLista(filmesFiltrados, nomeArquivo);
                            System.out.println("\nArquivo gravado com sucesso");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\nPrograma encerrado");
                    fim = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}