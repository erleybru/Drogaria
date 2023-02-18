package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@Test
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		System.out.println("Pessoa encontrada");
		System.out.println("Código: " + pessoa.getCodigo());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		
		Funcionario funcionario = new Funcionario();
		funcionario.setPessoa(pessoa);
		funcionario.setCarteiraTrabalho("04300/00094-SP");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2020"));
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
	}
}
