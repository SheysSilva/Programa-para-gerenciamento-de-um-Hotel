package cartaofidelidadetestes;

import org.junit.Before;

import Hospedagem.CartaoFidelidade;
import factory.FactoryCartaoFidelidade;


public class TesteCartaoFidelidade {
	
	private FactoryCartaoFidelidade factoryCartaoFidelidade;
	private CartaoFidelidade cartao;
	
	@Before
	public void setUp(){
		this.factoryCartaoFidelidade = new FactoryCartaoFidelidade();
		this.cartao = this.factoryCartaoFidelidade.criarCartaoFidelidade();
		
	}
	

}
