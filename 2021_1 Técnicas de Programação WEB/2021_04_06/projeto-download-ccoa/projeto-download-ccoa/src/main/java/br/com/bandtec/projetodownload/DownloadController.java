package br.com.bandtec.projetodownload;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/downloads")
public class DownloadController {

    /*
Por padrão o Spring Boot devolve o content-type "application/json"
Uma exceção é quando o corpo é uma String, neste caso devolve o content-type "text/plain"
 */
    @GetMapping("/um")
    public ResponseEntity getUm() {
        return ResponseEntity.status(200).body("{'nome':'jé maria'}");
    }

    /*
O atributo 'produces' indica o 'Content-Type' da resposta;
Porém ele só funciona se usarmos a anotação @ReponseBody
 */
    @GetMapping(value = "/arquivo-loko", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity getLoko() {
        return ResponseEntity.ok("Só que não!");
        // return ResponseEntity.status(200).body("Só que não!");
    }

    @GetMapping(value = "/zip-loko", produces="application/zip")
    @ResponseBody
    public ResponseEntity getZip() {

        // é possível definir headers (cabeçalhos) criando um HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        // no objeto do tipo HttpHeaders, adicione um header com o método .add("nome", "valor")
        headers.add("Content-Disposition", "attachment; filename=lokao.zip");
        headers.add("Lady-Gaga", "Ulálá");

        return ResponseEntity.status(200).headers(headers).body("Conteúdo Zip Fake");
    }
}
