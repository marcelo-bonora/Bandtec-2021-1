package Exercicio_2;

public class Professor extends Funcionario {

    public Professor(String nome, Integer qtdAulasSemana, Double valorHoraAula) {
        super(nome, qtdAulasSemana, valorHoraAula);
    }

    @Override
    public Double calcularBonus() {
        return getQtdAulasSemana() * getValorHoraAula() * 4.5 * 0.15 ;
    }

}
