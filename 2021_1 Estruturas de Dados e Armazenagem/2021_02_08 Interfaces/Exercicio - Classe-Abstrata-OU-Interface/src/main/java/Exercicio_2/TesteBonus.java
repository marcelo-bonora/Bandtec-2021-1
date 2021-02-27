package Exercicio_2;

public class TesteBonus {
    public static void main(String[] args) {

        Professor Katia = new Professor("Katia",30,100.0);
        Coordenador Pedro = new Coordenador("Pedro",20,30.0,30,25.0);

        ControleBonus cb = new ControleBonus();

        cb.adicionarFunc(Katia);
        cb.adicionarFunc(Pedro);
        cb.exibeTodos();
        System.out.println("Total do valor bonus: " + cb.calcularTotalBonus());

    }




}
