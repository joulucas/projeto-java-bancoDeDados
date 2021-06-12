package br.com.sistemaloja.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

	public ConnectionMysql() {
	}

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection
		
		try {

			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);

			String url = "jdbc:mysql://" + "localhost" + "/" + "loja";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				System.out.println(("STATUS--->Conectado com sucesso!"));
			} else {
				System.out.println("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;

		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
	
    public static boolean fecharConexao() {

        try {
        	ConnectionMysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection reiniciarConexao() {
    	fecharConexao();
        return ConnectionMysql.getConexaoMySQL();
    }
}
