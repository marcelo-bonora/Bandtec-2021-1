package br.com.bandtec.projeto03;

public class Boletim {

    private String aluno;
    private Double nota1;
    private Double nota2;

    public Boletim(String aluno, Double nota1, Double nota2) {
        this.aluno = aluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getAluno() {
        return aluno;
    }

    public Double getNota1() {
        return nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public Double getMedia() {
        return ( this.nota1 + this.nota2 ) / 2;
    }

    public boolean isAprovado() {
        return this.getMedia() >= 6.0;
    }
}
