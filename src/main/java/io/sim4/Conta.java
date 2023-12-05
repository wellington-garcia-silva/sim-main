package io.sim4;

public class Conta extends Thread{
	
	private double saldo;
	
	public Conta(double _saldo){
		this.saldo = _saldo;
		System.out.println("A conta foi criada. "+ "Saldo inicial: R$ " + this.saldo);
	}
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setPagamento(int valor){//Diminui saldo
		saldo = saldo - (double)valor;
	}
	public void setRecebimento(int valor){//Aumenta saldo
		saldo = saldo + (double)valor;
	}

	///W eu fiz
	public void diminuirSaldo(){
		saldo = saldo - 10;
	}
	public void aumentarSaldo(){
		saldo = saldo + 10;
	}
	
	/*
	public synchronized double getSaldo() {
		return saldo;
	}

	public synchronized void setSaldo(double saldo) {
		this.saldo = saldo;
	}*/
		
}