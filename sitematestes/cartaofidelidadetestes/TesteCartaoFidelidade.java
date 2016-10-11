package cartaofidelidadetestes;

import org.junit.Assert;
import org.junit.Test;

import hospedagem.CartaoFidelidade;
import hospedagem.Padrao;
import hospedagem.Premium;
import hospedagem.Vip;


public class TesteCartaoFidelidade {
	
	
	@Test
	public void testePorcentagem(){
		CartaoFidelidade padrao = new Padrao();
		CartaoFidelidade premium = new Premium();
		CartaoFidelidade vip = new Vip();
		
		Assert.assertEquals(padrao.getPorcentagem(), 0, 0.0);
		Assert.assertEquals(premium.getPorcentagem(), 0.9, 0.0);
		Assert.assertEquals(vip.getPorcentagem(), 0.85, 0.0);
		
	}
	
	@Test
	public void testSetPorcentagem(){
		CartaoFidelidade padrao = new Padrao();
		CartaoFidelidade premium = new Premium();
		CartaoFidelidade vip = new Vip();
		
		Assert.assertEquals(padrao.getPorcentagem(), 0, 0.0);
		Assert.assertEquals(premium.getPorcentagem(), 0.9, 0.0);
		Assert.assertEquals(vip.getPorcentagem(), 0.85, 0.0);
		
		padrao.setPorcentagem(0.9);
		premium.setPorcentagem(0.8);
		vip.setPorcentagem(0.7);
		
		Assert.assertEquals(padrao.getPorcentagem(), 0.9, 0.0);
		Assert.assertEquals(premium.getPorcentagem(), 0.8, 0.0);
		Assert.assertEquals(vip.getPorcentagem(), 0.7, 0.0);
		
	}
	
	@Test
	public void testeConverterPontos(){
		CartaoFidelidade padrao = new Padrao();
		CartaoFidelidade premium = new Premium();
		CartaoFidelidade vip = new Vip();
		
		Assert.assertEquals("R$10,00", padrao.convertePontos(100));
		Assert.assertEquals(premium.convertePontos(100), "R$32,00");
		Assert.assertEquals(vip.convertePontos(100), "R$75,00");
		
	}

}
