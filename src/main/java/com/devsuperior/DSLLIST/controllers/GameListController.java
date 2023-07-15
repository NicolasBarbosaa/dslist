package com.devsuperior.DSLLIST.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DSLLIST.dto.GameListDTO;
import com.devsuperior.DSLLIST.services.GameListService;

@RestController
@RequestMapping(value= "/lists") //  criando o caminho que vai ser respondido na API
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
