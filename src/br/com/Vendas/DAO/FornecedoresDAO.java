package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrindo a transacao
			sessao.save(fornecedor);
			transacao.commit(); // confirma a transacao

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
				sessao.close();
				ex.printStackTrace();
			}
		} finally {
			sessao.close();
		}

	}
	
	public void editar (Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
			fornecedorEditar.setDescricao(fornecedor.getDescricao());
			sessao.update(fornecedor);
			transacao.commit(); 

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); 
				sessao.close();
				ex.printStackTrace();
			}
		} finally {
			sessao.close();
		}

	}
	
	public void excluir(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrindo a transacao
			sessao.delete(fornecedor);
			transacao.commit(); // confirma a transacao

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
				sessao.close();
				ex.printStackTrace();
			}
		} finally {
			sessao.close();
		}

	}
	
	
	@SuppressWarnings({ "unchecked" })
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Fornecedor> fornecedores = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			sessao.close();
		}

		return fornecedores;
	}

	public Fornecedor buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			sessao.close();
		}

		return fornecedor;

	}

}
