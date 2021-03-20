package br.com.bandtec.projetojpa01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/treinadores")
public class TreinadorController {

    /*
    @Autowired -> Esta anotação indica que transferimos para o Spring a responsabilidade de instanciar o objeto
    No caso, como TreinadorRepository é subclasse de CrudRepository, o Spring sabe como inicializar o objeto
     */
    @Autowired
    private TreinadorPokemonRepository repository;

    @GetMapping("/{id}")
    public TreinadorPokemon getTreinador(@PathVariable int id) {

        /*
        findById() -> recupera um registro a partir da PK informada no parâmetro
        Este método retorna um Optional do tipo da Entidade.
        No exemplo abaixo foi um Optional<Treinador>.
         */
        Optional<TreinadorPokemon> treinadorOptional = repository.findById(id);

        // um .isPresent() a partir de um Optional retorna true se ele não estiver vazio
        if (treinadorOptional.isPresent()) {
            // o .get de um Optional retorna o valor em sí (no caso, um instância de Treinador)
            return treinadorOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping
    public Iterable<TreinadorPokemon> getTreinadores() {
        return repository.findAll();
        // findAll() -> select * from tabela
    }

    @DeleteMapping("/{id}")
    public String deleteTreinador(@PathVariable int id) {
        // existsById() - faz um "select count()" com o id do parâmetro para saber se existe aquela PK
        // ele retorna true se o valor da chave existir ou false em caso contrário
        if (repository.existsById(id)) {
            repository.deleteById(id);
            // deleteById() executa uma instrução "delete" passando como PK o valor do parâmetro
            return "Treinador excluído com sucesso";
        } else {
            return "Treinador não encontrado!";
        }
    }

    @GetMapping("/contagem")
    public long getContagem() {
        return repository.count();
    }


}
