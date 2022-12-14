package aula_08;
 
public class ContaBancaria2 {
    private String agencia;
    private String numero;
    private double saldo;
   
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
   
    public ContaBancaria2() {
       
    }
   
    public ContaBancaria2(String agencia, String numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
    }
   
    public void Depositar(double valor) {
        this.saldo = this.saldo + valor;
        //this.saldo =+ valor;
    }
   
    public void Sacar(double valor) {
        this.saldo = this.saldo - valor;
        //this.saldo =- valor;
    }
   
    public void Transferir(double valorTransf, Cliente_2 cli_destino) {
        Sacar(valorTransf);
        cli_destino.getConta().Depositar(valorTransf);
    }
   
    public double ConsultarSaldo() {
        return this.saldo;
    }
 
}
