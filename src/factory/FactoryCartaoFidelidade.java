package factory;

import Hospedagem.CartaoFidelidade;
import Hospedagem.Padrao;

public class FactoryCartaoFidelidade {

	public CartaoFidelidade criarCartaoFidelidade(){
		return new Padrao();
	}
}
