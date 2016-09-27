package sistemaexception;

@SuppressWarnings("serial")
public class CadastroDeRefeicaoVazioException extends Exception {
	
	public CadastroDeRefeicaoVazioException(){
		super("Erro no cadastro de refeicao.");
	}
	
	public CadastroDeRefeicaoVazioException(String mensagem){
		super(mensagem);
	}

}
