package sistemaexception;

@SuppressWarnings("serial")
public class GetInfoHospedagemException extends Exception {

	public GetInfoHospedagemException(){
		super("Erro ao checar Informacoes.");
	}
	
	public GetInfoHospedagemException(String mensagem){
		super(mensagem);
	}
}
