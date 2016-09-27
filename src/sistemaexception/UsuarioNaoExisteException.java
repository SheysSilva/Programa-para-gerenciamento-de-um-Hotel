package sistemaexception;

@SuppressWarnings("serial")
public class UsuarioNaoExisteException extends LogicaException {
	public UsuarioNaoExisteException() {
		super("Usuario nao existe");
	}

	public UsuarioNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
