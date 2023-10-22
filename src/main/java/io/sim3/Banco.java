package io.sim3;

public class Banco extends Thread{
	
	public boolean saque(Conta _conta, double _valor){
		//synchronized (_conta) {
			
		if(_conta.getSaldo() < _valor){
				System.out.println("Saldo insuficiente.");
				return false;
		}
		
		_conta.setSaldo(_conta.getSaldo() - _valor);
	
		return true;
		//}
		//tem que colocar o run()
		
	}
}