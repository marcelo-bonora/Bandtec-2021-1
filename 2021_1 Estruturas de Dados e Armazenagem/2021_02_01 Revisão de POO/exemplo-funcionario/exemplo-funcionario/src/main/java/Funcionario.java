/* Classe abstrata Funcionario
   Servirá de base para a criação das classes concretas Engenheiro, Vendedor e Horista
 */
public abstract class Funcionario {

    // Atributos comuns a todos os funcionários
    // Poderia ter mais atributos além desses (aqui é só um exemplo)
    private String cpf;     // cpf do funcionário
    private String nome;    // nome do funcionário

    // Construtor
    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Métodos

    // Método abstrato calcSalario()
    // Obriga que as classes concretas herdeiras desta classe implementem este método
    public abstract Double calcSalario();

    // Método toString()
    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }


}
