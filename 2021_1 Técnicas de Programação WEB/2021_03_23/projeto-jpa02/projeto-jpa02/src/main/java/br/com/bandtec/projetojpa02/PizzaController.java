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
    public ResponseEntity getPizzas(){
        List<Pizza> pizzas = repository.findAll();

        if (pizzas.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(pizzas);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePizza(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity postPizza(@RequestBody Pizza novaPizza) {
        repository.save(novaPizza);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity getPizza(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }


}
