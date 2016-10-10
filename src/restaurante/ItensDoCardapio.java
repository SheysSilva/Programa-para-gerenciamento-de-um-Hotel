package restaurante;

public abstract class ItensDoCardapio{
	
	private String nome;
	private String descricao;
	
	public ItensDoCardapio(String nome, String descricao){
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public abstract double getPreco();
	
	public abstract String getPrecoString();	
	
	public abstract String getDescricao();
	
	public abstract String toStringComponentes();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricaoItem(){
		return this.descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
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
		ItensDoCardapio other = (ItensDoCardapio) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
