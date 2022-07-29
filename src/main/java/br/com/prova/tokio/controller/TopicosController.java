package br.com.prova.tokio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.tokio.controller.dto.TopicoDto;
import br.com.prova.tokio.model.Topico;


@RestController
public class TopicosController {
	
	@RequestMapping("/topicos")
	public List<TopicoDto> listar(String titulo) {

			List<Topico> topicos = null;
			return TopicoDto.converter(topicos);
	}
	
	

}
