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

        String nomeArq = "ArquivoNotas.txt";
        String header = "";
        String corpo = "";
        String trailer = "";
        int contRegDados = 0;

        // Monta o registro header
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "00NOTA20202";
        header += formatter.format(dataDeHoje);
        header += "01";

        // Grava o registro header
        gravaRegistro(nomeArq, header);


        boolean fim = false;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);
        int opcao;

        while(!fim){
            System.out.println("\nEscolha um das opções a seguir: ");
            System.out.println("1 - Adicionar um aluno");
            System.out.println("2 - Sair");

            opcao= leitor.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("\nDigite o CURSO do aluno:");
                    String curso = leitorNL.nextLine();
                    System.out.println("\nDigite o RA do aluno:");
                    String ra = leitorNL.nextLine();
                    System.out.println("\nDigite o NOME do aluno:");
                    String nome = leitorNL.nextLine();
                    System.out.println("\nDigite a DISCIPLINA do aluno:");
                    String disciplina = leitorNL.nextLine();
                    System.out.println("\nDigite a MÉDIA do aluno:");
                    Double media = leitor.nextDouble();
                    System.out.println("\nDigite quantidade de FALTAS do aluno:");
                    Integer falta = leitor.nextInt();

                    // Monta o corpo

                    // 1o registro de dados
                    corpo += "02";
                    // %-5s : para strings, usamos s
                    //        - alinha para a esquerda, campo de 5 caracteres, completa
                    //        espaços com brancos à direita
                    corpo += String.format("%-5s", curso);     // aluno.getCurso()
                    corpo += String.format("%s", ra);
                    corpo += String.format("%-50s", nome);  // aluno.getNome()
                    corpo += String.format("%-40s", disciplina);
                    // %05.2f : para número com casas decimais, usamos f
                    //          alinha para a direita, porque não tem o -
                    //          completa com zeros à esquerda
                    //          formata com 2 casas decimais, separado por vírgula
                    corpo += String.format("%05.2f", media);
                    // %03d : para número inteiro, usamos d
                    //        alinha para a direita e completa com zeros à esquerda
                    corpo += String.format("%03d", falta);
                    // incrementa o contador de registros de dados
                    contRegDados++;
                    // chama o método para gravar um registro
                    gravaRegistro(nomeArq,corpo);
                    break;

                case 2:
                    // monta o trailer
                    trailer += "01";
                    trailer += String.format("%010d", contRegDados);
                    gravaRegistro(nomeArq,trailer);
                    fim = true;
                    break;

                default:
                    System.out.println("\nDigite uma opção válida");
            }

        }

    }

}
