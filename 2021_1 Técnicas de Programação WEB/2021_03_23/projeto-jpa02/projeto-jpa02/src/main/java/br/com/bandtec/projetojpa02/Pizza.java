package br.com.bandtec.projetojpa02;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sabor;

    private Double preco;

    private Boolean bordaRecheada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getBordaRecheada() {
        return bordaRecheada;
    }

    public void setBordaRecheada(Boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }
}
