package sistemaexception;

@SuppressWarnings("serial")
public class GetInfoHospede extends Exception {
	
	public GetInfoHospede(){
		super("Erro na consulta de hospede.");
	}
	
	public GetInfoHospede(String mensagem){
		super(mensagem);
	}

}
