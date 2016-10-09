package sistemaexception;

@SuppressWarnings("serial")
public class ChecarHospedagemException extends EntradaException{
	
	public ChecarHospedagemException() {
		super("Erro ao checar hospedagem ativa.");
	}

	public ChecarHospedagemException(String mensagem) {
		super(mensagem);
	}
}
