package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import br.com.sistemaloja.conection.ConectionMysql;
import br.com.sistemaloja.domain.Cliente;

public class ConnectionTest {

	@Test
	public void testarInsert() {
		ConectionMysql conection = new ConectionMysql();
		conection.getConexaoMySQL();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

		Cliente cliente = new Cliente(3L, "Joubert", "rua x", "11111111111", LocalDate.now());

		try {

			String sql = "insert into cliente (id, nome, endereco, cpf, data_nascimento) values (?, ?, ?, ?, ?);";

			PreparedStatement pst = conection.getConexaoMySQL().prepareStatement(sql);

			pst.setInt(1, cliente.getId().intValue());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getCpf());
			pst.setDate(5, Date.valueOf(cliente.getDataNascimento()));

			pst.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

}
