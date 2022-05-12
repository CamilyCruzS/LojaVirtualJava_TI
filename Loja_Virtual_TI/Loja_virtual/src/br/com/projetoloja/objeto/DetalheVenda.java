package br.com.projetoloja.objeto;

public class DetalheVenda {
	//Atributos da classe Venda
	private int idDetelheVenda;
	private Venda venda;
	private Produto produto;
	private int quantidade;
	
	//Construtor1
	public DetalheVenda() {
	}

	//Construtor2
	public DetalheVenda(int idDetelheVenda, Venda venda, Produto produto, int quantidade) {
		this.idDetelheVenda = idDetelheVenda;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}


	
	//Get e Set
	public int getIdDetelheVenda() {
		return idDetelheVenda;
	}


	public void setIdDetelheVenda(int idDetelheVenda) {
		this.idDetelheVenda = idDetelheVenda;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
