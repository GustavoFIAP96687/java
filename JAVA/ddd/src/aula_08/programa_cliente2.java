package aula_08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class programa_cliente {
 
    public static void main(String[] args) throws IOException{
        Scanner ler = new Scanner(System.in);
       
        ArrayList<Cliente_2> listaClientes = new ArrayList<>();
       
        int opcao;
        int id;
        Cliente cli;
        int indexCliente;
        int id_cliente;
        String possuiConta;
 
        do {        
           System.out.printf("===> Sistema de Cadastro de Clientes <===\n\n");
           System.out.printf("Escolha uma opção:\n");          
           System.out.printf("1 - Criar cliente/conta \n" +
                             "2 - Deposito \n" +
                             "3 - Saque \n" +
                             "4 - Transferência \n" +
                             "5 -  Consulta de saldo \n" +
                             "6 - Sair \n\n");
 
           System.out.printf("Digite a opção desejada: ");
           opcao = ler.nextInt();
           
           
               Cliente_2 cliente = new Cliente_2();
               
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
               
               if(possuiConta.equals("S")) {
                   ContaBancaria2 conta = new ContaBancaria2();
                   
                   System.out.print("Digite a agencia: ");
                   conta.setAgencia(ler.next());
                   
                   System.out.print("Digite o numero: ");
                   conta.setNumero(ler.next());
                   
                   conta.setSaldo(0);
                   
                   cliente.setConta(conta);


               
               listaClientes.add(cliente);
               
               System.out.printf("Cliente incluído com sucesso!");
               System.in.read();
           }
           else if(opcao == 2) {
               for(Cliente c: listaClientes) {
                   System.out.println(c.exibirCliente());
               }
               
               System.out.print("Digite o ID do cliente que você deseja atualizar: ");
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
                   
                   System.out.print("Digite o seu novo nome: ");
                   cli.setNome(ler.next());
                   
                   System.out.print("Digite a sua nova idade: ");
                   cli.setIdade(ler.nextInt());
                   
                   System.out.print("Digite o seu novo e-mail: ");
                   cli.setEmail(ler.next());
                   
                   System.out.printf("Cliente atualizado com sucesso!");
               }
               else {
                   System.out.printf("Cliente não encontrado!");
               }
               System.in.read();
           }
           else if(opcao == 3) {
               for(Cliente c: listaClientes) {
                   System.out.println(c.exibirCliente());
               }
               
               System.out.print("Digite o ID do cliente que você deseja excluir: ");
               id = ler.nextInt();
               
               indexCliente = -1;
               for(Cliente c: listaClientes) {
                   if (c.getId() == id) {
                       indexCliente = listaClientes.indexOf(c);
                       break;
                   }
               }
               
               if (indexCliente != -1) {                              
                   listaClientes.remove(indexCliente);
                   
                   System.out.printf("Cliente excluído com sucesso!");
               }
               else {
                   System.out.printf("Cliente não encontrado!");
               }
               System.in.read();
           }
           else if(opcao == 4) {
               for(Cliente c: listaClientes) {
                   System.out.println(c.exibirCliente());
                   
                   if (c.getConta() != null)
                       System.out.println(c.exibirDadosConta());
               }
               
               System.in.read();
           }
           
        }while( (opcao >= 1) && (opcao <= 5) );
    }
}
