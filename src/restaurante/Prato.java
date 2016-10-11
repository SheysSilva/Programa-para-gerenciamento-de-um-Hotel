package restaurante;

import sistemaexception.CadastroDePratoVazioException;

public class Prato extends ItensDoCardapio{
	
	private double preco;

	public Prato(String nome, double preco, String descricao) throws Exception {
		super(nome, descricao);
		
		verificaNome(nome);
		verificaPreco(preco);
		verificaDescricao(descricao);
		
		this.preco = preco;
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
	
	private void verificaDescricao(String descricao) throws Exception{
		if (descricao == null || descricao.trim().isEmpty()){
			throw new CadastroDePratoVazioException("Erro no cadastro do prato. Descricao do prato esta vazia.");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getPrecoString(){
		return String.format("R$%.2f", this.preco);
	}
	
	@Override
	public String getDescricao() {
		return this.getDescricaoItem();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "(" + this.getNome() + ", " + this.preco + ", " + this.getDescricao() + ")";  
	}

	@Override
	public String toStringComponentes() {
		return null;
	}
}
