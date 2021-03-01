package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alimentacao")
public class AlimentacaoController {

    @GetMapping
    public String padrao() {
        return "Super API com Guia da boa Alimentação";
    }

    /*
    {frutas} -> É um PATH PARAM, que é substituído pelo parâmetro 'frutas' porque...
    1. O nome é igual ("frutas")
    2. O parâmetro está anotado com @PathVariable
     */
    @GetMapping("/frutas-dia/{frutas}")
    public String analisarConsumoFrutas(@PathVariable int frutas) {
        if (frutas < 3) {
            return "Você come poucas frutas por dia!";
        } else if (frutas < 10) {
            return "Você come uma boa quantidade de frutas por dia";
        } else {
            return "Você tem uma CEASA na barriga! Parabéns!";
        }
    }

    // Crie um Endpoint de URI /alimentacao/vitamina/{fruta1}/{fruta2}
    // que, ao ser chamada, retorna a frase "Saindo uma vitamina de fruta1 com fruta2"
    @GetMapping("/vitamina/{fruta1}/{fruta2}")
    public String prepararVitamina(@PathVariable String fruta1, @PathVariable String fruta2) {
        return String.format("Saindo uma vitamina de %s com %s", fruta1, fruta2);
    }


    // Crie um Endpoint de URI /alimentacao/milkshake/{sabor}/{quantidade}/{comChantilly}
    /*
    Onde {sabor} é um texto, {quantidade} é um número inteiro e {comChantilly} é boleano.
    Ao final, deve retornar uma dessas frases:
    a) Caso a quantidade for 0 ou menos: "Onde já se viu comprar essa quantidade?!?"
    b) Caso a quantidade for maior que 0: "Seus X shakes de Y vão custar Z"
      Para calcular Z, considere que um shake é 10,00 sem chantilly e 12,00 com chantilly
     */
    @GetMapping("/milkshake/{sabor}/{quantidade}/{comChantilly}")
    public String prepararMilkShake(
            @PathVariable String sabor, @PathVariable int quantidade, @PathVariable boolean comChantilly) {
        if (quantidade < 1) {
            return "Onde já se viu comprar essa quantidade?!?";
        } else {
            return String.format("Se(us) %d shake(s) de %s vai(ão) custar R$%.2f",
                    quantidade, sabor, comChantilly ? quantidade * 12 : quantidade * 10);
        }
    }

}
