package br.com.anacorp.solo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.anacorp.solo.model.Livro;
import br.com.anacorp.solo.repo.LivroRepo;

@RestController
public class LivroController {
	@Autowired
	private LivroRepo repo;
	
	@GetMapping("/")
	public String sayHello() {
		return "Bem vindo ao repositorio de Livros";
	}
	
	@GetMapping("/livros")
	public ArrayList<Livro> recuperarTodos(){
		ArrayList<Livro> lista;
		lista = (ArrayList<Livro>)repo.findByOrderByTituloLivro();
		return lista;
	}
	
	@GetMapping("/livros/busca")
	public ResponseEntity<?> buscarTituloPorPalavra(@RequestParam(name="palavra") String palavra){
		ArrayList<Livro> lista = repo.findByTituloLivroContaining(palavra);
		if(lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/livro/{codigo}")
	public ResponseEntity<Livro> recuperarPorCodigo(@PathVariable int id){
		Livro livro = repo.findById(id).orElse(null);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/livro")
	public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro l){
		Livro livro = repo.save(l);
		if (livro != null) {
			return ResponseEntity.status(201).body(livro);
		}
		return ResponseEntity.notFound().build();
	}
}
