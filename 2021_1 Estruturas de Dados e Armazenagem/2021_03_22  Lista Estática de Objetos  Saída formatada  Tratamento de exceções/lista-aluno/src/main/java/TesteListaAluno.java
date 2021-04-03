import java.util.Scanner;

public class TesteListaAluno {

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
            System.out.println("4 - Limpar a lista");
            System.out.println("5 - Fim");

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
                    System.out.println("\nLimpando a lista:");
                    lista.limpa();
                    break;

                case 5:
                    fim = true;
                    break;
            }

        }
    }
}
