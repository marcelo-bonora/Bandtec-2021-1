import java.util.ArrayList;
import java.util.List;

/* Classe Empresa - representa uma agregação de Funcionario */

public class Empresa {

    // Atributos
    private List<Funcionario> lista;        // Lista dos funcionários da empresa

    // Construtor
    public Empresa() {
        lista = new ArrayList<Funcionario>();       // Cria a lista
    }

    // Métodos

    // Método adicionaFunc - recebe um objeto Funcionario (que pode ser um objeto
    // de qq classe herdeira de Funcionario) e adiciona esse objeto à lista de
    // funcionários da empresa
    public void adicionaFunc(Funcionario f) {
        lista.add(f);
    }

    // Método exibeTodos - exibe todos os funcionários da empresa
    public void exibeTodos() {
        System.out.println("Lista dos funcionários:");
        for (Funcionario f : lista) {
            System.out.println(f);
        }
    }

    // Método exibeTotalSalario - exibe o total gasto em salário pela empresa
    public void exibeTotalSalario() {
        Double total = 0.0;
        for (Funcionario f : lista) {
            total += f.calcSalario();
        }
        System.out.println("Salário total gasto:" + total);
    }

    // Método exibeHoristas - exibe somente os funcionários horistas
    public void exibeHoristas() {
        System.out.println("Lista dos horistas:");
        for (Funcionario f : lista) {
            if (f instanceof Horista) {
                System.out.println(f);
            }
        }
    }
}