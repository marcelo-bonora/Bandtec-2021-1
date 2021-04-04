package br.com.bandtec.projetojpa03.dominio;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.bean.validation.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // É possível usar mais de uma anotação de validação
    // @NotBlank -> indica que o nome não pode ser nem vazio nem composto apenas de espaços em branco e nem null
    @NotBlank // é a do pacote javax.validation.constraints
    // @NotEmpty -> não permite texto vazio
    // @NotEmpty // é a do pacote javax.validation.constraints
    @Size(min = 2, max = 40)
    @NotNull // é a do pacote javax.validation.constraints
    private String nome;


    @Positive // indica que o campo só aceita maior que 0
    // @PositiveOrZero // essa deixa a partir do 0
    @NotNull // é a do pacote javax.validation.constraints
    private Double custoProducao;


    @Past // indica que a data tem que ser passada (não pode ser nem hoje!)
    // @PastOrPresent // essa deixa até "hoje"
    private LocalDate lancamento; // Formato ISO: aaaa-mm-dd

 /*
 @Pattern -> Valida pelo uso de RegEx (Regular Expressions - "Expressões Regulares")
 No exemplo abaixo são válidos:
 (12)1234-1234 OU
 (12)12345-1234
  */
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
    private String telefoneDiretor;

    @CPF
    @Column(name = "nro_cpf_dir", length = 11) // permite definir mais detalhes do ORM do campo
    private String cpfDiretor;

    @CNPJ
    private String cnpjProdutora;

    public String getTelefoneDiretor() {
        return telefoneDiretor;
    }

    public void setTelefoneDiretor(String telefoneDiretor) {
        this.telefoneDiretor = telefoneDiretor;
    }

    public String getCpfDiretor() {
        return cpfDiretor;
    }

    public void setCpfDiretor(String cpfDiretor) {
        this.cpfDiretor = cpfDiretor;
    }

    public String getCnpjProdutora() {
        return cnpjProdutora;
    }

    public void setCnpjProdutora(String cnpjProdutora) {
        this.cnpjProdutora = cnpjProdutora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(Double custoProducao) {
        this.custoProducao = custoProducao;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }
}
