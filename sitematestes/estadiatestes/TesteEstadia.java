package estadiatestes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryEstadia;
import factory.FactoryQuarto;
import hospedagem.Estadia;
import hospedagem.Quarto;
import sistemaexception.ValorInvalidoException;

public class TesteEstadia {

	private FactoryQuarto factoryQuarto;
	private Quarto simples;
	private Quarto luxo;
	private Quarto presidencial;
	
	private FactoryEstadia factoryEstadia;
	private Estadia estadiaSimples;
	private Estadia estadiaLuxo;
	private Estadia estadiaPresidencial;
	
	@Before
	public void setUp() throws Exception{
		//Criar Quartos
		this.factoryQuarto =  new FactoryQuarto();
		
		this.simples = this.factoryQuarto.criaQuarto("SIMPLES", "1A");
		this.luxo = this.factoryQuarto.criaQuarto("LUXO", "2A");
		this.presidencial = this.factoryQuarto.criaQuarto("PRESIDENCIAL", "3A");
		
		//Cria Estadia
		this.factoryEstadia = new FactoryEstadia();
		
		this.estadiaSimples = this.factoryEstadia.criaEstadia(this.simples, 10);
		this.estadiaLuxo = this.factoryEstadia.criaEstadia(this.luxo, 10);
		this.estadiaPresidencial = this.factoryEstadia.criaEstadia(this.presidencial, 10);
		
	}
	
	@Test
	public void testConstrutorException() {
		try{
			this.factoryEstadia.criaEstadia(null, 10);
		}catch(Exception e){
			Assert.assertEquals("Exception Objeto Null", e.getMessage());
		}
		
		try{
			this.factoryEstadia.criaEstadia(this.simples, 0);
		}catch(Exception e){
			Assert.assertEquals("Exception os dias nao podem ser zero ou negativo", e.getMessage());
		}
		
		try{
			this.factoryEstadia.criaEstadia(this.simples, -1);
		}catch(Exception e){
			Assert.assertEquals("Exception os dias nao podem ser zero ou negativo", e.getMessage());
		}
	}
	
	@Test
	public void testQuartoEstadia(){
		Assert.assertEquals(this.estadiaSimples.getQuarto(), this.simples);
		Assert.assertEquals(this.estadiaLuxo.getQuarto(), this.luxo);
		Assert.assertEquals(this.estadiaPresidencial.getQuarto(), this.presidencial);
		
	}
	
	@Test 
	public void testDias() throws ValorInvalidoException{
		Assert.assertEquals(this.estadiaSimples.getDias(), 10);
		Assert.assertEquals(this.estadiaLuxo.getDias(), 10);
		Assert.assertEquals(this.estadiaPresidencial.getDias(), 10);
		
		//Mudan�a nos dias
		this.estadiaSimples.setDias(13);	
		this.estadiaLuxo.setDias(13);
		this.estadiaPresidencial.setDias(13);
		
		Assert.assertEquals(this.estadiaSimples.getDias(), 13);
		Assert.assertEquals(this.estadiaLuxo.getDias(), 13);
		Assert.assertEquals(this.estadiaPresidencial.getDias(), 13);
		
	}
	
	@Test 
	public void testDiasException(){
		//Mudanca nos dias
		try {
			this.estadiaSimples.setDias(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception os dias nao podem ser zero ou negativo", e.getMessage());
			e.printStackTrace();
		}	
		try {
			this.estadiaLuxo.setDias(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception os dias nao podem ser zero ou negativo", e.getMessage());
			e.printStackTrace();
		}
		try {
			this.estadiaPresidencial.setDias(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception os dias nao podem ser zero ou negativo", e.getMessage());
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testValorDiaria(){
		Assert.assertEquals(this.estadiaSimples.getValorDiariaQuarto(), 100.0, 0.0);
		Assert.assertEquals(this.estadiaLuxo.getValorDiariaQuarto(), 250.0, 0.0);
		Assert.assertEquals(this.estadiaPresidencial.getValorDiariaQuarto(), 450.0, 0.0);
	}
	
	@Test
	public void testValorTotal(){
		Assert.assertEquals(this.estadiaSimples.getValorTotal(), 1000.0, 0.0);
		Assert.assertEquals(this.estadiaLuxo.getValorTotal(), 2500.0, 0.0);
		Assert.assertEquals(this.estadiaPresidencial.getValorTotal(), 4500.0, 0.0);
	}


}
