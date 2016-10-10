package main;

import java.io.File;

import easyaccept.EasyAccept; 

public class Main {
	public static void main(String[] args) {
	    args = new String[] {"Facade.HotelFacade", "testes_de_aceitacao/testes_uc1.txt", "testes_de_aceitacao/testes_uc2.txt", "testes_de_aceitacao/testes_uc3.txt", "testes_de_aceitacao/testes_uc4.txt", "testes_de_aceitacao/testes_uc1_exception.txt", "testes_de_aceitacao/testes_uc2_exception.txt", "testes_de_aceitacao/testes_uc3_exception.txt", "testes_de_aceitacao/testes_uc4_exception.txt", "testes_de_aceitacao/testes_uc5.txt", "testes_de_aceitacao/testes_uc6.txt", "testes_de_aceitacao/testes_uc7.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	    
	   
	    //Criando diretorio
		File file = new File("Historico");
		file.mkdir(); 
		
		//Criando Arquivo
		File cad_hosp = new File("Historico/cad_hospedes.txt");
		cad_hosp.createNewFile();
		
		File cad_rest = new File("Historico/cad_restaurante.txt");
		cad_rest.createNewFile();
		
		File cad_trans = new File ("Historico/cad_transacoes.txt");
		cad_trans.createNewFile();
		
		File hotel_prin = new File("Historico/hotel_principal.txt");
		hotel_prin.createNewFile();
		
		
	
		FileWriter escrever = new FileWriter(cad_hosp);
		BufferedWriter bufferE= new BufferedWriter(escrever);
		bufferE.write("\nSheySS");
		
		bufferE.close();
		escrever.close();
		
		FileReader ler = new FileReader(cad_hosp); 
		BufferedReader buffer = new BufferedReader(ler);
		String linha = buffer.readLine();
		while(linha != null){
			System.out.println(linha);
			linha = buffer.readLine();
		}
	}
}
