package br.com.sistemaloja.domain;

import java.time.LocalDate;

public class Cliente {
	
	private Long id;
	private String nome;
	private String endereco;
	private String cpf;
	private LocalDate dataNascimento;
	
	public Cliente() {
	
	}

	public Cliente(Long id,  String nome, String endereco, String cpf, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}



	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}

}
