package br.com.prova.tokio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.tokio.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String nome);

}