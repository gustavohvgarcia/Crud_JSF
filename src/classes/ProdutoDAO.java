package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.ConnectionFactory;

	
	public class ProdutoDAO {
	
			private Connection connection;
	
			public ProdutoDAO(){
				this.connection = new ConnectionFactory().getConnection();
			}
	
//metodo responsavel por inserir na tabela um novo produto
public void inserir (Produto produto) {
		
		String sql = 
				"INSERT INTO produto (NOME, PRECO, QUANTIDADE) VALUES (?,?,?)";
	
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1, produto.getNome());
		prstate.setDouble(2, produto.getPreco());
		prstate.setInt(3, produto.getQuantidade());
		
		
		prstate.execute();
		
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}//fim do metodo inserir

//metodo responsavel por buscar um contato no banco de dados pelo nome
public List<Produto> buscarPorNome(String nome){
	
	String sql = 
			"SELECT * FROM produto WHERE NOME LIKE UPPER(?)";
	
	List<Produto> produtos = new ArrayList<Produto>();
	
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1, new String("%"+nome+"%").toUpperCase());
				
		ResultSet resultado = 
				prstate.executeQuery();
		
		while (resultado.next()){
			Produto produto = new Produto();
			produto.setId(resultado.getLong("ID"));
			produto.setNome(resultado.getString("NOME"));
			produto.setPreco(resultado.getDouble("PRECO"));
			produto.setQuantidade(resultado.getInt("QUANTIDADE"));
			
			produtos.add(produto);
		}
		resultado.close();
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	return produtos;
	
}
public void excluir(Long id){
	
	String sql = 
			"DELETE FROM produto WHERE ID=?";
	
	
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setLong(1, id);
		
		prstate.execute();
		
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
			
	
}

public void alterar(Produto produto){
	
	String sql = 
			"UPDATE produto SET NOME=?, PRECO=?, QUANTIDADE=? WHERE ID=?";
	
	
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1, produto.getNome());
		prstate.setDouble(2, produto.getPreco());
		prstate.setInt(3, produto.getQuantidade());
		prstate.setLong(4, produto.getId());
		
		prstate.execute();
		
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
			
	
}


}//fim da classe
	
	
