package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://35.223.159.189:3306/"
					+ "produtos?useTimezone=true&serverTimezone=America/"
					+ "Sao_Paulo"
					+ "&allowPublicKeyRetrieval=true&useSSL=false", 
					"aluno", "aluno2021");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
