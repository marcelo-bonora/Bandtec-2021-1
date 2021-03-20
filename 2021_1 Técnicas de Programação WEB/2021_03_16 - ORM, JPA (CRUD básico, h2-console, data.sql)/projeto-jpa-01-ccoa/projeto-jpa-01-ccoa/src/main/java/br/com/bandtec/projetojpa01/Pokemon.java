package br.com.bandtec.projetojpa01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
@Entity -> Esta anotação indica que a classe é uma ENTIDADE
Uma entidade é uma classe que mapeia (ou "espelha") uma tabela

Assim, por padrão, todos os seus atributos são mapeados para campos da tabela
 */
@Entity
public class Pokemon {

    @Id // Indica que o campo é a "chave primária" (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // esta configura o campo para ser AUTOINCREMENTO
    private Integer id;

    private String nome;

    private Double forca;

    private boolean solto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public boolean isSolto() {
        return solto;
    }

    public void setSolto(boolean solto) {
        this.solto = solto;
    }
}
