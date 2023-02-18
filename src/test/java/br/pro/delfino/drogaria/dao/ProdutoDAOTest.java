package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("16"));
				
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 comprimidos");
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("10"));
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
	
	//[ebs] completar com buscar, listar, excluir e editar
}
