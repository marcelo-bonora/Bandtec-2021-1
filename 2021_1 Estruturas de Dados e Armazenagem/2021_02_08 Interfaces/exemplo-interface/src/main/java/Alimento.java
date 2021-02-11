public class Alimento extends Produto{
    // Atributo
    private  Integer quantVitamina;

    // Construtor

    public Alimento(Integer codigo, String descricao, Double preco, Integer quantVitamina) {
        super(codigo, descricao, preco);
        this.quantVitamina = quantVitamina;
    }

    // Métodos

    // Implementação do método getValorTributo() - da interface Tributavel

    @Override
    public Double getValorTributo() {
        return this.getPreco() * 0.15;
    }

    // Métodos toString()

    @Override
    public String toString() {
        return "Alimento{" +
                "quantVitamina=" + quantVitamina +
                ", tributo=" + getValorTributo() +
                "} " + super.toString();
    }
}
