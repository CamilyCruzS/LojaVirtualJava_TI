package br.com.projetoloja.dao;

import java.util.List;

//Essa interface é usada em todas as classes do pacote objeto
//T-Faz com que qualquer classe possa chamar essa interface
public interface ICrud<T> {
	String cadastrar(T objeto);
	//listar tudo:
	List<T> listar();
	//listar algum dado especifico:
	List<T> pesquisar(T objeto);
	String atualizar(T objeto);
	String apagar(int id);
}
