package bancoherança;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;



public class Programa {


    public static void main(String[] args) throws IOException{
        Scanner ler = new Scanner(System.in);
        HashMap<String, ContaBancaria> map = new HashMap<String, ContaBancaria>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();


        int opcao;
        int id;
        Cliente cli;
        int indexCliente;
        int id_cliente;
        double valor;
        int indexClienteOrigem;
        int indexClienteDestino;
        int id_cliente_origem;
        int id_cliente_destino;
        Cliente cli_origem;
        Cliente cli_destino;
       
        do {        
           System.out.printf("===> Macgyver Internet Banking <===\n\n");
           System.out.printf("Escolha uma opção:\n");          
           System.out.printf("1 - Criar cliente e conta \n" +
                             "2 - Dep�sito \n" +
                             "3 - Saque \n" +
                             "4 - Transferência \n" +
                             "5 - Consulta de saldo \n" +
                             "6 - Sair\n\n");


           System.out.printf("Digite a opção desejada: ");
           opcao = ler.nextInt();
           
           if (opcao == 1) {
               Cliente cliente = new Cliente();
               
               if(listaClientes.size() > 0) {
                   id_cliente = listaClientes.get(listaClientes.size()-1).getId() + 1;
               }
               else {
                   id_cliente = 1;
               }
               cliente.setId(id_cliente);
               
               System.out.print("Digite o seu nome: ");
               cliente.setNome(ler.next());
               
               System.out.print("Digite a seu idade: ");
               cliente.setIdade(ler.nextInt());
               
               ContaBancaria conta = new ContaBancaria();
                           
               System.out.print("Digite a agencia: ");
               conta.setAgencia(ler.next());
               
               System.out.print("Digite o numero: ");
               conta.setNumero(ler.next());
                           
               cliente.setConta(conta);
               
               listaClientes.add(cliente);
               
               System.out.printf("Cliente e conta cadastrados com sucesso!");
               System.in.read();
           }
           else if(opcao == 2) {
               for(Cliente c: listaClientes) {
                   System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome() + " - Saldo: " + c.getConta().ConsultarSaldo());
               }
               
               if (listaClientes.size() == 0) {
                   System.out.print("Não existem clientes cadastrados!");
                   System.in.read();
                   continue;
               }
               
               System.out.print("Digite o ID do cliente que voc� deseja realizar um dep�sito: ");
               id = ler.nextInt();
               
               indexCliente = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id) {
                       indexCliente = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               if (indexCliente != -1) {
                   cli = listaClientes.get(indexCliente);
                   
                   System.out.print("Digite o valor do dep�sito: ");
                   valor = ler.nextDouble();
                   
                   while(valor < 0) {
                       System.out.print("Erro, valor negativo! Digite um novo valor: ");
                       valor = ler.nextDouble();
                   }
                   
                   cli.getConta().Depositar(valor);
                   
                   System.out.printf("Dep�sito realizado com sucesso!");
               }
               else {
                   System.out.printf("Cliente n�o encontrado!");
               }
               
               System.in.read();
           }
           else if(opcao == 3) {
               for(Cliente c: listaClientes) {
                   System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome() + " - Saldo: " + c.getConta().ConsultarSaldo());
               }
               
               System.out.print("Digite o ID do cliente que voc� deseja realizar um saque: ");
               id = ler.nextInt();
               
               indexCliente = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id) {
                       indexCliente = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               if (indexCliente != -1) {
                   cli = listaClientes.get(indexCliente);
                   
                   System.out.print("Digite o valor do saque: ");
                   valor = ler.nextDouble();
                   
                   while(valor < 0) {
                       System.out.print("Erro, valor negativo! Digite um novo valor: ");
                       valor = ler.nextDouble();
                   }
               
                   if (cli.getConta().Sacar(valor))
                       System.out.printf("Saque realizado com sucesso!");                      
                   else
                       System.out.printf("Saldo insuficiente para saque!");
/*
                   if (cli.getConta().getSaldo() >= valor) {
                       cli.getConta().Sacar(valor);
                       System.out.printf("Saque realizado com sucesso!");                      
                   }
                   else {
                       System.out.printf("Saldo insuficiente para saque!");
                   }
*/
               }
               else {
                   System.out.printf("Cliente n�o encontrado!");
               }
               System.in.read();
           }
           else if(opcao == 4) {
               for(Cliente c: listaClientes) {
                   System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome() + " - Saldo: " + c.getConta().ConsultarSaldo());
               }
               
               System.out.print("Digite o ID do cliente de origem da transfer�ncia: ");
               id_cliente_origem = ler.nextInt();
               
               indexClienteOrigem = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id_cliente_origem) {
                       indexClienteOrigem = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               System.out.print("Digite o ID do cliente de destino da transfer�ncia: ");
               id_cliente_destino = ler.nextInt();
               
               indexClienteDestino = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id_cliente_destino) {
                       indexClienteDestino = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               if ( (indexClienteOrigem != -1) && (indexClienteDestino != -1) ) {
                   cli_origem = listaClientes.get(indexClienteOrigem);
                   cli_destino = listaClientes.get(indexClienteDestino);
                   
                   if (cli_origem == cli_destino) {
                       System.out.print("Erro! O cliente de origem é o mesmo de destino!");
                   }
                   else {
                       System.out.print("Digite o valor da transfer�ncia: ");
                       valor = ler.nextDouble();
                       
                       while(valor < 0) {
                           System.out.print("Erro, valor negativo! Digite um novo valor: ");
                           valor = ler.nextDouble();
                       }
                       
                       if (cli_origem.getConta().getSaldo() >= valor) {
                           cli_origem.getConta().Transferir(valor, cli_destino);
                           System.out.printf("Transfer�ncia realizada com sucesso!");                      
                       }
                       else {
                           System.out.printf("Saldo insuficiente para transferência!");
                       }
                   }
               }
               else {
                   System.out.printf("Cliente origem ou cliente destino n�o encontrado!");
               }
               System.in.read();
           }
           else if(opcao == 5) {
               for(Cliente c: listaClientes) {
                   System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome() + " - Saldo: " + c.getConta().ConsultarSaldo());
               }
               
               System.out.print("Digite o ID do cliente que voc� deseja obter o saldo: ");
               id = ler.nextInt();
               
               indexCliente = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id) {
                       indexCliente = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               if (indexCliente != -1) {
                   cli = listaClientes.get(indexCliente);
                   
                   System.out.print("Saldo: R$ " + cli.getConta().ConsultarSaldo());
               }
               else {
                   System.out.printf("Cliente n�o encontrado!");
               }
               System.in.read();
           }
           
        }while( (opcao >= 1) && (opcao <= 5) );
    }
}

