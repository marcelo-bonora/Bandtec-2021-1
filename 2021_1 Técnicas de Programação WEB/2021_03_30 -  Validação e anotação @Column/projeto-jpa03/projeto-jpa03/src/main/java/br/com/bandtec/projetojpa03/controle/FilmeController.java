package br.com.bandtec.projetojpa03.controle;

import br.com.bandtec.projetojpa03.dominio.Filme;
import br.com.bandtec.projetojpa03.repositorio.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @PostMapping
    public ResponseEntity postFilme(@RequestBody @Valid Filme novoFilme){
        repository.save(novoFilme);
        return ResponseEntity.status(201).build();
    }
}
