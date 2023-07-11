package com.devsuperior.DSLLIST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DSLLIST.dto.GameMinDTO;
import com.devsuperior.DSLLIST.entites.Game;
import com.devsuperior.DSLLIST.repositories.GameRepository;

@Service//ele vai registar a classe "GameService" como um componente do sistema
public class GameService {
	@Autowired //chama e instancia a camada de acesso aos dados(game repository) criando uma dependencia entre elas
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();	
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();//libia do java que permite vc fazer operações com sequencias de dados
		return dto;                                                     //transforma o stream novamento em lista
	}
}
