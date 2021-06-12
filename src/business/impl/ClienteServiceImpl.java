package business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import br.com.sistemaloja.conection.impl.ConnectionImpl;
import br.com.sistemaloja.domain.Cliente;
import business.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	
	
	public void prepararClienteParaCadastro() throws ParseException {
		
		Cliente clientePreparo = new Cliente();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("informe o nome");
		clientePreparo.setNome(sc.next());
		System.out.println("informe o cpf");
		clientePreparo.setCpf(sc.next());
		System.out.println("informe o endereco");
		clientePreparo.setEndereco(sc.next());
		
		System.out.println("informe a Data Nascimento");
		String data = sc.next();
				
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = df.parse(data);
		clientePreparo.setDataNascimento(dt);
		
		cadastrarCliente(clientePreparo);
		
		
	}

	@Override
	public Cliente cadastrarCliente(Cliente clientePreparado) {
		
		Cliente cliente  = new Cliente();
		
		cliente.setNome(clientePreparado.getNome());
		cliente.setEndereco(clientePreparado.getEndereco());
		cliente.setCpf(clientePreparado.getCpf());
		cliente.setDataNascimento(clientePreparado.getDataNascimento());
		
		ConnectionImpl dao = new ConnectionImpl();
		dao.inserirCliente(cliente);
	
		return cliente;
	}

}
