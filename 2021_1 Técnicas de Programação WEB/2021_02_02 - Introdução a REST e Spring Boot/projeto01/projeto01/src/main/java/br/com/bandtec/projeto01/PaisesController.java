package br.com.bandtec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises") // -> Esta anotação indica a URI base de todos os Endpoint desta classe
// OU seja, todos os Endpoints daqui serão /paises/...
public class PaisesController {

    @GetMapping // URI: /paises
    public String padrao() {
        return "Conheça os paises!";
    }

    @GetMapping("/mexico") // URI: /paises/mexico
    public String mexico() {
        return "Obrigado pelo seriado do Chaves!";
    }

    @GetMapping("/cuba") // URI: /paises/cuba
    public String cuba() {
        return "Melhores charutos do mundo!";
    }

    @GetMapping("/canada") // URI: /paises/canada
    public String canada() {
        return "Pedimos desculpas por qualquer coisas";
    }
}
