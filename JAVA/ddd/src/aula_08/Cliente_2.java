package aula_08;

public class Cliente_2 {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public ContaBancaria2 getConta() {
		return conta;
	}
	public void setConta(ContaBancaria2 conta) {
		this.conta = conta;
	}
	private int id;
	private String nome;
	private int idade;
	private ContaBancaria2 conta ;
	
	public Cliente_2() {
		
	}

	public Cliente_2( int id, String nome, int idade, ContaBancaria2 conta) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.conta = conta;
	}
}
