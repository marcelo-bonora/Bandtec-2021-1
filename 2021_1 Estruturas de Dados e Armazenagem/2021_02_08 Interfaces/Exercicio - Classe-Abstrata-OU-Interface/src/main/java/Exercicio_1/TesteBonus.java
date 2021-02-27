package Exercicio_1;

public class TesteBonus {

    public static void main(String[] args) {

        Professor Katia = new Professor("Katia", 5, 50.0);
        Coordenador Pedro = new Coordenador("Pedro", 54, 40.0);

        ControleBonus cb = new ControleBonus();

        cb.adicionarFuncionario(Katia);
        cb.adicionarFuncionario(Pedro);

        cb.exbirFuncionarios();
        System.out.println("\nTotal da soma dos bonus: R$" + cb.calcularTotalBons());

    }

}
