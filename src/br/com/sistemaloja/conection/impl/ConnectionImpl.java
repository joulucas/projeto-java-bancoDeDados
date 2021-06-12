package br.com.sistemaloja.conection.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import br.com.sistemaloja.conection.ConnectionMysql;
import br.com.sistemaloja.domain.Cliente;

public class ConnectionImpl {
	
	public void inserirCliente(Cliente cliente) {
		
		ConnectionMysql.getConexaoMySQL();
		
		try {

			String sql = "insert into cliente (id, nome, endereco, cpf, data_nascimento) values (?, ?, ?, ?, ?);";

			PreparedStatement pst = ConnectionMysql.getConexaoMySQL().prepareStatement(sql);
			
			cliente.setId(10l);

			pst.setInt(1, cliente.getId().intValue());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getCpf());
			pst.setDate(5, (Date) new Date(cliente.getDataNascimento().getTime()));

			pst.executeUpdate();
			pst.close();

			System.out.println("inserido com sucesso");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
}
