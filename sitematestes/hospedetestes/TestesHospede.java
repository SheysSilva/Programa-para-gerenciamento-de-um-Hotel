package hospedetestes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryHospede;
import hospedagem.Estadia;
import hospedagem.Hospede;
import hospedagem.Quarto;
import hospedagem.Simples;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.CadastroHospedeException;
import sistemaexception.CheckoutException;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;

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
	
	@Test
	public void testeSetNome(){
		try {
			this.hospede.setNome("Kay");
			Assert.assertEquals("Kay", this.hospede.getNome());
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
		
		try {
			this.hospede.setNome("morgana");
			Assert.assertEquals("morgana", this.hospede.getNome());
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeEmailException(){
		try {
			this.hospede.setEmail(null);
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("			");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("Hahahahah.com");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("Hahaha.com.@");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("Hahahahah@.com");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("Hahahahah@ahhaah,com");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("Hahahahah@hahaha.com.sr.r");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testeSetEmail(){
		try {
			this.hospede.setEmail("trolei@eheheh.com");
			Assert.assertEquals(this.hospede.getEmail(), "trolei@eheheh.com");
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
		
		try {
			this.hospede.setEmail("samborei@ss.com.op");
			Assert.assertEquals(this.hospede.getEmail(), "samborei@ss.com.op");
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeDataNascimentoException(){
		try {
			this.hospede.setDataNascimento("");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("			");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento(null);
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10-10-2016");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10,10,2016");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10\10\2016");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("2016/10/01");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10/2016/10");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("32/10/2016");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10/13/2016");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10/10/2018");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("10/10/1998");
		} catch (AtualizaCadastroException e) {
			Assert.assertEquals("Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.", e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeDataNascimento(){
		try {
			this.hospede.setDataNascimento("31/12/1999");
			Assert.assertEquals("31/12/1999", this.hospede.getAnoNascimento());
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
		
		try {
			this.hospede.setDataNascimento("01/01/1999");
			Assert.assertEquals("31/12/1999", this.hospede.getAnoNascimento());
		} catch (AtualizaCadastroException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeSetPontosException(){
		try {
			this.hospede.setPontos(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception valor inteiro negativo", e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeSetPontos(){
		try {
			this.hospede.setPontos(10);
			Assert.assertEquals(10, this.hospede.getPontos());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			this.hospede.setPontos(20);
			Assert.assertEquals(20, this.hospede.getPontos());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void testeAdicionaPontosException(){
		try {
			this.hospede.adicionaPontos(-1);
		} catch (ValorInvalidoException e) {
			Assert.assertEquals("Exception valor double negativo", e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAdicionaPontos(){
		Assert.assertEquals("PADRAO", this.hospede.getTipoCartao());
		try {
			this.hospede.adicionaPontos(100);
			Assert.assertEquals(90, this.hospede.getPontos());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("PADRAO", this.hospede.getTipoCartao());
		Assert.assertEquals(90, this.hospede.getPontos());
		try {
			this.hospede.adicionaPontos(300);
			Assert.assertEquals(360, this.hospede.getPontos());
			Assert.assertEquals("PREMIUM", this.hospede.getTipoCartao());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("PREMIUM", this.hospede.getTipoCartao());
		Assert.assertEquals(360, this.hospede.getPontos());
		try {
			this.hospede.adicionaPontos(1000);
			Assert.assertEquals(1160, this.hospede.getPontos());
			Assert.assertEquals("VIP", this.hospede.getTipoCartao());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("VIP", this.hospede.getTipoCartao());
		Assert.assertEquals(1160, this.hospede.getPontos());
		try {
			this.hospede.adicionaPontos(100);
			Assert.assertEquals(1210, this.hospede.getPontos());
			Assert.assertEquals("VIP", this.hospede.getTipoCartao());
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  testeAdicionaEstadiaException(){
		try {
			this.hospede.adicionaEstadia(null);
		} catch (ObjetoNullException e) {
			Assert.assertEquals("Exception Objeto Null", e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAdicionaEstadia() throws CheckoutException{
		
		Simples quarto = null;
		try {
			quarto = new Simples("3B");
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		Estadia estadia = null;
		try {
			estadia = new Estadia(quarto, 5);
		} catch (QuartoInexistenteException e) {
			e.printStackTrace();
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		
		try {
			this.hospede.adicionaEstadia(estadia);
			Assert.assertEquals(estadia, this.hospede.buscaEstadia("3B"));
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBuscaEstadia(){
		Simples quarto = null;
		try {
			quarto = new Simples("3B");
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		Estadia estadia = null;
		try {
			estadia = new Estadia(quarto, 5);
		} catch (QuartoInexistenteException e) {
			e.printStackTrace();
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		try {
			this.hospede.adicionaEstadia(estadia);
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(estadia, this.hospede.buscaEstadia("3B"));
		Assert.assertEquals(null, this.hospede.buscaEstadia("4S"));
	}
	
	@Test
	public void testeRemoveEstadia(){
		Simples quarto = null;
		try {
			quarto = new Simples("3B");
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		Estadia estadia = null;
		try {
			estadia = new Estadia(quarto, 5);
		} catch (QuartoInexistenteException e) {
			e.printStackTrace();
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		try {
			this.hospede.adicionaEstadia(estadia);
		} catch (ObjetoNullException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(estadia, this.hospede.buscaEstadia("3B"));
		
		this.hospede.removeEstadia(estadia);
		
		Assert.assertEquals(null, this.hospede.buscaEstadia("3B"));
	}

}
 