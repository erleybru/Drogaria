package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	public void salvar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ana Julia Oliveira Silva");
		pessoa.setCpf("45583452905");
		pessoa.setRg("11112");
		pessoa.setEmail("anjos.bauru@gmail.com");
		pessoa.setRua("Rua dois");
		pessoa.setNumero(new Short("150"));
		pessoa.setComplemento("");
		pessoa.setBairro("Residencial Granja Cecília");		
		pessoa.setCep("17100-000");
		pessoa.setTelefone("");
		pessoa.setCelular("(14) 98143-8520");
		
		pessoa.setCidade(cidade);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

}
