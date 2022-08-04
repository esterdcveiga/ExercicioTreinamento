package jdbc.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection con = null;
	
	public static Connection conectar() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String senha = "123456";
		try {
			con = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void desconectar() {
		con = null;
	}	
	
}

