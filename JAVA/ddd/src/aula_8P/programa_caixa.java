package aula_8P;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class programa_caixa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		
		int opcao;
		
		do {
			System.out.printf("===> Sistema de Cadastro de Clientes <===\n\n");
	           System.out.printf("Escolha uma opção:\n");          
	           System.out.printf("1 - Incluir \n" +
	                             "2 - Deosito \n" +
	                             "3 - Saque \n" +
	                             "4 - transferencia \n" +
	                             "5 - Consulta de saldo \n" +
	                             "6 - Sair\n");

		}while( (opcao >= 1) && (opcao <= 4) );
		

	}

}
