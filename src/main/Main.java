package main;

import easyaccept.EasyAccept; 

public class Main {
	public static void main(String[] args) {
	    args = new String[] {"FacadeHotel.FacadeHotel", "testes_de_aceitacao/testes_uc1.txt", "testes_de_aceitacao/testes_uc2.txt", "testes_de_aceitacao/testes_uc3.txt", "testes_de_aceitacao/testes_uc4.txt", "testes_de_aceitacao/testes_uc1_exception.txt", "testes_de_aceitacao/testes_uc2_exception.txt", "testes_de_aceitacao/testes_uc3_exception.txt", "testes_de_aceitacao/testes_uc4_exception.txt", "testes_de_aceitacao/testes_uc5.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
}
