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
		
		Cliente cliente = new Cliente(3L,"Joubert", "rua x", "11111111111",LocalDate.now());
		
		try {
			
			String sql =  "insert into cliente (id, nome, endereco, cpf, data_nascimento) values (?, ?, ?, ?, ?);";
			//String sql2 =  "insert into cliente (id, nome, endereco, cpf, data_nascimento) "
			//		+ "values (2, 'joubert', 'rua x', '242424', '2020-01-01');";
			
			PreparedStatement pst = conection.getConexaoMySQL().prepareStatement(sql);
			
		    pst.setInt(1, cliente.getId().intValue());
			//pst.setString(1, cliente.getId().toString());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getCpf());
			pst.setDate(5, Date.valueOf(cliente.getDataNascimento()));
			//pst.setString(5, "2020-10-10");
			
			//System.out.println(sql + " " + (cliente.getId() + " " +  cliente.getNome() + " " + cliente.getEndereco() + " "
			//		+ cliente.getCpf() + " " + Date.valueOf(cliente.getDataNascimento() )));
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
