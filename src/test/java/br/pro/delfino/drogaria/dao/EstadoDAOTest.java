package br.pro.delfino.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;
import java.util.List;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de registros encontrados: " + resultado.size());
		
		for(Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	// teste de exclusão de registro
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado != null) {
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			estadoDAO.excluir(estado);
		} else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	// Editar
	@Test
	public void editar() {
		Long codigo = 11L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null) {
			System.out.println("Nenhum registro encontrado para realizar atualizacao");
		} else {
			estado.setNome("Minas Gerais");
			estado.setSigla("MG");
			estadoDAO.editar(estado);
			System.out.println("Registro atualizado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());			
		}
	}
	
}
