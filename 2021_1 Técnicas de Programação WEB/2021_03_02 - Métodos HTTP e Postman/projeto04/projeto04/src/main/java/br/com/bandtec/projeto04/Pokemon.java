package br.com.bandtec.projeto04;

public class Pokemon {

    private String nome;
    private Double forca;
    private Boolean solto;

    public Pokemon(String nome, Double forca, Boolean solto) {
        this.nome = nome;
        this.forca = forca;
        this.solto = solto;
    }

    public String getNome() {
        return nome;
    }

    public Double getForca() {
        return forca;
    }

    public Boolean getSolto() {
        return solto;
    }
}
