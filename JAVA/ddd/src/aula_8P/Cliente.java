package aula_8P;

public class Cliente {
	private int id;
	private String nome;
	private int idade;
	private contaBancaria conta;
	
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, int idade, contaBancaria conta) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.conta = conta;
		
	}

}