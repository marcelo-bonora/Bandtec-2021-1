public class Filme {

    // Atributos
    private int idFilme;
    private String nome;
    private double nota;
    private String genero;
    private int idade;

    // Construtor
    public Filme(int idFilme, String nome, double nota, String genero, int idade) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    // Métodos

    @Override
    // Esse toString() já está fazendo a saída formatada
    public String toString() {
        return String.format("%04d %-20s %-15s %4d %4.2f", idFilme, nome, genero, idade, nota);

    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
