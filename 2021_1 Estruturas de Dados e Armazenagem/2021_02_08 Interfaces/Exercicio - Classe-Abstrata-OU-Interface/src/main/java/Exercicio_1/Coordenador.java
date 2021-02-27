package Exercicio_1;

public class Coordenador implements Bonus {

    private String nome;
    private Integer qtdHorasSemana;
    private Double valorHora;

    public Coordenador(String nome, Integer qtdHorasSemana, Double valorHora) {
        this.nome = nome;
        this.qtdHorasSemana = qtdHorasSemana;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorBonus() {
        return getQtdHorasSemana() * getValorHora() * 4.5 * 0.2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHorasSemana() {
        return qtdHorasSemana;
    }

    public void setQtdHorasSemana(Integer qtdHorasSemana) {
        this.qtdHorasSemana = qtdHorasSemana;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Classes.Exercicio_1.Coordenador{nome = " + getNome()
                + ", qtdAulasSemana = " + getQtdHorasSemana()
                + ", valorHoraAula = " + getValorHora()
                + ", valorBonus = " + getValorBonus()
                + "}";
    }
}
