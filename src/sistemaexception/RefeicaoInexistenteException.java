package sistemaexception;

@SuppressWarnings("serial")
public class RefeicaoInexistenteException extends Exception {

	public RefeicaoInexistenteException(){
		super("Refeicao Inexistente");
	}
	
	public RefeicaoInexistenteException(String mensagem){
		super(mensagem);
	}
}
