package br.com.bandtec.projetojpa03.repositorio;

import br.com.bandtec.projetojpa03.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
