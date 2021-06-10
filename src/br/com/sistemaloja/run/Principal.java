package br.com.sistemaloja.run;

import java.util.Scanner;

import br.com.sistemaloja.conection.ConectionMysql;

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
	}
}
