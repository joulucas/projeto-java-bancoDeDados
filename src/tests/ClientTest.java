package tests;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import br.com.sistemaloja.conection.ConnectionMysql;
import br.com.sistemaloja.domain.Cliente;

public class ClientTest {
	
	private final ConnectionMysql conection = new ConnectionMysql();

	@Test
	public void testarInsert() {
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
		Date y=new Date(0);
		System.out.println(sdf1.format(y));
		
		ConnectionMysql.getConexaoMySQL();
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

		Cliente cliente = new Cliente(5L, "Joubert", "rua x", "11111111111",y );

		try {

			String sql = "insert into cliente (id, nome, endereco, cpf, data_nascimento) values (?, ?, ?, ?, ?);";

			PreparedStatement pst = ConnectionMysql.getConexaoMySQL().prepareStatement(sql);

			pst.setInt(1, cliente.getId().intValue());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getCpf());
			pst.setDate(5, (Date) cliente.getDataNascimento());

			pst.executeUpdate();

			System.out.println("inserido com sucesso");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

	@Test
	public void testarSelect() {
		
		ConnectionMysql.getConexaoMySQL();

		String query = "select id, nome, cpf, endereco, data_nascimento from cliente where id = 1";

		try {
			Statement stmt = conection.getConexaoMySQL().createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String endereco = rs.getString("endereco");
				Date dataNascimento = rs.getDate("data_nascimento");

				System.out.println(id + " " + nome + " " + cpf + " " + endereco + " " + dataNascimento);

			}

		} catch (SQLException e) {
			e.getMessage();
		}		

	}
	@Test
	public void testarDelete() {
		
		String delete = "delete from cliente where id = 4";
		
		try {
			PreparedStatement preparedStatement = conection.getConexaoMySQL().prepareStatement(delete);
			
			boolean deletou = preparedStatement.execute();
			
			if(deletou) {
				System.out.println("deletado!");
			}else {
				System.out.println("nenhum registro encontrado");
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testarUpdate() {
		String update = "update  cliente set nome = ? where id = 1";
		try {
			PreparedStatement preparedStatement = conection.getConexaoMySQL().prepareStatement(update);
			
			preparedStatement.setString(1, "joub");
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
