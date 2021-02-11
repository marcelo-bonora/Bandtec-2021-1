public class Perfume extends Produto{

    // Atributo
    private String fragancia;

    // Construtor
    public Perfume(Integer codigo, String descricao, Double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    // Métodos
    @Override
    public Double getValorTributo() {
        return this.getPreco() * 0.27;
    }

    // Métodos toString()

    @Override
    public String toString() {
        return "Perfume{" +
                "fragancia='" + fragancia + '\'' +
                ", tributo=" + getValorTributo() +
                "} " + super.toString();
    }
}
