package br.pro.delfino.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.pro.delfino.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		// pegar a classe que chamou esta classe generica
		// porque o "criteria" precisa saber a classe Entidade que vai aplicar o critério
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade) {
		// criar uma sessão junto ao banco de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		// controle de transação porque vai ser realizada uma operação no banco de dados
		Transaction transacao = null;
		
		// toda operacao no banco precisa de um try porque pode ocorrer erros diversos
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// se houve erro e iniciou transação, executar rollback
			if(transacao != null) {
				transacao.rollback();
			}
			throw erro; // propagar o erro para o programa todo
		} finally {
			// fechar a sessão, senão a conexão fica aberta
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}		
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}		
	}
	
	public void excluir(Entidade entidade) {
		// criar uma sessão junto ao banco de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		// controle de transação porque vai ser realizada uma operação no banco de dados
		Transaction transacao = null;
		
		// toda operacao no banco precisa de um try porque pode ocorrer erros diversos
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// se houve erro e iniciou transação, executar rollback
			if(transacao != null) {
				transacao.rollback();
			}
			throw erro; // propagar o erro para o programa todo
		} finally {
			// fechar a sessão, senão a conexão fica aberta
			sessao.close();
		}
	} 
	
	public void editar(Entidade entidade) {
		// criar uma sessão junto ao banco de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		// controle de transação porque vai ser realizada uma operação no banco de dados
		Transaction transacao = null;
		
		// toda operacao no banco precisa de um try porque pode ocorrer erros diversos
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// se houve erro e iniciou transação, executar rollback
			if(transacao != null) {
				transacao.rollback();
			}
			throw erro; // propagar o erro para o programa todo
		} finally {
			// fechar a sessão, senão a conexão fica aberta
			sessao.close();
		}
	} 
	
	public void merge(Entidade entidade) {
		// criar uma sessão junto ao banco de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		// controle de transação porque vai ser realizada uma operação no banco de dados
		Transaction transacao = null;
		
		// toda operacao no banco precisa de um try porque pode ocorrer erros diversos
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// se houve erro e iniciou transação, executar rollback
			if(transacao != null) {
				transacao.rollback();
			}
			throw erro; // propagar o erro para o programa todo
		} finally {
			// fechar a sessão, senão a conexão fica aberta
			sessao.close();
		}
	}

}
