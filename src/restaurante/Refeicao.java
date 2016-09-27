package restaurante;

import java.util.ArrayList;

import sistemaexception.CadastroDeRefeicaoVazioException;

public class Refeicao {
	private String nome;
	private String descricao;
	private ArrayList<String> componentes;
	
	public Refeicao(String nome, String descricao, ArrayList<String> componentes) throws Exception{
		verificaNome(nome);
		verificaDescricao(descricao);
		
		this.nome = nome;
		this.descricao = descricao;
		this.componentes = componentes;
	}
	
	private void verificaNome(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new CadastroDeRefeicaoVazioException("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		}
	}
	
	private void verificaDescricao(String descricao) throws Exception{
		if (descricao == null || descricao.trim().isEmpty()){
			throw new CadastroDeRefeicaoVazioException("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<String> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<String> componentes) {
		this.componentes = componentes;
	}
	
	private String toStringComponentes(){
		String impressao = "";
		for (int i = 0; i < componentes.size(); i++) {
			impressao += ", ";
			impressao += "(" + (i + 1) + ") " + componentes.get(i);
		}
		impressao = impressao.substring(2);
		return impressao;
		
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
		Refeicao other = (Refeicao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override 
	public String toString(){
		return this.descricao + " Serao servidos: " + toStringComponentes() + ".";				
	}
}
