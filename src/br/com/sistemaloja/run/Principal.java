package br.com.sistemaloja.run;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.sistemaloja.conection.ConectionMysql;
import br.com.sistemaloja.domain.Cliente;

public class Principal {

	public static void main(String[] args) {

		/*
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		
		System.out.println("oi");

		do {

		} while (menu != 4);

	}
	*/
		ConectionMysql conection = new ConectionMysql();
		conection.getConexaoMySQL();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		
		Cliente cliente = new Cliente(2L,"Joubert", "rua x", "11111111111",
				LocalDate.now());
		
		try {
			
			String sql =  "insert into cliente (id, nome, endereco, cpf, data_nascimento) values (?, ?, ?, ?, ?);";
			
			PreparedStatement pst = conection.getConexaoMySQL().prepareStatement(sql);
			
		    pst.setLong(1, cliente.getId());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getCpf());
			pst.setDate(5, Date.valueOf(cliente.getDataNascimento()));
			
			System.out.println(sql + " " + (cliente.getId() + " " +  cliente.getNome() + " " + cliente.getEndereco() + " "
					+ cliente.getCpf() + " " + Date.valueOf(cliente.getDataNascimento() )));
			
			pst.executeUpdate(sql.toString());
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
