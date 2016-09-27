package sistemaexception;

@SuppressWarnings("serial")
public class CadastroDePratoVazioException extends Exception {
		
		public CadastroDePratoVazioException(){
			super("Erro no cadastro de Pratos.");
		}
		
		public CadastroDePratoVazioException(String mensagem){
			super(mensagem);
		}
}

