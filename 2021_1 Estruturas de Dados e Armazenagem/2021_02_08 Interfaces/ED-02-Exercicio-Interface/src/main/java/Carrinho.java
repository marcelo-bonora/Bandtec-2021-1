import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> cart = new ArrayList<>();

    public void adicionaVendavel(Vendavel v){
        this.cart.add(v);
    }

    public double calculaTotalVenda(){
        Double total = 0.0D;

        for (Vendavel v : cart){
            total += v.getValorVenda();
        }

        return total ;
    }

    public void exibirItensCarrinho(){
        System.out.println("\nLista de Itens do Carrinho: ");
        for (Vendavel v : cart){
            System.out.println("\n"+v.toString());
        }
    }

}
