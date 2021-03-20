package br.com.bandtec.projetojpa01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    /*
    @Autowired -> Esta anotação indica que transferimos para o Spring a responsabilidade de instanciar o objeto
    No caso, como PokemonRepository é herdeira de JpaRepository, o Spring sabe como inicializar o objeto

    Nesse caso usamos o conceito de INJEÇÃO DE DEPENDÊNCIAS
    Dizemos que o "repository" foi INJETADO pelo Spring
     */
    @Autowired
    private PokemonRepository repository;

    @GetMapping
    public List<Pokemon> getPokemons() {
        return repository.findAll();
        // findAll() -> select * from tabela
    }

    @PostMapping
    public String postPokemon(@RequestBody Pokemon novoPokemon) {
        repository.save(novoPokemon);
        // save() -> ele faz um "insert" OU um "update",
        // dependendo do valor da PK (se é um valor que não existe, faz "insert". Senão, faz "update")
        return "Salvo com sucesso!";
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable Integer id) {
        /* findById() -> faz um "select from ... where PK=...".  Ele retorna um Optional<Classe da Entidade>   */
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        // um .isPresent() de um Optional retorna true se ele NÃO FOR VAZIO
        if (pokemonOptional.isPresent()) {
            return pokemonOptional.get();  // um .get() de um Optional retorna o valor dentro dele
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deletePokemon(@PathVariable Integer id) {
        /*
        existsById() -> faz um "select count(*) ... where PK=..." e retorna true se retornar 1 ou false se 0
         */
        if (repository.existsById(id)) {
            // deleteById() -> faz um "delete from ... where PK=..."
            repository.deleteById(id);
            return "Excluído!";
        } else {
            return "Não encontrado :.(";
        }
    }
}
