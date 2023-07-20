package com.devsuperior.DSLLIST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DSLLIST.dto.GameListDTO;
import com.devsuperior.DSLLIST.entites.GameList;
import com.devsuperior.DSLLIST.projections.GameMinProjection;
import com.devsuperior.DSLLIST.repositories.GameListRepository2;
import com.devsuperior.DSLLIST.repositories.GameRepository;

@Service//ele vai registar a classe "GameService" como um componente do sistema
public class GameListService {
	@Autowired //chama e instancia a camada de acesso aos dados(game repository) criando uma dependencia entre elas
	private GameListRepository2 gameListRepository;
	
	@Autowired GameRepository gamerepository;
	
	
 
	@Transactional(readOnly = true) 	
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();	
		return result.stream().map(x -> new GameListDTO(x)).toList();//libia do java que permite vc fazer operações com sequencias de dados
		                                                   //transforma o stream novamento em lista
	}
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List <GameMinProjection> list = gamerepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex ,obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex:destinationIndex;
		int max= sourceIndex < destinationIndex ?  destinationIndex:sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
