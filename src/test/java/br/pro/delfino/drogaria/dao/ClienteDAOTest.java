package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Cliente cliente = new Cliente();
		//[ebs]cliente.setDataCadastro(new Date());
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("28/04/2020"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}

}
