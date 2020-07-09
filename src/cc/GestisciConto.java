package cc;

public class GestisciConto {

	public static void main(String[] args) {
		
		ContoCorrente cc1 = new ContoCorrente();
		
		ContoUtente cu1 = new ContoUtente("Mario", cc1);
		cu1.gestisci();
		
	}

}
