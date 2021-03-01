package br.com.bandtec.projeto01;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController -> esta ANOTAÇÃO transforma a classe numa REST Controller.
Ou seja, nela será possível programar chamadas (ou EndPoint) para a API
 */
@RestController
public class FrasesController {

    // A convenção para URIs é kabeb-case (minúsculo com palavras separadas por hífen)

    /*
    @GetMapping -> esta ANOTAÇÃO transforma o método numa chamada (ou EndPoint) REST
    URI: /
    URL: http://localhost:8080/ ou http://localhost:8080
     */
    @GetMapping
    public String padrao() {
        return "API de Frases educadas";
    }

    /*
    @GetMapping -> esta ANOTAÇÃO transforma o método numa chamada (ou EndPoint) REST
    URI: /bom-dia
    URL: http://localhost:8080/bom-dia
     */
    @GetMapping("/bom-dia")
    public String bomDia() {
        return "Bom dia, galera";
    }

    /*
    @GetMapping -> esta ANOTAÇÃO transforma o método numa chamada (ou EndPoint) REST
    URI: /boa-tarde
    URL: http://localhost:8080/boa-tarde
     */
    @GetMapping("/boa-tarde")
    public String boaTarde() {
        return "Boa tarde, amigos!";
    }
}
