package br.com.projetoloja.objeto;

public class Contato {
	//Atributos da classe contato
	private int idContato;
	private String telefone;
	private String email;
	
	
	
	//Construtor1
	public Contato() {
	}

	//Construtor2
	public Contato(int idContato, String telefone, String email) {
		this.idContato = idContato;
		this.telefone = telefone;
		this.email = email;
	}
	
	
	
	//Get e Set
	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
