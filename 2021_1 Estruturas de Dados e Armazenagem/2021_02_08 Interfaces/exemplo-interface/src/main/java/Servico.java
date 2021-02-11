public class Servico implements Tributavel{

    // Atributos
    private String descricao;
    private Double preco;

    // Construtor
    public Servico(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    // Métodos


    @Override
    public Double getValorTributo() {
        return this.preco * 0.12;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", tributo=" + getValorTributo() +
                "} ";
    }
}
