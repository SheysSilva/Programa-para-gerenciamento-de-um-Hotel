package hospedagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import exceptionsmetodos.ExceptionMetodosHospede;
import factory.FactoryCartaoFidelidade;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.CadastroHospedeException;
import sistemaexception.ObjetoNullException;

public class Hospede {
	
	private DateTimeFormatter format;
	private LocalDate dataNascimento;
	
	private String nome;
	private String email;
	private int pontos;
	private FactoryCartaoFidelidade factoryCartao;
	private CartaoFidelidade cartao;
	private HashSet<Estadia> estadias;
	private ExceptionMetodosHospede exception;
	
	public Hospede(String nome, String email, String dataNascimento) throws CadastroHospedeException {
		this.exception = new ExceptionMetodosHospede();
		this.exception.exceptionEntrada(nome, email, dataNascimento);
		this.format = DateTimeFormatter.ofPattern("dd/MM/yyy");
		this.nome = nome;
		this.email = email;
		this.dataNascimento = LocalDate.parse(dataNascimento, format);
		this.pontos = 0;
		this.factoryCartao = new FactoryCartaoFidelidade();
		this.cartao = this.factoryCartao.criarCartaoFidelidade();
		this.estadias =  new HashSet<Estadia>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws AtualizaCadastroException   {
		this.exception.exceptionAtualizaNomeHospedeInvalido(nome);
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws AtualizaCadastroException  {
		this.exception.exceptionAtualizaEmailFormat(email);
		this.email = email;
	}
	
	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void adicionaPontos(double pagamento){
		int adicional = 0;
		if(pagamento > 100){
			adicional = ((int) (pagamento / 100)) * 10;
		}
		this.setPontos((int) (this.getPontos() + (pagamento * 0.3) + adicional));
	}
	
	public double getDebito() {
		return 0.0;
	}


	public String getAnoNascimento() {
		return this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setDataNascimento(String data) throws AtualizaCadastroException {
		this.exception.exceptionAtualizaMenorDeIdade(data);
		this.dataNascimento = LocalDate.parse(data, format);;
		
	}
	
	public CartaoFidelidade getCartao() {
		return cartao;
	}

	public HashSet<Estadia> getEstadias() {
		return estadias;
	}

	public void adicionaEstadia(Estadia estadia) throws ObjetoNullException  {
		this.exception.exceptionObjetoNull(estadia);
		this.getEstadias().add(estadia);
		
	}


	public void removeEstadia(Estadia estadia)  {
		this.getEstadias().remove(estadia);
	}
	
	public boolean verificaPontos(int pontos){
		if(this.getPontos() >= pontos){
			return true;
			
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Hospede){
			Hospede hospede = (Hospede)obj;
			if(hospede.getNome().equalsIgnoreCase(this.getNome()) && hospede.getEmail().equalsIgnoreCase(this.getEmail()) && hospede.getAnoNascimento() == this.getAnoNascimento()){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString(){
		return  "Email: " + this.getEmail() + 
				"\nNome: " + this.getNome() + 
				"\nData de nascimento: " + this.dataNascimento.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
			
	}
	
	
}
