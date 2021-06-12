package tests;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import br.com.sistemaloja.conection.ConnectionMysql;
import br.com.sistemaloja.domain.Produto;

public class ProdutoTest {
	
	private final ConnectionMysql conection = new ConnectionMysql();
	
	@Test
	public void testarInsert() {
				
		Produto produto = new Produto(1, "Pc", BigDecimal.ONE, 1);

		try {

			String sql = "insert into produto (id, nome, valor, quantidade_estoque ) values (?, ?, ?, ?);";

			PreparedStatement pst = ConnectionMysql.getConexaoMySQL().prepareStatement(sql);

			pst.setInt(1, produto.getId());
			pst.setString(2, produto.getNome());
			pst.setBigDecimal(3, produto.getPreco());
			pst.setInt(4, produto.getQuantidadeEstoque());

			pst.executeUpdate();

			System.out.println("inserido com sucesso");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

}
