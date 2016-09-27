package sistemaexception;

@SuppressWarnings("serial")
public class NomeRefeicaoVazioException extends Exception {

	public NomeRefeicaoVazioException(){
		super("Nome de Refeição Vazio ou Null");
	}
	
	public NomeRefeicaoVazioException(String mensagem){
		super(mensagem);
	}
}
