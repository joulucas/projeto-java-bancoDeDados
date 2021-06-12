package br.com.sistemaloja.domain;

import java.math.BigDecimal;

public class Produto {
	
	public Produto() {
	}
	
	public Produto(int id, String nome, BigDecimal preco, int quantidadeEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	private int id;
	private String nome;
	private BigDecimal preco;
	private int quantidadeEstoque;
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
