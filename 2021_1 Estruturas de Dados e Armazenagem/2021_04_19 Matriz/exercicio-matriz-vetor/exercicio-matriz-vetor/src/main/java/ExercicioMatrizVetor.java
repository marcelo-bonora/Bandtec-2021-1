import java.util.Scanner;

public class ExercicioMatrizVetor {

    public static void main(String[] args) {


        Scanner leitor = new Scanner(System.in);

        int maxAluno = 0;           // quantidade máxima de alunos que serão cadastrados
        String[] aluno;             // variável que representa o vetor de alunos
        double[][] notas;           // variável que representa a matriz de notas
        double[] media = new double[2];     // vetor de média
        boolean validado = false;           // indica se maxAluno já está validado

        // Leitura e validação de maxAluno
        while (!validado) {                 // enquanto maxAluno não foi validado
            try {
                // Solicita que o usuário digite o valor de maxAluno
                System.out.println("Digite a quantidade de alunos (valor entre 5 e 15)");
                // Lê o valor digitado
                maxAluno = leitor.nextInt();
                if (maxAluno >= 5 && maxAluno <= 15) {  // se o valor é válido
                    validado = true;                    // então configura validado com true
                } else {
                    // senão lança uma exceção solicitando que o usuário digite novamente
                    throw new Exception("O valor digitado deve estar entre 5 e 15." +
                                        " Digite novamente.");
                }
            } catch (Exception erro) {
                System.out.println(erro);  // se ocorrer um erro, exibe o erro
            }
        }

        // Cria o vetor aluno e a matriz notas
        aluno = new String[maxAluno];       // vetor aluno tem maxAluno posições
        notas = new double[maxAluno][2];    // matriz notas tem maxAluno linhas e 2 colunas

        // Solicita que o usuário digite o nome dos alunos
        // e armazena os nomes lidos no vetor aluno
        for (int i=0; i < aluno.length; i++) {
            System.out.println("Digite o nome de um aluno");
            aluno[i] = leitor.next();
        }

        // Solicita que o usuário digite as notas dos alunos
        // e armazena as notas lidas na matriz notas
        for (int linha=0; linha < notas.length; linha++) {
            for (int coluna=0; coluna < notas[0].length; coluna++) {
                System.out.println("Digite a nota AC" + (coluna+1)+
                                   " do aluno " + aluno[linha]);
                notas[linha][coluna]= leitor.nextDouble();
            }
        }

        // Cálculo das médias das notas AC1 e das notas AC2
        // Essas médias serão armazenadas no vetor media
        for (int coluna=0; coluna < notas[0].length; coluna++) {
            double soma = 0;
            for (int linha=0; linha < notas.length; linha++) {
                soma += notas[linha][coluna];
            }
            media[coluna]= soma / maxAluno;
        }

        // Exibição do vetor aluno, da matriz notas e do vetor media
        System.out.printf("%-15s%10s%10s\n", "NOME DO ALUNO",
                          "NOTA AC1", "NOTA AC2");
        for (int linha=0; linha < notas.length; linha++) {
            System.out.printf("%-15s",aluno[linha]);
            for (int coluna=0; coluna < notas[0].length; coluna++) {
                System.out.printf("%10.2f",notas[linha][coluna]);
            }
            System.out.println();
        }
        // Exibição das médias
        System.out.println();
        System.out.printf("%-15s", "MÉDIA:");
        for (int i=0; i < media.length; i++) {
            System.out.printf("%10.2f",media[i]);
        }
    }

}
