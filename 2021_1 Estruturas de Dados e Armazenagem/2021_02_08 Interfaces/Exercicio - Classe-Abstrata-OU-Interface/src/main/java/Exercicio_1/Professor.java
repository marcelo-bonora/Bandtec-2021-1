package Exercicio_1;

public class Professor implements Bonus {

    private String nome;
    private Integer qtdAulasSemana;
    private Double valorHoraAula;

    public Professor(String nome, Integer qtdAulasSemana, Double valorHoraAula) {
        this.nome = nome;
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorHoraAula = valorHoraAula;
    }

    @Override
    public Double getValorBonus() {
        return getQtdAulasSemana() * getValorHoraAula() * 4.5 * 0.15;
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

    @Override
    public String toString() {
        return "Classes.Exercicio_1.Professor{nome = " + getNome()
                + ", qtdAulasSemana = " + getQtdAulasSemana()
                + ", valorHoraAula = " + getValorHoraAula()
                + ", valorBonus = " + getValorBonus()
                + "}";
    }

}
