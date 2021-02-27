package Exercicio_2;

public class Coordenador extends Funcionario{

    private Integer qtdHorasCoordenacaoSemana;
    private Double valorHoraCoordenação;

    public Coordenador(String nome, Integer qtdAulasSemana, Double valorHoraAula, Integer qtdHorasCoordenacaoSemana, Double valorHoraCoordenação) {
        super(nome, qtdAulasSemana, valorHoraAula);
        this.qtdHorasCoordenacaoSemana = qtdHorasCoordenacaoSemana;
        this.valorHoraCoordenação = valorHoraCoordenação;
    }

    public Integer getQtdHorasCoordenacaoSemana() {
        return qtdHorasCoordenacaoSemana;
    }

    public void setQtdHorasCoordenacaoSemana(Integer qtdHorasCoordenacaoSemana) {
        this.qtdHorasCoordenacaoSemana = qtdHorasCoordenacaoSemana;
    }

    public Double getValorHoraCoordenação() {
        return valorHoraCoordenação;
    }

    public void setValorHoraCoordenação(Double valorHoraCoordenação) {
        this.valorHoraCoordenação = valorHoraCoordenação;
    }

    @Override
    public Double calcularBonus() {
        return getQtdAulasSemana() * getValorHoraAula() * 4.5 * 0.15 * getQtdHorasCoordenacaoSemana() * getValorHoraCoordenação() * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHorasCoordenacaoSemana=" + qtdHorasCoordenacaoSemana +
                ", valorHoraCoordenação=" + valorHoraCoordenação +
                "} " + super.toString();
    }
}
