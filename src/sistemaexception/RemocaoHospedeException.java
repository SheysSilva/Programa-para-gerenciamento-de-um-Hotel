package sistemaexception;

@SuppressWarnings("serial")
public class RemocaoHospedeException extends EntradaException{
	
	public RemocaoHospedeException() {
		super("Erro na remocao do Hospede.");
	}

	public RemocaoHospedeException(String mensagem) {
		super(mensagem);
	}

}
