package quartos;


import sistemaexception.QuartoInexistenteException;

public class FactoryQuarto {

	public Quarto criaQuarto(String tipo, String numQuarto)throws Exception{
		switch(tipo.toUpperCase()){
			case "SIMPLES":
				return new Simples(numQuarto);
			
			case "LUXO": 
				return new Luxo(numQuarto);
			
			case "PRESIDENCIAL":
				return new Presidencial(numQuarto);
				
			default:
				throw new QuartoInexistenteException();
		}
	}

}
