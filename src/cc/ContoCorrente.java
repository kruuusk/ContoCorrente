package cc;

public class ContoCorrente {
	private int saldo;

	public ContoCorrente() {}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(int dep) {
		saldo += dep;
		System.out.println("Deposito di " + dep + "€ avvenuto con successo");
	}
	
	public boolean preleva(int prel) {
		boolean successo = false;
		if(saldo>=prel) {
			saldo -= prel;
			successo = true;
			System.out.println("Prelievo di " + prel + "€ avvenuto con successo");
		}else {
			System.out.println("Credito insufficente per consentire il prelievo");
		}
		return successo;
	}
	
	public int leggiSaldo() {
		return saldo;
	}
}
