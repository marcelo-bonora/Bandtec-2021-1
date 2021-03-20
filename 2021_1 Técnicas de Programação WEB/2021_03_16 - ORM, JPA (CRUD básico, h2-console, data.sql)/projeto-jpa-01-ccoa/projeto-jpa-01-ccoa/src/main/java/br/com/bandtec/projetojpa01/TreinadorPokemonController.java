package br.com.bandtec.projetojpa01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinadores-pokemon")
public class TreinadorPokemonController {

    @Autowired
    private TreinadorPokemonRepository repository;

    @GetMapping
    public List<TreinadorPokemon> getTreinadoresPokemon(){
        return repository.findAll();
    }

    @PostMapping
    public String postTreinadorPokemon(@RequestBody TreinadorPokemon novoTreinadorPokemon){
        repository.save(novoTreinadorPokemon);
        return "Salvo com sucesso";
    }

    @GetMapping("/{id}")
    public TreinadorPokemon getTreinadorPokemon(@PathVariable Integer id){
        Optional<TreinadorPokemon> treinadorPokemonOptional = repository.findById(id);

        if (treinadorPokemonOptional.isPresent()){
            return treinadorPokemonOptional.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTreinadorPokemon(@PathVariable Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Exluído!";
        } else {
            return "Não encontrado";
        }
    }

    @GetMapping("/contagem")
    public String contagemTreinadorPokemon(){
        return String.format("Total de treinadores cadastrados: %d", repository.count()) ;
    }
}
