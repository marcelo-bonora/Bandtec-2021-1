package br.com.bandtec.projetojpa03.repositorio;

import br.com.bandtec.projetojpa03.dominio.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
