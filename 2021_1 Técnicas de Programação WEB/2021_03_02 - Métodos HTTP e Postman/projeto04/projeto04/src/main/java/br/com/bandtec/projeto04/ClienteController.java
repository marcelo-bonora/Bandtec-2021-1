package br.com.bandtec.projeto04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes") // recurso: clientes
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente("Ricão", 50_000.0));
        clientes.add(new Cliente("Médiozão", 10_000.0));
        clientes.add(new Cliente("Pobrinho", 1_500.0));
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable int id) {
        if (id < clientes.size()) {
            return clientes.get(id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id) {
        if (id < clientes.size()) {
            clientes.remove(id);
            return "Cliente excluído com sucesso!";
        } else {
            return "Cliente não encontrado :.( ";
        }
    }

    @PostMapping
    public String postCliente(@RequestBody Cliente novoCliente) {
        clientes.add(novoCliente);
        return "Cliente cadastrado com sucesso!";
    }

    @GetMapping("/mais-ricos")
    public List<Cliente> getMaisRicos() {
        return clientes.stream()
                .filter(cliente -> cliente.getRenda() > 15_000.0)
                .collect(Collectors.toList());
    }
}



