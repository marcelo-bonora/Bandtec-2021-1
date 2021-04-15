import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GravaArquivo2 {

    public static void gravaRegistro (String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {
            // o argumento true é para indicar que o arquivo não será sobrescrito e sim
            // gravado com append (no final do arquivo)
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }



    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);   // leitor para uso geral, menos nextLine()
        Scanner leitorNL = new Scanner(System.in); // leitor para usar para ler com nextLine()

        String nomeArq = "ArquivoNotas.txt";
        String header = "";
        String corpo = "";
        String trailer = "";
        int contRegDados = 0;
        boolean fim = false;
        String ra, nome, curso, disciplina;
        double media;
        int qtdFalta;

        // Monta o registro header
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "00NOTA20211";
        header += formatter.format(dataDeHoje);
        header += "01";

        // Grava o registro header
        gravaRegistro(nomeArq, header);

        while (!fim) {
            System.out.println("\n" +
                    "1.\tAdicionar um aluno\n" +
                    "2.\tSair\n"
            );

            int opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o RA do aluno");
                    ra = leitor.next();
                    System.out.println("Digite o curso do aluno");
                    curso = leitor.next();
                    System.out.println("Digite o nome do aluno");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite a disciplina");
                    disciplina = leitorNL.nextLine();
                    System.out.println("Digite a média final do aluno");
                    media = leitor.nextDouble();
                    System.out.println("Digite a quantidade de faltas do aluno");
                    qtdFalta = leitor.nextInt();

                    corpo = "02";
                    // %-5s : para strings, usamos s
                    //        - alinha para a esquerda, campo de 5 caracteres, completa
                    //        espaços com brancos à direita
                    corpo += String.format("%-5s", curso);
                    corpo += String.format("%-8s", ra);
                    corpo += String.format("%-50s", nome);
                    corpo += String.format("%-40s", disciplina);
                    // %05.2f : para número com casas decimais, usamos f
                    //          alinha para a direita, porque não tem o -
                    //          completa com zeros à esquerda
                    //          formata com 2 casas decimais, separado por vírgula
                    corpo += String.format("%05.2f", media);
                    // %03d : para número inteiro, usamos d
                    //        alinha para a direita e completa com zeros à esquerda
                    corpo += String.format("%03d", qtdFalta);
                    // incrementa o contador de registros de dados
                    contRegDados++;
                    // chama o método para gravar um registro
                    gravaRegistro(nomeArq, corpo);
                    break;

                case 2:
                    fim = true;
                    // monta o trailer
                    trailer += "01";
                    trailer += String.format("%010d", contRegDados);
                    gravaRegistro(nomeArq, trailer);
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}
