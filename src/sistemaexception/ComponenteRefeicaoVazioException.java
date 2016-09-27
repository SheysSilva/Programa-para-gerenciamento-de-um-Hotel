package sistemaexception;

@SuppressWarnings("serial")
public class ComponenteRefeicaoVazioException extends Exception {

	public ComponenteRefeicaoVazioException(){
		super("Componente da Refeicao Vazio");
	}
	
	public ComponenteRefeicaoVazioException(String mensagem){
		super(mensagem);
	}
}
