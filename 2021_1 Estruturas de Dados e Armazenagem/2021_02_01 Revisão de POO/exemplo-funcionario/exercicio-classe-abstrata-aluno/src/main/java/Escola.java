import java.util.ArrayList;
import java.util.List;

public class Escola {

    private String nome;

    private List<Aluno> lista;

    public Escola(String nome) {
        this.nome = nome;
        lista = new ArrayList<Aluno>();
    }

    public void adicionaAluno(Aluno a) { lista.add(a);}

    public void exibeTodos(){
        System.out.println("\nLista de todos os alunos: ");
        for (Aluno a : lista){
            System.out.println(a);
        }
    }

    public void exibeAlunoGraduacao(){
        System.out.println("\nLista de alunos de graduação: ");
        for (Aluno a : lista){
            if (a instanceof AlunoGraduacao){
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados(){
        System.out.println("\nLista de alunos aprovados: ");
        for (Aluno a : lista){
            if (a.calculaMedia() >= 6){
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        String result = "";
        for (Aluno a : lista){
            if (a.getRa().equals(ra)){
                result = "\nResultado da busca: \n" + a ;
                break;
            }
               else{
                   result = "\nAluno não encontrado!";
            }
        }
        System.out.println(result);
    }
}
