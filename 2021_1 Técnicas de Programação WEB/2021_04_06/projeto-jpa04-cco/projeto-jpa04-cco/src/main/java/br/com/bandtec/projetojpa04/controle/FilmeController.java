package br.com.bandtec.projetojpa04.controle;

import br.com.bandtec.projetojpa04.repositorio.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    /*
@RequestParam -> indica um Parâmetro de Requisição
Parâmetros de requisição vêm após a URI. Começam com '?' (interrogação)
 */
    // @GetMapping  // ex. de URI ->   /filmes?diretor=AA  (Diretores: AA, BB e DD)
    public ResponseEntity getFilmes(@RequestParam String diretor) {
        return ResponseEntity.status(200).body(repository.findByDiretor(diretor));
    }

    // Quando temos mais de 1 Parâmetro de Requisição, separamos eles por & (vulgo "e comercial")
    @GetMapping  // ex. de URI ->   /filmes?diretor=AA&classico=true  (Diretores: AA, BB e DD)
    public ResponseEntity getFilmes(@RequestParam String diretor, @RequestParam boolean classico) {
        return ResponseEntity.status(200).body(repository.findByDiretorContainsAndClassico(diretor, classico));
    }

    @GetMapping("/classicos")
    public ResponseEntity getClassicos() {
        return ResponseEntity.status(200).body(repository.findByClassicoTrue());
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        return ResponseEntity.status(200).body(repository.findAllSimples());
    }
}
