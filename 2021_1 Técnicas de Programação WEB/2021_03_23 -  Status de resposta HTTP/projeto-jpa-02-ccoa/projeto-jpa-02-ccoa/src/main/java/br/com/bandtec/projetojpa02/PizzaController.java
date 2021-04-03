package br.com.bandtec.projetojpa02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public ResponseEntity getPizzas() {
        List<Pizza> pizzas = repository.findAll();

        if (pizzas.isEmpty()) { // a lista de músicas está vazia?

            /*
            Ambas as linhas de código abaixo fazem a MESMA COISA:
            criam uma Reposta HTTP com status 204 ("No Content") e SEM corpo
             */
            // return ResponseEntity.noContent().build();
            return ResponseEntity.status(204).build();
            // return ResponseEntity.noContent().build();
        } else {

            /*
            Ambas as linhas de código abaixo fazem a MESMA COISA:
            criam uma Reposta HTTP com status 200 ("Ok") e COM a lista de músicas no corpo
             */
            return ResponseEntity.status(200).body(pizzas);
            // return ResponseEntity.ok(pizzas);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePizza(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
            // return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
            // return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity postPizza(@RequestBody Pizza novaPizza) {
        // supondo que o preço deva estar entre 0 e 100
        if (novaPizza.getPreco() < 0 || novaPizza.getPreco() > 100) {
            // return ResponseEntity.badRequest().body("O preço deve estar entre 0 e 100");
            return ResponseEntity.status(400).body("O preço deve estar entre 0 e 100");
        }

        repository.save(novaPizza);

        return ResponseEntity.created(null).build();
        // return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPizza(@PathVariable int id) {
        /*
        O ResponseEntity.of(Optional qualquer) cria:
        - Uma resposta HTTP com status 404 e SEM corpo caso o Optional estiver vazio
        - OU uma resposta HTTP com status 200 e usando o valor do Optional como corpo (body)
         */
        return ResponseEntity.of(repository.findById(id));
    }
}
