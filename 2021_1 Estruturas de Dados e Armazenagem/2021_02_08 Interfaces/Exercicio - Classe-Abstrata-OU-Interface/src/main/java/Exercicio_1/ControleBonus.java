package Exercicio_1;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    private List<Bonus> funcionario = new ArrayList<>();

    public void adicionarFuncionario(Bonus b) {
        this.funcionario.add(b);
    }

    public void exbirFuncionarios() {
        System.out.println("\n- Lista de colaboradores - ");
        for (Bonus b : funcionario) {
            System.out.println("\n" + b.toString());
        }
    }

    public Double calcularTotalBons() {
        Double total = 0.0D;

        for (Bonus b : funcionario) {
            total += b.getValorBonus();
        }

        return total;
    }

}
