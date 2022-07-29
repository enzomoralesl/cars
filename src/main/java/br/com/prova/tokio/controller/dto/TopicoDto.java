package br.com.prova.tokio.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.prova.tokio.model.Topico;


public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
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

	public static List<TopicoDto> converter(List<Topico> topicos) {
		//List<TopicoDto> topicosDto;
		
		/*for(int c = 0; c < topicos.size(); c++) {
			TopicoDto topicoAux = new TopicoDto(chamada dos topicos em cada c do for);
			topicosDto.add(topicoAux);
		}*/
		
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());	//mapeamento dinamico com collector
	}

}
