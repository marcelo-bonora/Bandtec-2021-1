package Exercicio_2;

public abstract class Funcionario {

    private String nome;
    private Integer qtdAulasSemana;
    private Double valorHoraAula;

    public Funcionario(String nome, Integer qtdAulasSemana, Double valorHoraAula) {
        this.nome = nome;
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorHoraAula = valorHoraAula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAulasSemana() {
        return qtdAulasSemana;
    }

    public void setQtdAulasSemana(Integer qtdAulasSemana) {
        this.qtdAulasSemana = qtdAulasSemana;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public abstract Double calcularBonus();

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", qtdAulasSemana=" + qtdAulasSemana +
                ", valorHoraAula=" + valorHoraAula +
                ", bonus=" + calcularBonus() +
                '}';
    }
}
