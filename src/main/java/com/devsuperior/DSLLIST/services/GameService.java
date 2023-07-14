package com.devsuperior.DSLLIST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DSLLIST.dto.GameDTO;
import com.devsuperior.DSLLIST.dto.GameMinDTO;
import com.devsuperior.DSLLIST.entites.Game;
import com.devsuperior.DSLLIST.repositories.GameRepository;

@Service//ele vai registar a classe "GameService" como um componente do sistema
public class GameService {
	@Autowired //chama e instancia a camada de acesso aos dados(game repository) criando uma dependencia entre elas
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)/*ele garante que a operação com o banco vai acontecer conforme
	obedecendo os principios das transações.   não vai fazer nenhuma peração de
	 escrita, para ficar mais rápido*/
	public GameDTO findById(long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();	
		return result.stream().map(x -> new GameMinDTO(x)).toList();//libia do java que permite vc fazer operações com sequencias de dados
		                                                   //transforma o stream novamento em lista
	}
}
