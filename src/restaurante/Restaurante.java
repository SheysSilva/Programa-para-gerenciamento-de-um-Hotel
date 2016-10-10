package restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistemaexception.ComponenteRefeicaoVazioException;
import sistemaexception.NomePratoVazioException;
import sistemaexception.NumeroDePratosRefeicaoException;
import sistemaexception.PratoInexistenteRefeicaoException;
import sistemaexception.RefeicaoJaCadastradaException;

public class Restaurante {
	private List<ItensDoCardapio> cardapio;

	public Restaurante() {
		this.cardapio = new ArrayList<ItensDoCardapio>();
	}

	/*
	 * Os tres primeiros metodos sao os testes do caso de uso 4
	 */

	// CADASTRO DE PRATO

	public void cadastraPrato(String nome, double preco, String descricao)
			throws Exception {
		ItensDoCardapio prato = new Prato(nome, preco, descricao);
		if (cardapio.contains(prato)) {
			throw new Exception("prato ja cadastrado.");
		}
		cardapio.add(prato);
	}

	// CADASTRO DE REFEICAO

	public void cadastraRefeicao(String nome, String descricao,	String componentes) throws Exception {
		verificaComponentes(componentes);
		ItensDoCardapio refeicao = new Refeicao(nome, descricao, separaComponentes(componentes));

		if (cardapio.contains(refeicao)) {
			throw new RefeicaoJaCadastradaException("refeicao ja cadastrada.");
		}
		cardapio.add(refeicao);
	}

	// CONSULTA DE ATRIBUTO PARA PRATO OU REFEICAO

	public String consultaRestaurante(String nome, String atributo)
			throws Exception {
		verificaNomeConsulta(nome);

		if (existeItem(nome)) {
			ItensDoCardapio item = encontraItem(nome);

			switch (atributo.toUpperCase()) {
			case "PRECO":
				return item.getPrecoString();
			case "DESCRICAO":
				return item.getDescricao();
			default:
				throw new Exception("Atributo inexistente.");
			}
		}
		throw new Exception("Prato ou refeicao nao existe.");
	}

	/*
	 * Os tres proximos metodos sao testes para o caso de uso 5
	 */

	public void ordenaMenu(String tipoOrdenacao) throws Exception {
		if (tipoOrdenacao == null || tipoOrdenacao.isEmpty()) {
			throw new Exception("tipo invalido.");
		} else if (tipoOrdenacao.equalsIgnoreCase("nome")) {
			ordenaPorNome();
		} else if (tipoOrdenacao.equalsIgnoreCase("preco")) {
			ordenaPorPreco();
		}
		else{
			throw new Exception("tipo inexistente.");
		}
	}

	public String consultaMenuRestaurante() {
		String imprimeCardapio = "";
		for (ItensDoCardapio item : cardapio) {
			imprimeCardapio += ";";
			imprimeCardapio += item.getNome();
		}
		imprimeCardapio = imprimeCardapio.substring(1);
		return imprimeCardapio;
	}

	public String realizaPedido(String email, String itemMenu) throws Exception {
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(itemMenu)) {
				return item.getPrecoString();
			}
		}
		return null;
	}

	// VERIFICA SE O NOME DADO NO PARAMETRO EH VALIDO

	private void verificaNomeConsulta(String nome) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomePratoVazioException(
					"Erro na consulta do restaurante. Nome do prato esto vazio.");
		}
	}

	// SEPARA OS COMPONENTES DA REFEICAO QUE ESTAVAM EM STRING PRA PODER AVALIAR
	// SE SAO VALIDOS

	private ArrayList<Prato> separaComponentes(String componentes) throws Exception {
		String[] componentesSplit;
		ArrayList<Prato> pratos = new ArrayList<Prato>();
		componentesSplit = componentes.split(";");

		for (String nomePrato : componentesSplit) {
			for (ItensDoCardapio item : cardapio) {
				if(item instanceof Prato) {
					Prato prato = (Prato) item;
					if(prato.getNome().equalsIgnoreCase(nomePrato)) {
						pratos.add(prato);
					}
				}				
			}
		}
		if(componentesSplit.length != pratos.size()) {
			throw new PratoInexistenteRefeicaoException(
					"Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
		if(pratos.size() < 3 || pratos.size() > 4) {
			throw new NumeroDePratosRefeicaoException(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		return pratos;	
	}

	// VERIFICA SE O COMPONENTES DA REFEICAO SAO PRATOS VALIDOS

	private void verificaComponentes(String componentes) throws Exception {
		if (componentes == null || componentes.trim().isEmpty()) {
			throw new ComponenteRefeicaoVazioException(
					"Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
	}

	// VERIFICA SE UM PRATO OU REFEICAO EXISTE NO CARDAPIO

	private boolean existeItem(String nome) {
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

	// ENCONTRA UM ITEM NO CARDAPIO

	private ItensDoCardapio encontraItem(String nome) throws Exception {
		for (ItensDoCardapio item : cardapio) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				return item;
			}
		}
		throw new Exception("item inexistente.");
	}

	// METODO QUE ORDENA O CARDAPIO POR ORDEM ALFABETICA

	public List<ItensDoCardapio> ordenaPorNome() {

		Collections.sort(cardapio, new NomeComparator());
		return cardapio;
	}
	
	public List<ItensDoCardapio> ordenaPorPreco() {
		
		Collections.sort(cardapio, new PrecoComparator());
		return cardapio;
	}
}
