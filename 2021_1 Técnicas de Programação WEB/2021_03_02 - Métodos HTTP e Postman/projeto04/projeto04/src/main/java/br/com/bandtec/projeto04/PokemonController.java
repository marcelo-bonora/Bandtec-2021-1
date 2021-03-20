package br.com.bandtec.projeto04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons") // recurso: pokemons
public class PokemonController {

    private List<Pokemon> pokemons = new ArrayList<>();

    public PokemonController() {
        pokemons.add(new Pokemon("Pikachu", 100_000.0, false));
        pokemons.add(new Pokemon("Lugia", 20_000.0, false));
        pokemons.add(new Pokemon("Charmander", 200_000.0, true));
    }

    @GetMapping
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @GetMapping("/{posicao}")
    public Pokemon getPokemon(@PathVariable int posicao) {
        if (posicao < pokemons.size()) {
            return pokemons.get(posicao);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{posicao}")
    public String deletePokemon(@PathVariable int posicao) {
        if (posicao < pokemons.size()) {
            pokemons.remove(posicao);
            return "Pokemon excluído com sucesso!";
        } else {
            return "Pokemon não encontrado :.( ";
        }
    }

    @PostMapping
    public String postPokemon(@RequestBody Pokemon novoPokemon) {
        pokemons.add(novoPokemon);
        return "Pokemon cadastrado com sucesso!";
    }

    @PutMapping("/{posicao}")
    public String putPokemon(@PathVariable int posicao,
                             @RequestBody Pokemon pokemonAlterado) {
        if (posicao < pokemons.size()) {
            pokemons.set(posicao, pokemonAlterado);
            return  "Pokemon alterado com sucesso";
        } else {
            return  "Pokemon não encontrado!!!";
        }
    }
}



