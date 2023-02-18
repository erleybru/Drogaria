package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Marília");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	// Pesquisa
	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		for(Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("");
		}
	}
	
	// Buscar
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println("");		
	}
	
	// Excluir
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 6L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null) {
			System.out.println("");		
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("");		
			System.out.println("Cidade removida: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			cidadeDAO.excluir(cidade);
			System.out.println("Registro excluido");
		}
	}
		
	// Editar
	@Test
	public void editar() {		
		Long codigoCidade = 4L;
		Long codigoEstado = 11L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
			
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
			
		if(cidade == null) {
			System.out.println();
			System.out.println("registro não encontrado");
		} else {
			System.out.println("");		
			System.out.println("Cidade a ser atualizada: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
			cidade.setNome("Guarapuava");
			cidade.setEstado(estado);

			cidadeDAO.editar(cidade);
				
			System.out.println("");		
			System.out.println("Cidade atualizada: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		}
	}
}
