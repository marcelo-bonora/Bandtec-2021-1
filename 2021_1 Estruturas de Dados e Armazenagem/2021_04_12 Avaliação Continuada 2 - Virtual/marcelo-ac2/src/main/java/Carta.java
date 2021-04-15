public class Carta {

    private Integer idCarta;
    private String nome;
    private Double preco;
    private String tipo;
    private String raridade;
    private String codigo;

    public Carta(Integer idCarta, String nome, Double preco, String tipo, String raridade, String codigo) {
        this.idCarta = idCarta;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.raridade = raridade;
        this.codigo = codigo;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "idCarta=" + idCarta +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                ", raridade='" + raridade + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
