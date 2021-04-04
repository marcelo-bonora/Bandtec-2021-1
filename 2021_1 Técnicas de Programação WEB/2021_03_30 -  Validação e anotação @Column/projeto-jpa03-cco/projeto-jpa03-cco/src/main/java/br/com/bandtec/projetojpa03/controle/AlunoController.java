package br.com.bandtec.projetojpa03.controle;

import br.com.bandtec.projetojpa03.dominio.Aluno;
import br.com.bandtec.projetojpa03.repositorio.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public ResponseEntity postAluno(@RequestBody @Valid Aluno novoAluno){
        repository.save(novoAluno);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getAlunos(){
        List<Aluno> alunos = repository.findAll();
        if  (alunos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(alunos);
        }
    }
}
