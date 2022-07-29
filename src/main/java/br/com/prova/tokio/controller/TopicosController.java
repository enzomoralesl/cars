package br.com.prova.tokio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.tokio.controller.dto.TopicoDto;
import br.com.prova.tokio.model.Topico;
import br.com.prova.tokio.repository.TopicoRepository;


@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> listar(String titulo) {
		if (titulo == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		}
		else {
			List<Topico> topicos = topicoRepository.findByTitulo(titulo);
			return TopicoDto.converter(topicos);
		}
	}
	
	

}