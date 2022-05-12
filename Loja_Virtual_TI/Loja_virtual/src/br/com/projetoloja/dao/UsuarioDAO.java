package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Usuario;

public class UsuarioDAO extends Conexao implements ICrud<Usuario>{

	
	//CADASTRO
	@Override
	public String cadastrar(Usuario objeto) {
		
		String msg = "";
		try {
			//Abrindo banco
			abrirBanco();
			String sql = "insert into usuario(nomeusuario,senha,foto)values(?,?,?)";
			
			//Preparando p/ execu��o da consulta
			pst = conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//Par�metros para execu��o da consulta
			//OBS: Os par�metros devem ser colocados no lugar do ponto de interroga��o
			pst.setString(1,objeto.getNomeUsuario());
			pst.setString(2, objeto.getSenha());
			pst.setString(3,objeto.getFoto());
			
			int r = pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			
			if(r>0)
				if(rs.next())
					msg=String.valueOf(rs.getInt(1));
			else
				msg="N�o foi poss�vel cadastrar o usu�rio";			
		}
		
		//Tratamento de erro do SQL
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o usu�rio. "+e.getMessage();
		}
		
		//Tratamento de erro inesperado
		catch (Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		
		//Fechando banco
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	
	
	
	//USU�RIO (LISTAR USU�RIOS)
	@Override
	public List<Usuario> listar() {
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			abrirBanco();
			String sql = "Select * from usuario";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar dados dos usuarios na lista
			while(rs.next()) {
				listaUsuario.add(
						new Usuario(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getString(3)
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
		
		return listaUsuario;
	}

	
	
	@Override
	public List<Usuario> pesquisar(Usuario objeto) {

		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			abrirBanco();
			String sqlId = "Select * from usuario where idUsuario=?";
			String sqlUsuario = "Select * from usuario where nomeusuario=?";
			
			if(objeto.getNomeUsuario()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdUsuario());
			}
			else {
				pst = conectar.prepareStatement(sqlUsuario);
				pst.setString(1, objeto.getNomeUsuario());
			}
			rs = pst.executeQuery();
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaUsuario.add(
						new Usuario(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getString(3)
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
		
		return listaUsuario;

	}
	
	
	
	
	//ATUALIZAR (UPDATE)
	@Override
	public String atualizar(Usuario objeto) {
		String msg = "";
		try {
			//Abrindo banco
			abrirBanco();
			String sql = "update usuario set nomeusuario=?,senha=?,foto=? where idUsuario=?";
			//Preparando p/ execu��o da consulta
			pst = conectar.prepareStatement(sql);
			
			//Par�metros para execu��o da consulta
			//OBS: Os par�metros devem ser colocados no lugar do ponto de interroga��o
			pst.setString(1,objeto.getNomeUsuario());
			pst.setString(2, objeto.getSenha());
			pst.setString(3,objeto.getFoto());
			pst.setInt(4, objeto.getIdUsuario());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Atualização realizada com sucesso!";
			else
				msg="Não foi possível atualizar o usuário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar atualizar o usuário. "+e.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	
	
	//APAGAR (DELETE)
	@Override
	public String apagar(int id) {
		
		String msg = "";
		try {
			abrirBanco();
			String sql = "Delete from usuario where idUsuario=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if(r > 0)
				msg = "Usuário apagado com sucesso!";
			else
				msg="Não foi possível apagar o usuário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar apagar o usuário. "+e.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

}




































