/* Classe Vendedor - herdeira de Funcionario */

public class Vendedor extends Funcionario {

    // Atributos
    private Double vendas;      // quantia de vendas realizadas no mês
    private Double taxa;        // taxa de comissão do vendedor

    // Construtor
    public Vendedor(String cpf, String nome, Double vendas, Double taxa) {
        super(cpf, nome);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    // Métodos

    // Implementação do método calcSalario()
    public Double calcSalario() {
        return vendas * taxa;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + vendas +
                ", taxa=" + taxa +
                ", salário=" + calcSalario() +
                "} " + super.toString();
    }
}
