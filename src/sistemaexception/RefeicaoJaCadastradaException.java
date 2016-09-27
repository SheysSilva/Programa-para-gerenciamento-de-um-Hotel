package sistemaexception;

@SuppressWarnings("serial")
public class RefeicaoJaCadastradaException extends Exception {

	public RefeicaoJaCadastradaException(){
		super("Refeicao Ja Cadastrada");
	}
	
	public RefeicaoJaCadastradaException(String mensagem){
		super(mensagem);
	}
}
