package restauranteTest;

import org.junit.Assert;
import org.junit.Test;

import restaurante.Prato;

public class PratoTest {
	
	@Test
	public void testPrato() {
		
		// Teste nome null ou vazio
		try{
			Prato prato = new Prato("", 38.50, "Almondegas de carne feito no tradicional estilo sueco.");
			Assert.fail("Erro no cadastro do prato. Nome do prato esta vazio.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Nome do prato esta vazio.", e.getMessage());
		}
		
		try{
			Prato prato = new Prato(null, 38.50, "Almondegas de carne feito no tradicional estilo sueco.");
			Assert.fail("Erro no cadastro do prato. Nome do prato esta vazio.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Nome do prato esta vazio.", e.getMessage());
		}
		
		// Teste preco negativo ou nulo
		
		try{
			Prato prato = new Prato("Kotbullar com lingon", 0, "Almondegas de carne feito no tradicional estilo sueco.");
			Assert.fail("Erro no cadastro do prato. Preco do prato eh invalido.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Preco do prato eh invalido.", e.getMessage());
		}
		
		try{
			Prato prato = new Prato("Kotbullar com lingon", -38.50, "Almondegas de carne feito no tradicional estilo sueco.");
			Assert.fail("Erro no cadastro do prato. Preco do prato eh invalido.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Preco do prato eh invalido.", e.getMessage());
		}
		
		// Teste descricao nula ou vazia
		
		try{
			Prato prato = new Prato("Kotbullar com lingon", 38.50, "");
			Assert.fail("Erro no cadastro do prato. Descricao do prato esta vazia.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Descricao do prato esta vazia.", e.getMessage());
		}
		
		try{
			Prato prato = new Prato("Kotbullar com lingon", 38.50, null);
			Assert.fail("Erro no cadastro do prato. Descricao do prato esta vazia.");
		} catch (Exception e){
			Assert.assertEquals("Erro no cadastro do prato. Descricao do prato esta vazia.", e.getMessage());
		}
	}

}
