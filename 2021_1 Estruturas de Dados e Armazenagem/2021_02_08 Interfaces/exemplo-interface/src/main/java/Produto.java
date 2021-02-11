public abstract class Produto implements Tributavel {

    // Atributos
    private Integer codigo;
    private String descricao;
    private Double preco;


    // Construtor
    public Produto(Integer codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }


    // Métodos
    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    // Métodos getPreço()

    public Double getPreco() {
        return preco;
    }
}
