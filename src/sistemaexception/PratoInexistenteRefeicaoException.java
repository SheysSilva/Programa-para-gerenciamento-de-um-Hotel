package sistemaexception;

@SuppressWarnings("serial")
public class PratoInexistenteRefeicaoException extends Exception {

	public PratoInexistenteRefeicaoException(){
		super("Prato Inexistente");
	}
	
	public PratoInexistenteRefeicaoException(String mensagem){
		super(mensagem);
	}
}
