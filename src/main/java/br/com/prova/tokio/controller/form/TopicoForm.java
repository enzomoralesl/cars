package br.com.prova.tokio.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.prova.tokio.model.Topico;
import br.com.prova.tokio.model.Usuario;
import br.com.prova.tokio.repository.UsuarioRepository;


public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeUser;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public Topico converter(UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findByNome(nomeUser);
		return new Topico(titulo, mensagem, usuario);
	}

}
