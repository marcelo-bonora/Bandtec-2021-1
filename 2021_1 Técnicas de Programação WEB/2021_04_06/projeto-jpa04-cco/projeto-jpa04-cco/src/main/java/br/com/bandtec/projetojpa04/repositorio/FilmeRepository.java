package br.com.bandtec.projetojpa04.repositorio;

import br.com.bandtec.projetojpa04.dominio.Filme;
import br.com.bandtec.projetojpa04.resposta.FilmeSimplesResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    /*
Exemplos de Dynamic Finders do Spring Data JPA (maiores detalhes, consultar a apostila)
 */
    List<Filme> findByDiretor(String diretor);

    List<Filme> findByDiretorAndClassico(String diretor, boolean classico);

    List<Filme> findByClassicoTrue();

    List<Filme> findByDiretorContainsAndClassico(String diretor, boolean classico);

    /*
@Query -> permite criar consultas customizadas usado JPQL (não é SQL!)
Note que só funciona se escrevermos 'Filme' com 'F', pois é o nome da classe ;)
No exemplo abaixo solicitamos todos os campos de todos os registros de Filme.
O 'f' é só o 'alias' da tabela na consulta

O retorno é uma List de FilmeSimplesResposta. Isso foi possível
porque a FilmeSimplesResposta tem um construtor que recebe Filme
 */
    @Query("select f from Filme f") // é o mesmo que 'select * from filme'
    List<FilmeSimplesResposta> findAllSimples();
    // o nome 'findAll....' foi só pra ficar parecido com os nomes padrão da JpaRepository do Spring ^^'

    // NÃO seria possível retornar uma lista de FilmeSimplesResposta usando os Dynamic Finders!

    @Query("select f from Filme f") // é o mesmo que 'select * from filme'
    List<Filme> findAllNormal();
    // não somos obrigados a usar outra classe nesse caso! Poderia ser uma lista de filme mesmo

}
