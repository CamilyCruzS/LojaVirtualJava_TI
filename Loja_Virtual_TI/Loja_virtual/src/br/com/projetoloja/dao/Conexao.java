package br.com.projetoloja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Superclasse que se conecta ao banco de dados
//N�o pode ser instanciada,pois � uma classe abstrata
public class Conexao {
	//Estabelecer conexao com o banco:
	public Connection conectar = null;
	
	//Consultas no DB: Atributo para a classe PreparedStatment
	public PreparedStatement pst = null;
	
	//Guardar dados da consulta select: Atributo da classe ResultSet
	public ResultSet rs = null;
	
	//Abaixo criamos a explica��o do m�todo. Para criar digite /** e aperte enter
	/**
	 * M�todo abrirBanco:<br><br>
	 * Realiza a abertura da conex�o com banco de dados <b>MySQL</b>
	 */

	@SuppressWarnings("deprecation")
	public void abrirBanco() {
		
		
		try {
			
			//registrar o driver comunica��o
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Instancia da classse conectar
			conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_clinica?userTimezone=true&serverTimezone=UTC","root","");
		}
		
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Para tratar erro no MySQL:
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Para tratar erros gerais:
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * M�todo fecharBanco: <br><br>
	 * Realiza o fechamento da conex�o com banco de dados <b>MySQL</b>
	 */
	public void fecharBanco() {
		
		try {
			//Tentar realizar o fechamento do banco de dados:
			conectar.close();
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}












