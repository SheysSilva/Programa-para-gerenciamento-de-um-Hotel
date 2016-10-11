package restauranteTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.RestauranteController;

public class RefeicaoTest {
	RestauranteController restaurante = new RestauranteController();
	
	@Before
	public void setUp() throws Exception {
		restaurante.cadastraPrato("Tapioca", 3.00, "Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
		restaurante.cadastraPrato("Rapadura", 0.50, "Sobremesa doce com sabor semelhante ao acucar mascavo.");
		restaurante.cadastraPrato("Galeto com Farofa", 15.50, "Galeto assado na brasa servido com farofa de calabresa e bacon.");
		restaurante.cadastraPrato("Carne de sol com fritas", 53.00, "Carne de sol saborosa servida com fritas como acompanhamento.");
		restaurante.cadastraPrato("Espresso", 2.50, "Tradicional cafe italiano.");
	}
	
	@Test
	public void test() {
		
		// Teste nome null ou vazio
		
		try{
			restaurante.cadastraRefeicao("", "Uma selecao de pratos da culinaria regional nordestina.", "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Nome da refeicao esta vazio.", e.getMessage());
		}
		
		try{
			restaurante.cadastraRefeicao(null, "Uma selecao de pratos da culinaria regional nordestina.", "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Nome da refeicao esta vazio.", e.getMessage());
		}
		
		// Teste descricao null ou vazia
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "", "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.", e.getMessage());
		}
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", null, "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.", e.getMessage());
		}
		
		// Teste componentes null ou vazios
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.", "");
			Assert.fail("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).", e.getMessage());
		}
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.", null);
			Assert.fail("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).", e.getMessage());
		}
		
		// Teste com quantidade de pratos menor que tres ou maior que quatro
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.", "Tapioca;Rapadura;Galeto com Farofa;Carne de sol com fritas;Espresso");
			Assert.fail("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.", e.getMessage());
		}
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.", "Tapioca;Rapadura");
			Assert.fail("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.", e.getMessage());
		}
		
		// Teste cria refeicao com um prato nao cadastrado
		
		try{
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.", "Tapioca;Rapadura;Galeto com Farofa;File com fritas");
			Assert.fail("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.", e.getMessage());
		}
		
	}
}
