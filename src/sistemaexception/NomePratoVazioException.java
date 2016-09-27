package sistemaexception;

@SuppressWarnings("serial")
public class NomePratoVazioException extends Exception {

	public NomePratoVazioException(){
		super("Nome do Prato Null ou Vazio");
	}
	
	public NomePratoVazioException(String mensagem){
		super(mensagem);
	}
}
