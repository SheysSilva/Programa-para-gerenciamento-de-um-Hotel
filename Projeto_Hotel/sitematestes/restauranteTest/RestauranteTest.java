package restauranteTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import restaurante.Restaurante;

public class RestauranteTest {
	
	Restaurante restaurante = new Restaurante();

	@Test
	public void testCadastraPrato() throws Exception {

		// teste cadastra prato com nome null ou vazio

		try {
			restaurante.cadastraPrato("", 3.00,
					"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
			Assert.fail("Erro no cadastro do prato. Nome do prato esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Nome do prato esta vazio.", e.getMessage());
		}

		try {
			restaurante.cadastraPrato(null, 3.00,
					"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
			Assert.fail("Erro no cadastro do prato. Nome do prato esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Nome do prato esta vazio.", e.getMessage());
		}

		// teste cadastra com preco invalido

		try {
			restaurante.cadastraPrato("Tapioca", 0,
					"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
			Assert.fail("Erro no cadastro do prato. Preco do prato eh invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Preco do prato eh invalido.", e.getMessage());
		}

		try {
			restaurante.cadastraPrato("Tapioca", -3.00,
					"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
			Assert.fail("Erro no cadastro do prato. Preco do prato eh invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Preco do prato eh invalido.", e.getMessage());
		}

		// teste cadastra com descricao null ou vazia

		try {
			restaurante.cadastraPrato("Tapioca", 3.00, "");
			Assert.fail("Erro no cadastro do prato. Descricao do prato esta vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Descricao do prato esta vazia.", e.getMessage());
		}

		try {
			restaurante.cadastraPrato("Tapioca", 3.00, null);
			Assert.fail("Erro no cadastro do prato. Descricao do prato esta vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro do prato. Descricao do prato esta vazia.", e.getMessage());
		}
	}

	@Test
	public void testCadastraRefeicao() throws Exception {
		restaurante.cadastraPrato("Tapioca", 3.00,
				"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
		restaurante.cadastraPrato("Rapadura", 0.50, "Sobremesa doce com sabor semelhante ao acucar mascavo.");
		restaurante.cadastraPrato("Galeto com Farofa", 15.50,
				"Galeto assado na brasa servido com farofa de calabresa e bacon.");
		restaurante.cadastraPrato("Carne de sol com fritas", 53.00,
				"Carne de sol saborosa servida com fritas como acompanhamento.");
		restaurante.cadastraPrato("Espresso", 2.50, "Tradicional cafe italiano.");
		// Teste nome null ou vazio

		try {
			restaurante.cadastraRefeicao("", "Uma selecao de pratos da culinaria regional nordestina.",
					"Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Nome da refeicao esta vazio.", e.getMessage());
		}

		try {
			restaurante.cadastraRefeicao(null, "Uma selecao de pratos da culinaria regional nordestina.",
					"Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Nome da refeicao esta vazio.", e.getMessage());
		}

		// Teste descricao null ou vazia

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "", "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.", e.getMessage());
		}

		try {
			restaurante.cadastraRefeicao("Delicia da serra", null, "Tapioca;Rapadura;Galeto com Farofa");
			Assert.fail("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.", e.getMessage());
		}

		// Teste componentes null ou vazios

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.",
					"");
			Assert.fail("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).", e.getMessage());
		}

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.",
					null);
			Assert.fail("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		} catch (Exception e) {
			Assert.assertEquals("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).", e.getMessage());
		}

		// Teste com quantidade de pratos menor que tres ou maior que quatro

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.",
					"Tapioca;Rapadura;Galeto com Farofa;Carne de sol com fritas;Espresso");
			Assert.fail(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.",
					e.getMessage());
		}

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.",
					"Tapioca;Rapadura");
			Assert.fail(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.",
					e.getMessage());
		}

		// Teste cria refeicao com um prato nao cadastrado

		try {
			restaurante.cadastraRefeicao("Delicia da serra", "Uma selecao de pratos da culinaria regional nordestina.",
					"Tapioca;Rapadura;Galeto com Farofa;File com fritas");
			Assert.fail("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.",
					e.getMessage());
		}
	}

	@Test
	public void testConsultaRestaurante() throws Exception {
		restaurante.cadastraPrato("Tapioca", 3.00,
				"Essa deliciosa receita nordestina possui como base a farinha de mandioca.");
		restaurante.cadastraPrato("Rapadura", 0.50, "Sobremesa doce com sabor semelhante ao acucar mascavo.");
		restaurante.cadastraPrato("Galeto com Farofa", 15.50,
				"Galeto assado na brasa servido com farofa de calabresa e bacon.");
		restaurante.cadastraPrato("Carne de sol com fritas", 53.00,
				"Carne de sol saborosa servida com fritas como acompanhamento.");
		restaurante.cadastraPrato("Espresso", 2.50, "Tradicional cafe italiano.");
		restaurante.cadastraRefeicao("Nordestina", "Comidas tipicas da culinaria nordestina.",
				"Tapioca;Rapadura;Carne de sol com fritas");

		// parametro null ou vazio.
		try {
			restaurante.consultaRestaurante("  ", "Preco");
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Erro na consulta do restaurante. Nome do prato esto vazio.", e.getMessage());
		}

		// parametro null ou vazio.
		try {
			restaurante.consultaRestaurante(null, "Preco");
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Erro na consulta do restaurante. Nome do prato esto vazio.", e.getMessage());
		}

		// Prato nao cadastrado
		try {
			restaurante.consultaRestaurante("Comida nao cadastrada", "Descricao");
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Prato ou refeicao nao existe.", e.getMessage());
		}

		// atributo inexistente ou invalido
		try {
			restaurante.consultaRestaurante("Tapioca", "invalido");
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Atributo inexistente.", e.getMessage());
		}

		// consulta preco
		try {
			Assert.assertTrue(restaurante.consultaRestaurante("Tapioca", "Preco").equals("R$3,00"));
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}

		// consulta descricao.
		try {
			Assert.assertTrue(restaurante.consultaRestaurante("Nordestina", "Descricao").equals(
					"Comidas tipicas da culinaria nordestina. Serao servidos: (1) Tapioca, (2) Rapadura, (3) Carne de sol com fritas."));
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
	}
}
