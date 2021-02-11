import java.util.ArrayList;
import java.util.List;

public class Tributo {

    // Atributo
    private List<Tributavel> lista;

    // Construtor
    public Tributo(){
        lista = new ArrayList<Tributavel>();

    }

    // Métodos
    public void adicionaTributavel(Tributavel t){
        lista.add(t);
    }

    public void exibeTodos(){
        System.out.println("\nLista dos objetos tributaveis:");
        for(Tributavel t : lista){
            System.out.println(t);
        }
    }

    public Double calculaTotalTributo(){
        Double total = 0.0;
        for(Tributavel t : lista){
            total += t.getValorTributo();
        }
        return total;
    }
}
