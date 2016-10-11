package factory;

import hospedagem.CartaoFidelidade;
import hospedagem.Padrao;

public class FactoryCartaoFidelidade {

	public CartaoFidelidade criarCartaoFidelidade(){
		return new Padrao();
	}
}
