package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessos")
public class AcessosController {

    /*
    O Spring Boot cria 1 (uma) instância da Controller (ou seja um Singleton)
    Portanto, MUITO CUIDADO no uso de atributos de instância!!!
     */
    private int acessos = 0;
    // portanto, esse "acessos" é "compartilhado" entre todos os clientes da API

    @GetMapping("/contar")
    public String contarAcessos() {
        acessos++;
        return "Você já acessou a API "+acessos+" vezes";
    }

}
