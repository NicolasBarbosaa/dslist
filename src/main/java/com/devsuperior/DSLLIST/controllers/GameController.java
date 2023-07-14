package com.devsuperior.DSLLIST.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DSLLIST.dto.GameDTO;
import com.devsuperior.DSLLIST.dto.GameMinDTO;
import com.devsuperior.DSLLIST.services.GameService;

@RestController
@RequestMapping(value= "/games") //  criando o caminho que vai ser respondido na API
public class GameController {

	@Autowired
	private GameService gameservice;
	
	@GetMapping(value= "/{id}") 
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameservice.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameservice.findAll();
		return result;
	}
}
