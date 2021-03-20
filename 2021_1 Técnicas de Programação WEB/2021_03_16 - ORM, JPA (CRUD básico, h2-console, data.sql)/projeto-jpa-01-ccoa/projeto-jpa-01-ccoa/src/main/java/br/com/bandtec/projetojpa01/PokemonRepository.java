package br.com.bandtec.projetojpa01;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Uma Repository é um classe ou interface que está associada a uma Entidade
Ela possui os métodos com as operações de acesso ao banco para sua entidade

<Classe da Entidade, Classe da PK da Entidade>

Aqui a Classe de Entidade foi Pokemon
e a Classe de PK foi Integer (pois o atributo anotado com @Id em Pokemon é Integer)
 */
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
