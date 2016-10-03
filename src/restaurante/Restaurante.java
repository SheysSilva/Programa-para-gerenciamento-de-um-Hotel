package restaurante;

import java.util.ArrayList;
import java.util.Collections;
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

public class Restaurante{
	private List<ItensDoCardapio> cardapio;
	
	public Restaurante(){
		this.cardapio = new ArrayList<ItensDoCardapio>();
	}
	
	/*
	 * Os tres primeiros metodos sao os testes do caso de uso 4
	 */
	
	// CADASTRO DE PRATO
	
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception{
		ItensDoCardapio prato = new Prato(nome, preco, descricao);
		if (cardapio.contains(prato)){
			throw new Exception("prato ja cadastrado.");
		}
		cardapio.add(prato);
	}
	
	
	// CADASTRO DE REFEICAO
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		verificaComponentes(componentes);
		ItensDoCardapio refeicao = new Refeicao(nome, descricao, separaComponentes(componentes));
		
		if (cardapio.contains(refeicao)){
			throw new RefeicaoJaCadastradaException("refeicao ja cadastrada.");
		}
		cardapio.add(refeicao);
	}
	
	// CONSULTA DE ATRIBUTO PARA PRATO OU REFEICAO
	
	public String consultaRestaurante(String nome, String atributo) throws Exception {
		verificaNomeConsulta(nome);
		
		if (existeItem(nome)){
			ItensDoCardapio item = encontraItem(nome);
			
			switch (atributo.toUpperCase()) {
			case "PRECO":
				if (item.getPrecoString() != null){
					return item.getPrecoString();
				}else{
					return getPrecoRefeicaoString(nome);
				}
			case "DESCRICAO":
				return item.getDescricao();
			default:
				throw new AtributoInexistenteException("Atributo inexistente.");
			}
		}
		throw new Exception("Prato ou refeicao nao existe.");
	}
	
	/*
	 * Os tres proximos metodos sao testes para o caso de uso 5
	 */
	
	public void ordenaMenu(String tipoOrdenacao) throws Exception{
		if (tipoOrdenacao == null || tipoOrdenacao.isEmpty()){
			throw new Exception("tipo invalido.");
		}else if (tipoOrdenacao.equalsIgnoreCase("nome")){
			ordenaPorNome();
		}	
	}
	
	public String consultaMenuRestaurante(){
		String imprimeCardapio = "";
		for (ItensDoCardapio item : cardapio) {
			imprimeCardapio += ";";
			imprimeCardapio += item.getNome();
		}
		imprimeCardapio = imprimeCardapio.substring(1);
		return imprimeCardapio;
	}
	
	public String realizaPedido(String email, String itemMenu) throws Exception{
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(itemMenu)){
				if (item.getPrecoString() == null){
					return getPrecoRefeicaoString(itemMenu);
				}else{
					return item.getPrecoString();
				}
			}
		}
		return null;
	}
	
	// VERIFICA SE O NOME DADO NO PARAMETRO EH VALIDO
	
	private void verificaNomeConsulta(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new NomePratoVazioException("Erro na consulta do restaurante. Nome do prato esto vazio.");
		}
	}
	
	// SEPARA OS COMPONENTES DA REFEICAO QUE ESTAVAM EM STRING PRA PODER AVALIAR SE SAO VALIDOS
	
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
	
	// VERIFICA SE O COMPONENTES DA REFEICAO SAO PRATOS VALIDOS
	
	private void verificaComponentes(String componentes) throws Exception {
		if (componentes == null || componentes.trim().isEmpty()){
			throw new ComponenteRefeicaoVazioException("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
		
		ArrayList<String> pratosRefeicao = separaComponentes(componentes);
		
		if (pratosRefeicao.size() < 3 || pratosRefeicao.size() > 4){
			throw new NumeroDePratosRefeicaoException("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		
		int qtdPratosCadastrados = 0;
		for (ItensDoCardapio prato : cardapio) {
			if (pratosRefeicao.contains(prato.getNome())){
				qtdPratosCadastrados += 1;
			}
		}
		
		if (qtdPratosCadastrados != pratosRefeicao.size()){
			throw new PratoInexistenteRefeicaoException("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
	}
	
	// VERIFICA SE UM PRATO OU REFEICAO EXISTE NO CARDAPIO
	
	private boolean existeItem(String nome) {
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(nome)){
				return true;
			}
		}
		return false;			
	}
	
	// ENCONTRA UM ITEM NO CARDAPIO
	
	private ItensDoCardapio encontraItem(String nome) throws Exception{
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(nome)){
				return item;
			}
		}throw new Exception("item inexistente.");
	}
	
	// CALCULA O PRECO DE UMA REFEICAO COMPLETA COM DESCONTO
	
	public double getPrecoRefeicao(String nome) throws Exception{
		if (nome == null || nome.trim().isEmpty()){
			throw new NomeRefeicaoVazioException("nome null ou vazio.");
		}
		
		double valorTotal = 0;
		if(existeItem(nome)){
			for (ItensDoCardapio prato : cardapio) {
				if(pegaComponentes(nome).contains(prato.getNome())){
					valorTotal += prato.getPreco();
				}
			}
			return valorTotal * 0.9;
		}throw new RefeicaoInexistenteException("Essa refeicao nao existe.");
		
	}
	
	// METODO USADO PARA PEGAR INFORMACOES DE UM DETERMINADO COMPONENTE DA REFEICAO
	
	private ArrayList<String> pegaComponentes(String nome){
		for (ItensDoCardapio refeicao : cardapio) {
			if (refeicao.getNome().equalsIgnoreCase(nome)){
				return refeicao.getComponentes();
			}
		}return null;
	}
	
	// METODO USADO PARA TRANSFORMAR O PRECO DE UMA REFEICAO EM STRING E UTILIZADO NO ConsultaRestaurante()
	
	private String getPrecoRefeicaoString(String nome) throws Exception{
		return String.format("R$%.2f", getPrecoRefeicao(nome));
	}
	
	// METODO QUE ORDENA O CARDAPIO POR ORDEM ALFABETICA
	
	public List<ItensDoCardapio> ordenaPorNome(){
		
		Collections.sort(cardapio, new NomeComparator());
		return cardapio;
	}	
}
