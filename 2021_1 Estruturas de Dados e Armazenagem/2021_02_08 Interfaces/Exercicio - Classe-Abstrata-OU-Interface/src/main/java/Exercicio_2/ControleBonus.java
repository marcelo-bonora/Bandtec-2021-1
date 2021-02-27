package Exercicio_2;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    private List<Funcionario> funcionario = new ArrayList<>();

    public void adicionarFunc(Funcionario f){
        funcionario.add(f);
    }

    public void exibeTodos(){
        System.out.println("\n- Lista de todos funcionários -");
        for (Funcionario f : funcionario){
            System.out.println(f.toString());
        }
    }

    public Double calcularTotalBonus(){
        Double total = 0.0D;

        for (Funcionario f : funcionario){
            total += f.calcularBonus();
        }

        return total;
    }

}
