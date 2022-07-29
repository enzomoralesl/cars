package br.com.prova.tokio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.prova.tokio.model.Topico;
import br.com.prova.tokio.model.Usuario;


public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private Usuario usuario;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.usuario = topico.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	

	public static List<TopicoDto> converter(List<Topico> topicos) {
		//List<TopicoDto> topicosDto;
		
		/*for(int c = 0; c < topicos.size(); c++) {
			TopicoDto topicoAux = new TopicoDto(chamada dos topicos em cada c do for);
			topicosDto.add(topicoAux);
		}*/
		
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());	//mapeamento dinamico com collector que aprendi em curso
	}

}
