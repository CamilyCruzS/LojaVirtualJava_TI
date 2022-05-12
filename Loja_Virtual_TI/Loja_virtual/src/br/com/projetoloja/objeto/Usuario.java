package br.com.projetoloja.objeto;

public class Usuario {
//Atributos classe usuario
	private int idUsuario;
	private String nomeUsuario;
	private String senha;
	private String foto;
		
	
//Construtor1: inicializa a classe (gerado)	
public Usuario() {
	
	}


//Construtor2 (gerado)
public Usuario(int idUsuario, String nomeUsuario, String senha, String foto) {
	this.idUsuario = idUsuario;
	this.nomeUsuario = nomeUsuario;
	this.senha = senha;
	this.foto = foto;
}


//Get e Set(Métodos para passagem de dados):
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
