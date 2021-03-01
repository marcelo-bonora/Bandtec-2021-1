package br.com.bandtec.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/boletins")
public class BoletinsController {

    private Boletim meuBoletim = new Boletim("Lady Gaga", 8.5, 9.5);
    private List<Boletim> listaBoletim = new ArrayList<>();

    public BoletinsController() {
        this.listaBoletim.add(new Boletim("Lady Gaga 1", 9.0, 3.0));
        this.listaBoletim.add(new Boletim("Lady Gaga 2", 6.7, 5.0));
        this.listaBoletim.add(new Boletim("Lady Gaga 3", 7.8, 4.5));
    }

    @GetMapping("/meu-boletim")
    public Boletim meuBoletim() {
        return this.meuBoletim;
    }

    @GetMapping("/listar")
    public List<Boletim> listar() {
        return this.listaBoletim;
    }

    @GetMapping("/cadastrar/{aluno}/{n1}/{n2}")
    public String cadastrar(@PathVariable String aluno,
                            @PathVariable Double n1,
                            @PathVariable Double n2) {
        this.listaBoletim.add(new Boletim(aluno, n1, n2));
        return "Boletim cadastrado com sucesso";
    }

    @GetMapping("/recuperar/{posicao}")
    public Boletim recuperar(@PathVariable int posicao) {
        if (this.listaBoletim.size() > posicao) {
            return this.listaBoletim.get(posicao);
        } else {
            return null;
        }
    }

    @GetMapping("/atualizar/{posicao}/{aluno}/{n1}/{n2}")
    public String atualizar(@PathVariable int posicao,
                            @PathVariable String aluno,
                            @PathVariable Double n1,
                            @PathVariable Double n2) {
        if (this.listaBoletim.size() > posicao) {
            this.listaBoletim.set(posicao, new Boletim(aluno, n1, n2));
            return "Boletim atualizado com sucesso";
        }
        return "Boletim não encontrado";
    }

    @GetMapping("/pesquisar/{aluno}")
    public List<Boletim> pesquisar(@PathVariable String aluno) {
        // método tradicional
        /*List<Boletim> filtro = new ArrayList<>();
        for (Boletim boletim : listaBoletim) {
            if (boletim.getAluno().contains(aluno)) {
                filtro.add(filtro);
            }
        }
        return filtro;*/

        // método com streams
        return listaBoletim.stream()
                .filter(boletim -> boletim.getAluno().contains(aluno))
                .collect(Collectors.toList());
    }
}
