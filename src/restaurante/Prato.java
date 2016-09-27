package restaurante;

import sistemaexception.CadastroDePratoVazioException;

public class Prato {
	private String nome;
	private double preco;
	private String especificacao;

	public Prato(String nome, double preco, String especificacao) throws Exception{
		verificaNome(nome);
		verificaPreco(preco);
		verificaEspecificacao(especificacao);
		
		this.nome = nome;
		this.preco = preco;
		this.especificacao = especificacao;
	}
	
	private void verificaNome(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new CadastroDePratoVazioException("Erro no cadastro do prato. Nome do prato esta vazio.");
		}
	}
	
	private void verificaPreco(double preco) throws Exception{
		if (preco <= 0){
			throw new CadastroDePratoVazioException("Erro no cadastro do prato. Preco do prato eh invalido.");
		}
	}
	
	private void verificaEspecificacao(String especificacao) throws Exception{
		if (especificacao == null || especificacao.trim().isEmpty()){
			throw new CadastroDePratoVazioException("Erro no cadastro do prato. Descricao do prato esta vazia.");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	
	public String getPrecoString(){
		return String.format("R$%.2f", this.preco);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return "(" + this.nome + ", " + this.preco + ", " + this.especificacao + ")"; 
	}	
}
