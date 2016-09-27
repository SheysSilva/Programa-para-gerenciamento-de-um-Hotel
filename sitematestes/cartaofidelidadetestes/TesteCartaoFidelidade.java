package cartaofidelidadetestes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cartaofidelidade.CartaoFidelidade;
import cartaofidelidade.FactoryCartaoFidelidade;
import sistemaexception.ValorInvalidoException;


public class TesteCartaoFidelidade {
	
	private FactoryCartaoFidelidade factoryCartaoFidelidade;
	private CartaoFidelidade cartao;
	
	@Before
	public void setUp(){
		this.factoryCartaoFidelidade = new FactoryCartaoFidelidade();
		this.cartao = this.factoryCartaoFidelidade.criarCartaoFidelidade();
		
	}
	
	@Test
	public void testDesconto() throws ValorInvalidoException {
		Assert.assertEquals(this.cartao.getDesconto(), 0, 0.0);
		
		//Inserindo Desconto
		this.cartao.setDesconto(10);
		Assert.assertEquals(this.cartao.getDesconto(), 10, 0.0);
		
	}
	
	@Test
	public void testDescontoException(){
		try {
			this.cartao.setDesconto(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception valor double negativo", e.getMessage());
			e.printStackTrace();
		}
	}
	@Test
	public void testGastoHospede() throws ValorInvalidoException{
		Assert.assertEquals(this.cartao.getGastosHospedes(), 0, 0.0);
		
	}
	
	@Test
	public void testControleGastos() throws ValorInvalidoException{
		//Sem Gastos
		Assert.assertEquals(this.cartao.getGastosHospedes(), 0, 0.0);
		
		//Inserindo Gastos
		this.cartao.controleGastos(10);
		Assert.assertEquals(this.cartao.getGastosHospedes(), 10, 0.0);
		
		//Inserindo Gastos
		this.cartao.controleGastos(20);
		Assert.assertEquals(this.cartao.getGastosHospedes(), 30, 0.0);
	}
	
	@Test
	public void testControleGastosException(){
		try {
			this.cartao.controleGastos(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception valor double negativo", e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
