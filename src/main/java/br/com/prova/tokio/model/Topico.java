package br.com.prova.tokio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Topico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	@Enumerated(EnumType.STRING)
	private Status status = Status.SEM_RESPOSTA;
	@ManyToOne
	private Usuario usuario;
	
	public Topico() {
	}
	
	public Topico(String titulo, String mensagem, Usuario usuario) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.usuario = usuario;
	}
	
	//construtor default e o construtor que fica mais facil de utilizar para o form
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
	

}
