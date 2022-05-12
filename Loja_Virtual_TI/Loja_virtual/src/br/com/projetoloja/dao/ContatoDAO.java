package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Contato;

//Essa classe é herança da superclasse "Conexão"
//extends=conectando na superclasse "Conexão"
//implements=implementando na interface "ICrud"
public class ContatoDAO extends Conexao implements ICrud<Contato>{

	@Override
	public String cadastrar(Contato objeto) {
		
		//Criando variável que nos ajudará a informar o usuario sobre erros
		String msg = "";
		
		//Tentando cadastrar o usuario no banco de dados:
		try {
			abrirBanco();
			
			//Consulta de inserção
			pst = conectar.prepareStatement("insert into contato(telefone,email) values (?,?)");
			
			//Passando parametros para os dados que serão cadastrados
			pst.setString(1, objeto.getTelefone());
			pst.setString(2, objeto.getTelefone());
			
			int r = pst.executeUpdate();
			
			if(r > 0)
				msg = "Contato cadastrado com sucesso";
			else
				msg = "Não foi possível cadastrar o contato";
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o contato"+e.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado"+e.getMessage();
			}
		
		finally {
			fecharBanco();
		}
		
		return msg;
	}
	
	
	

	@Override
	public List<Contato> listar() {
		
		List<Contato> listaContatos = new ArrayList<Contato>();
		try {
			abrirBanco();
			String consulta = "Select * from contato";
			
			//Preparando banco de dados para a consulta select de contato:
			pst = conectar.prepareStatement(consulta);
			
			//Inserindo os dados encontrados pela consulta no atributo rs:
			rs = pst.executeQuery();
			
			//Inserindo os dados retornados na lista de contato:
			while(rs.next()) {
				listaContatos.add(
						new Contato(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2)
								)
						);
						
			}
		}
		//Tratamento de erro do banco de dados:
		catch(SQLException e){
			e.printStackTrace();
		}
		
		//Tratamento de erros gerais:
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharBanco();
		}
		
		return listaContatos;
	}

	
	
	
	@Override
	public List<Contato> pesquisar(Contato objeto) {
		List<Contato> listaContatos = new ArrayList<Contato>();
		
		
		try {
			abrirBanco();
			
			String sqlId = "Select * from contato where idContato=?";
			
			String sqlTel = "Select * from contato where telefone like ?";
			
			String sqlEmail = "Select * from contato where email=?";
			
			
			if(objeto.getEmail()==null && objeto.getTelefone()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdContato());
			}
			else if(objeto.getEmail()==null) {
				pst = conectar.prepareStatement(sqlTel);
				pst.setString(1, objeto.getTelefone());
			}
			else {
				pst = conectar.prepareStatement(sqlEmail);
				pst.setString(1, objeto.getEmail());
			}
			
			rs = pst.executeQuery();
			while(rs.next()) {
				listaContatos.add(
						new Contato(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2)
								)
						);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}	
		
		return listaContatos;
	}
	
	

	@Override
	public String atualizar(Contato objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "update contato set telefone=?,email=? where idContato=?";
			pst = conectar.prepareStatement(sql);
			
			pst.setString(1, objeto.getTelefone());
			pst.setString(2, objeto.getEmail());
			pst.setInt(3, objeto.getIdContato());
			
			int r = pst.executeUpdate();
			
			if( r > 0)
				msg = "Contato atualizado com sucesso!";
			else
				msg = "Contato nÃ£o atualizado.";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	@Override
	public String apagar(int id) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "delete from contato where idcontato=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if( r > 0)
				msg = "O contato foi apagado.";
			else
				msg = "Contato nÃ£o apagado";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}
		return msg;
	}

}
