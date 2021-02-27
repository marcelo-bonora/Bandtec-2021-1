public class DVD  extends Produto{

    private String nome;
    private String gravadora;

    public DVD(Integer codigo, Double precoCusto, String nome, String gravadora) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.gravadora = gravadora;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    @Override
    public Double getValorVenda() {
        return getPrecoCusto() * 1.2;
    }

    @Override
    public String toString() {
        return "DVD{nome=" + getNome() + ", gravadora=" + getGravadora() +  ", ValorVenda=" + getValorVenda() + "} " + super.toString();
    }
}
