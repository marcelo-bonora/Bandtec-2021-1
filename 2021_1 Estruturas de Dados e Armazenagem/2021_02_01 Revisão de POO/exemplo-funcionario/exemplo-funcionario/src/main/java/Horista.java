/* Classe Horista - herdeira de Funcionario */

public class Horista extends Funcionario{

    // Atributos
    private Integer qtdHora;           // Quantidade de horas trabalhadas no mês
    private Double valorHora;           // Valor ganho por hora

    // Construtor

    public Horista(String cpf, String nome, Integer qtdHora, Double valorHora) {
        super(cpf, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    // Métodos

    // Implementação do método calcSalario()
    public Double calcSalario() {
        return qtdHora * valorHora;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Horista{" +
                "qtdHora=" + qtdHora +
                ", valorHora=" + valorHora +
                ", salário=" + calcSalario() +
                "} " + super.toString();
    }
}
