import java.util.Scanner;

public class ExercicioVetorTurma {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] t1 = new String[10];
        String[] t2 = new String[10];
        String nome;
        String turma;
        int indT1 = 0, indT2 = 0;

        for (int i = 0; i < t1.length; i++) {
            System.out.println("Digite o nome de um aluno");
            nome = leitor.next();

            System.out.println("Digite T1 para turma1 ou T2 para turma2");
            turma = leitor.next();

            if (turma.equalsIgnoreCase("T1")) {
                t1[indT1++] = nome;
            }
            else {
                t2[indT2++] = nome;
            }
        }

        if (indT1 == 0) {
            System.out.println("Não há alunos na turma T1");
        }
        else {
            System.out.println("Quantidade de alunos da turma T1: " + indT1);
            System.out.println("Lista de alunos da turma T1:");
            for (int i = 0; i < indT1; i++) {
                System.out.print(t1[i] + "\t");
            }
            System.out.println();
        }

        if (indT2 == 0) {
            System.out.println("Não há alunos na turma T2");
        }
        else {
            System.out.println("Quantidade de alunos da turma T2: " + indT2);
            System.out.println("Lista de alunos da turma T2:");
            for (int i = 0; i < indT2; i++) {
                System.out.print(t2[i] + "\t");
            }
            System.out.println();
        }
    }
}
