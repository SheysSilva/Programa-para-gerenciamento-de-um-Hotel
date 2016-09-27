package restaurante;

public class FactoryDePrato {
	public Prato CriaPrato(String nome, double preco, String especificacao) throws Exception{
		Prato prato = new Prato(nome, preco, especificacao);
		return prato;
	}
}
