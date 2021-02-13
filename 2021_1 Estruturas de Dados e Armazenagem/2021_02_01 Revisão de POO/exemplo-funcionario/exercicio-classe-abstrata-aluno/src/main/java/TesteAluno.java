public class TesteAluno {

    public static void main(String[] args) {

        AlunoFundamental rafael = new AlunoFundamental(111, "Rafael", 7.0, 8.0, 9.0, 10.0);
        AlunoGraduacao anderson = new AlunoGraduacao(222, "Anderson", 8.0, 9.0);
        AlunoPos vinicius = new AlunoPos(333, "Vinicius", 7.0, 7.0, 8.0);

        System.out.println(rafael);
        System.out.println(anderson);
        System.out.println(vinicius);

        Escola UFABC = new Escola("UFABC");

        UFABC.adicionaAluno(rafael);
        UFABC.adicionaAluno(anderson);
        UFABC.adicionaAluno(vinicius);

        UFABC.exibeTodos();

        UFABC.exibeAlunoGraduacao();

        UFABC.exibeAprovados();

        UFABC.buscaAluno(9999);
        UFABC.buscaAluno(222);




    }

}
