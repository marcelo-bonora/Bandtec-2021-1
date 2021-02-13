/* Classe Engenheiro - herdeira de Funcionario */

public class Engenheiro extends Funcionario {

    // Atributo
    private Double salario;

    // Construtor

    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    // Métodos

    // Implementação do método abstrato calcSalario()
    public Double calcSalario() {
        return salario;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                "} " + super.toString();
    }
}
