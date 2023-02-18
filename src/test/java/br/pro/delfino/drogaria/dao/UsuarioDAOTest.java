package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Usuario usuario = new Usuario();
		usuario.setPessoa(pessoa);
		usuario.setTipo('A');
		usuario.setAtivo(true);
		usuario.setSenha("q2w3e4r5");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuario criado");
	}

}
