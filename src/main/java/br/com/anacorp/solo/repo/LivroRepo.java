package br.com.anacorp.solo.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import br.com.anacorp.solo.model.Livro;

public interface LivroRepo extends CrudRepository<Livro, Integer> {
	public ArrayList<Livro> findByOrderByTituloLivro();
	public ArrayList<Livro> findByTituloLivroContaining(String palavra);
}
