package br.com.bandtec.projetojpa01;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Uma Repository é um classe ou interface que está associada a uma Entidade
Ela possui os métodos com as operações de acesso ao banco para sua entidade

<Classe da Entidade, Classe da PK da Entidade>
Aqui a Classe de Entidade foi Treinador
e a Classe de PK foi Integer (pois o atributo anotado com @Id em Treinador é int)
 */
public interface TreinadorPokemonRepository extends JpaRepository<TreinadorPokemon, Integer> {

}
