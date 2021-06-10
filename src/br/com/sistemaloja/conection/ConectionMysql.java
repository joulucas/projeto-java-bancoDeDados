package br.com.sistemaloja.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionMysql {

	public ConectionMysql() {
	}

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection
		
		try {

			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);

			// Configurando a nossa conexão com um banco de dados//

			String serverName = "localhost"; // caminho do servidor do BD
			String mydatabase = "mysql"; // nome do seu banco de dados
			String url = "jdbc:mysql://" + "localhost" + "/" + "loja";
			String username = "root"; // nome de um usuário de seu BD
			String password = "root"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);

			// Testa sua conexão//

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
			//Não conseguindo se conectar ao banco
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
	
	
	
	 //Método que fecha sua conexão//

    public static boolean fecharConexao() {

        try {
        	ConectionMysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

   //Método que reinicia sua conexão//

    public static java.sql.Connection reiniciarConexao() {

    	fecharConexao();
        return ConectionMysql.getConexaoMySQL();
    }
}
