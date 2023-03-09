package br.com.anacorp.solo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int codigo;
	@Column(name="titulo", columnDefinition="TEXT", nullable=false)
	private String tituloLivro;
	@Column(name="autor", columnDefinition="TEXT", nullable=false)
	private String nomeAutor;
	@Column(name="ano", nullable=false)
	private int anoPubli;
	@Column(name="genero", columnDefinition="TEXT", nullable=false)
	private String generoLit;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public int getAnoPubli() {
		return anoPubli;
	}
	public void setAnoPubli(int anoPubli) {
		this.anoPubli = anoPubli;
	}
	public String getGeneroLit() {
		return generoLit;
	}
	public void setGeneroLit(String generoLit) {
		this.generoLit = generoLit;
	}
	public Livro(int codigo, String tituloLivro, String nomeAutor, int anoPubli, String generoLit) {
		super();
		this.codigo = codigo;
		this.tituloLivro = tituloLivro;
		this.nomeAutor = nomeAutor;
		this.anoPubli = anoPubli;
		this.generoLit = generoLit;
	}
	public Livro() {
		super();
	}
}
