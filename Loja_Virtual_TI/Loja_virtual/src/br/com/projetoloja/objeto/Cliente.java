package br.com.projetoloja.objeto;

import java.util.Date;

public class Cliente {
	//Atributos da classe Cliente
	private int idCliente;
	private String nomeClienteString;
	private String cpf;
	private Sexo sexo;
	private Date cadastro;
	
	//Chamando a classe usuario
	private Usuario usuario;
	//Chamando a classe contato
	private Contato contato;
	//Chamando a classe endereco
	private Endereco endereco;
	
	
	
	
	//Construtor1
	public Cliente() {
	}

	//Construtor2
	public Cliente(int idCliente, String nomeClienteString, String cpf, Sexo sexo, Date cadastro, Usuario usuario,
			Contato contato, Endereco endereco) {
		this.idCliente = idCliente;
		this.nomeClienteString = nomeClienteString;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cadastro = cadastro;
		this.usuario = usuario;
		this.contato = contato;
		this.endereco = endereco;
	}

	
	
	//Get e Set
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeClienteString() {
		return nomeClienteString;
	}

	public void setNomeClienteString(String nomeClienteString) {
		this.nomeClienteString = nomeClienteString;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
