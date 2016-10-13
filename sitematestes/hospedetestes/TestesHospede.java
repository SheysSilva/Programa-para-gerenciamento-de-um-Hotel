package hospedetestes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryHospede;
import hospedagem.Hospede;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.CadastroHospedeException;

public class TestesHospede {
	
	private Hospede hospede;
	private FactoryHospede factory;
	
	@Before
	public void setUp(){
		this.factory = new FactoryHospede();
		try {
			hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "10/02/1996");
		} catch (CadastroHospedeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCriaHospedeException() {
		//Nome
		try {
			Hospede hospede = this.factory.criarHospede("			", "morgana@silva.sil.mo", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = this.factory.criarHospede("", "morgana@silva.sil.mo", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = this.factory.criarHospede(null, "morgana@silva.sil.mo", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = this.factory.criarHospede("Shgey&", "morgana@silva.sil.mo", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		//Email
		try {
			Hospede hospede = new Hospede("Morgana Silva", "", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "		", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", null, "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo.o", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.m$", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva", "10/02/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		//Data de Nascimento
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "			");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", null);
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "10-02-1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
	
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "12/13/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "32/11/1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "1996/01/19");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "10/1996/01");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Hospede hospede = new Hospede("Morgana Silva", "morgana@silva.sil.mo", "19 01 1996");
		} catch (CadastroHospedeException e) {
			Assert.assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtualizaCadastroNomeException(){
		try {
			this.hospede.setNome("");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setNome("			");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setNome(null);
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setNome("Mor#shete");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		//Email
		try {
			this.hospede.setEmail("");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("		");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail(null);
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("shei#silva.com");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("shei@silva.com.");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		
	}
		
	

}
 