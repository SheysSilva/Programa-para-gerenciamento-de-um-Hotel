package restaurante;

import java.util.ArrayList;
import java.util.List;

import sistemaexception.AtributoInexistenteException;
import sistemaexception.ComponenteRefeicaoVazioException;
import sistemaexception.NomePratoVazioException;
import sistemaexception.NomeRefeicaoVazioException;
import sistemaexception.NumeroDePratosRefeicaoException;
import sistemaexception.PratoInexistenteException;
import sistemaexception.PratoInexistenteRefeicaoException;
import sistemaexception.RefeicaoInexistenteException;
import sistemaexception.RefeicaoJaCadastradaException;

public class Restaurante {
	private List<Prato> pratosCadastrados;
	private List<Refeicao> refeicoes;
	private FactoryDePrato factoryDePrato;
	private FactoryDeRefeicao factoryDeRefeicao;
	
	public Restaurante(){
		this.pratosCadastrados = new ArrayList<Prato>();
		this.refeicoes = new ArrayList<Refeicao>();
		this.factoryDePrato = new FactoryDePrato();
		this.factoryDeRefeicao = new FactoryDeRefeicao();
	}
	
	public void cadastraPrato(String nome, double preco, String especificacao) throws Exception{
		Prato prato = factoryDePrato.CriaPrato(nome, preco, especificacao);
		if (pratosCadastrados.contains(prato)){
			throw new Exception("prato ja cadastrado.");
		}
		pratosCadastrados.add(prato);
	}
	
	private Prato encontraPrato(String nome) throws Exception{
		for (Prato prato : pratosCadastrados) {
			if (prato.getNome().equalsIgnoreCase(nome)){
				return prato;
			}
		}throw new PratoInexistenteException("prato inexistente.");
	}
	
	private boolean existePrato(String nome){
		for (Prato prato : pratosCadastrados) {
			if (prato.getNome().equalsIgnoreCase(nome)){
				return true;
			}
		}return false;
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception{
		verificaNomeConsulta(nome);
		
		if (existePrato(nome)){
			Prato prato = encontraPrato(nome);
			
			switch (atributo.toUpperCase()) {
			case "PRECO":
				return prato.getPrecoString();
			case "DESCRICAO":
				return prato.getEspecificacao();
			default:
				throw new AtributoInexistenteException("Atributo inexistente.");
			}
		}
		else if (existeRefeicao(nome)){
			Refeicao refeicao = encontraRefeicao(nome);
			
			switch (atributo.toUpperCase()) {
			case "PRECO":
				return getPrecoRefeicaoString(nome);
			case "DESCRICAO":
				return refeicao.toString();
			default:
			throw new AtributoInexistenteException("Atributo inexistente.");
			}
		}
		throw new Exception("Prato ou refeicao nao existe.");
		
		
		
	}
	
	private void verificaComponentes(String componentes) throws Exception {
		if (componentes == null || componentes.trim().isEmpty()){
			throw new ComponenteRefeicaoVazioException("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
		
		ArrayList<String> pratosRefeicao = separaComponentes(componentes);
		
		if (pratosRefeicao.size() < 3 || pratosRefeicao.size() > 4){
			throw new NumeroDePratosRefeicaoException("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		
		int qtdPratosCadastrados = 0;
		for (Prato prato : pratosCadastrados) {
			if (pratosRefeicao.contains(prato.getNome())){
				qtdPratosCadastrados += 1;
			}
		}
		
		if (qtdPratosCadastrados != pratosRefeicao.size()){
			throw new PratoInexistenteRefeicaoException("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
	}
	
	private ArrayList<String> separaComponentes(String componentes) throws Exception {
		String[] componentesSplit;
		ArrayList<String> pratos = new ArrayList<String>();

		componentesSplit = componentes.split(";");

		for (String prato : componentesSplit) {
			try {
				pratos.add(prato);

			} catch (Exception e) {
				throw new Exception("Tipo invalido.");
			}

		}
		return pratos;	
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		verificaComponentes(componentes);
		Refeicao refeicao = factoryDeRefeicao.CriaRefeicao(nome, descricao, separaComponentes(componentes));
		
		if (refeicoes.contains(refeicao)){
			throw new RefeicaoJaCadastradaException("refeicao ja cadastrada.");
		}
		refeicoes.add(refeicao);
	}
	
	private double getPrecoRefeicao(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new NomeRefeicaoVazioException("nome null ou vazio.");
		}
		
		double valorTotal = 0;
		if(existeRefeicao(nome)){
			for (Prato prato : pratosCadastrados) {
				if(pegaComponentes(nome).contains(prato.getNome())){
					valorTotal += prato.getPreco();
				}
			}
			return valorTotal * 0.9;
		}throw new RefeicaoInexistenteException("Essa refeicao nao existe.");
		
	}
	
	private String getPrecoRefeicaoString(String nome) throws Exception{
		return String.format("R$%.2f", getPrecoRefeicao(nome));
	} 

	private boolean existeRefeicao(String nome) {
		for (Refeicao refeicao : refeicoes) {
			if (refeicao.getNome().equalsIgnoreCase(nome)){
				return true;
			}
		}
		return false;			
	}
	
	private ArrayList<String> pegaComponentes(String nome){
		for (Refeicao refeicao : refeicoes) {
			if (refeicao.getNome().equalsIgnoreCase(nome)){
				return refeicao.getComponentes();
			}
		}return null;
	}
	
	private Refeicao encontraRefeicao(String nome) throws Exception{
		for (Refeicao refeicao : refeicoes) {
			if (refeicao.getNome().equalsIgnoreCase(nome)){
				return refeicao;
			}
		}throw new Exception("refeicao inexistente.");
	}
	
	private void verificaNomeConsulta(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new NomePratoVazioException("Erro na consulta do restaurante. Nome do prato esto vazio.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pratosCadastrados == null) ? 0 : pratosCadastrados.hashCode());
		result = prime * result + ((refeicoes == null) ? 0 : refeicoes.hashCode());
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
		Restaurante other = (Restaurante) obj;
		if (pratosCadastrados == null) {
			if (other.pratosCadastrados != null)
				return false;
		} else if (!pratosCadastrados.equals(other.pratosCadastrados))
			return false;
		if (refeicoes == null) {
			if (other.refeicoes != null)
				return false;
		} else if (!refeicoes.equals(other.refeicoes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurante [pratosCadastrados=" + pratosCadastrados + ", refeicoes=" + refeicoes + "]";
	}
}
