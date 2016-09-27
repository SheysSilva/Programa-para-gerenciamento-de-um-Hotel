package quartotestes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import quartos.FactoryQuarto;
import quartos.Quarto;

public class TestesQuartos {
	private FactoryQuarto factory;
	private Quarto simples;
	private Quarto luxo;
	private Quarto presidencial;
	
	@Before
	public void setUp() throws Exception{
		this.factory = new FactoryQuarto();
		
		this.simples = this.factory.criaQuarto("SIMPLES", "1A");
		this.luxo = this.factory.criaQuarto("LUXO", "2A");
		this.presidencial = this.factory.criaQuarto("PRESIDENCIAL", "3A");
	}
	
	@Test
	public void testFactoryQuartoException() {
		try {
			this.factory.criaQuarto("Desconhecido", "Aleatorio");
		} catch (Exception e) {
			Assert.assertEquals("Tipo do quarto nao existe", e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTipoQuarto(){
		Assert.assertEquals("Simples", this.simples.getTipo());
		Assert.assertEquals("Luxo", this.luxo.getTipo());
		Assert.assertEquals("Presidencial", this.presidencial.getTipo());
	}
	
	@Test
	public void testValorQuarto(){
		Assert.assertEquals(this.simples.getValorQuarto(), 100.0, 0.0);
		Assert.assertEquals(this.luxo.getValorQuarto(), 250.0, 0.0);
		Assert.assertEquals(this.presidencial.getValorQuarto(), 450.0, 0.0);
	}
	
	@Test
	public void testNumeroQuarto(){
		Assert.assertEquals( "1A", this.simples.getNumeroDoQuarto());
		Assert.assertEquals( "2A", this.luxo.getNumeroDoQuarto());
		Assert.assertEquals( "3A", this.presidencial.getNumeroDoQuarto());

	}
	
	@Test
	public void testEstadoDoQuarto(){
		//Quarto disponivel
		Assert.assertFalse(this.simples.isEstadoQuarto());
		Assert.assertFalse(this.luxo.isEstadoQuarto());
		Assert.assertFalse(this.presidencial.isEstadoQuarto());
		
		//Quarto ocupado
		this.simples.setEstadoQuarto(true);
		this.luxo.setEstadoQuarto(true);
		this.presidencial.setEstadoQuarto(true);
		
		Assert.assertTrue(this.simples.isEstadoQuarto());
		Assert.assertTrue(this.luxo.isEstadoQuarto());
		Assert.assertTrue(this.presidencial.isEstadoQuarto());
		
	}
	
}
