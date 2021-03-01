package br.com.bandtec.Exercicio0921;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agua")
public class BeberAguaController {

    private Integer count = 0;
    private Double qtdAgua = 0.0;

    @GetMapping("/beber-agua/{litrosAgua}")
    public String beberAgua(@PathVariable Double litrosAgua){

        if (litrosAgua < 0.0) {
            return "Não é possível beber " + litrosAgua + " litros de água, como você fez isso??!!!";

        }
        else {
            count++;
            qtdAgua += litrosAgua;
            return "Que ótimo, você acaba de beber " + litrosAgua + " litros de água.";
        }
    }

    @GetMapping("/beber-agua/consulta")
    public String consulta(){
        return String.format("Você já bebeu água %d vezes, totalizando %.2f litros", count, qtdAgua);
    }
}
