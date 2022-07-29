package br.com.prova.tokio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.tokio.model.Topico;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByTitulo(String titulo);

}