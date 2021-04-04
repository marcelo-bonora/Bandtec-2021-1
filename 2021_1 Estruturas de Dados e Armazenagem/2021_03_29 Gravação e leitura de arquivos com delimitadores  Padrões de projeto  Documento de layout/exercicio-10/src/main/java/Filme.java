public class Filme {

    private Integer idFilme;
    private String nome;
    private Double nota;
    private String genero;
    private Integer idade;

    public Filme(Integer idFilme, String nome, Double nota, String genero, Integer idade) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "idFilme=" + idFilme +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                '}';
    }
}
