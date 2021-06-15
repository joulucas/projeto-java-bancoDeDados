package br.com.sistemaloja.run;

import java.text.ParseException;
import java.util.Scanner;

import br.com.sistemaloja.business.impl.ClienteServiceImpl;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc =  new Scanner(System.in);
		int menu = 0;
		
			System.out.println("escolha umas as opções ");

			System.out.println("----  1 para cadastrar um cliente");
			System.out.println("----  2 ver lista de produtos");
			System.out.println("----  3fazer um pedido");				
		
		menu = sc.nextInt();
		
		do {
			
			switch (menu) {
			case 1:
					
				ClienteServiceImpl service = new ClienteServiceImpl();
				service.prepararClienteParaCadastro();
				System.out.println("cliente cadastrado com sucesso!");
				
				break;

			default:
				break;
			}
			
			
		} while (menu != 20);
		
		 

	}
	
	
}
