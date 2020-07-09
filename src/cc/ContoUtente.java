package cc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContoUtente {
	private String intestatario;
	private ContoCorrente cc;

	public ContoUtente(String intestatario, ContoCorrente cc) {
		intestatario = this.intestatario;
		cc = this.cc;
	}
	public void gestisci() {
		cc = new ContoCorrente();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Inserire Nome Intestatario Conto");
		String nomeInserito = myScanner.nextLine();
		try {
			File myObj = new File("C:/Users/andre/Desktop/andrea caretto/workspace/Banca/src/cc/" + nomeInserito + ".txt");
			Scanner myReader = new Scanner(myObj);
			System.out.print("Benvenuto " + nomeInserito + ", il saldo disponibile è di ");
			while (myReader.hasNextLine()) {
				String saldo = myReader.nextLine();
				cc.setSaldo(Integer.parseInt(saldo));
				System.out.print(saldo);	
			}
			myReader.close();
			System.out.println("€");
			do{
				System.out.println("Digitare D per deposito P per prelievo:");
				String operazione = myScanner.nextLine();
				if(operazione.equals("D")) {
					System.out.println("Somma da Depositare:");
					String deposito = myScanner.nextLine();
					int dep = Integer.parseInt(deposito);
					cc.deposita(dep);
					int saldoFinale = cc.leggiSaldo();
					System.out.println("Saldo Conto Corrente: " + saldoFinale);
					try {
						FileWriter myWriter = new FileWriter("C:/Users/andre/Desktop/andrea caretto/workspace/Banca/src/cc/" + nomeInserito + ".txt");
						myWriter.write(String.valueOf(saldoFinale));
						myWriter.close();
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}else {
					System.out.println("Somma da Prelevare:");
					String prelievo = myScanner.nextLine();
					int prel = Integer.parseInt(prelievo);
					cc.preleva(prel);
					int saldoFinale = cc.leggiSaldo();
					System.out.println("Saldo Conto Corrente: " + saldoFinale);
					try {
						FileWriter myWriter = new FileWriter("C:/Users/andre/Desktop/andrea caretto/workspace/Banca/src/cc/" + nomeInserito + ".txt");
						myWriter.write(String.valueOf(saldoFinale));
						myWriter.close();
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}
				System.out.print("Procedere con altre operazioni?(S/N)");
			} while (myScanner.nextLine().equals("S"));
			myScanner.close();
			System.out.print("Operazione terminata");
		} catch (IOException e) {
			System.out.println("Conto Corrente non trovato");
		}
	}
}
