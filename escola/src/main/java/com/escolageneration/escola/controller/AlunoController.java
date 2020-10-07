package com.escolageneration.escola.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolageneration.escola.model.Aluno;
import com.escolageneration.escola.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	// Método findAll
	@GetMapping
	public ResponseEntity<List<Aluno>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	// Método findId
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> GetByIdAluno(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	// Método postAluno
	@PostMapping
	public ResponseEntity<Aluno> post (@RequestBody Aluno tb_aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tb_aluno));
	}
	// Método putAluno
	@PutMapping
	public ResponseEntity<Aluno> put (@RequestBody Aluno tb_aluno){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tb_aluno));
	}
	// Método deleteAluno
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
