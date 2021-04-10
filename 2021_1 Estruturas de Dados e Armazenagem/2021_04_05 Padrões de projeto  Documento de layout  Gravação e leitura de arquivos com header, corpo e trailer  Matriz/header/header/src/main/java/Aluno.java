public class Aluno {

    private String curso;
    private String ra;
    private String nome;
    private String disciplina;
    private Double media;
    private Integer qtdFaltas;

    public Aluno(String curso, String ra, String nome, String disciplina, Double media, Integer qtdFaltas) {
        this.curso = curso;
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.media = media;
        this.qtdFaltas = qtdFaltas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Integer getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(Integer qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }
}
