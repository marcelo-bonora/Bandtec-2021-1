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
public class TreinadorPokemon {

    @Id // Indica que o campo é a "chave primária" (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // esta configura o campo para ser AUTOINCREMENTO
    private int id;

    private String nome;

    private Integer idade;

    private int pokemonsCapturados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public int getPokemonsCapturados() {
        return pokemonsCapturados;
    }

    public void setPokemonsCapturados(int pokemonsCapturados) {
        this.pokemonsCapturados = pokemonsCapturados;
    }
}
