package br.com.bandtec.projeto04;

public class Cliente {

    private String nome;
    private Double renda;

    public Cliente(String nome, Double renda) {
        this.nome = nome;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public Double getRenda() {
        return renda;
    }

    public String getClasseSocial() {
        if (renda == null) {
            return null;
        } else if (renda <= 2900.0) {
            return "Pobre";
        } else if (renda < 12000.0) {
            return "Classe Média";
        } else {
            return "Rico";
        }
    }
}
