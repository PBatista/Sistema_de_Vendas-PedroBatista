package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.util.HibernateUtil;

public class FuncionariosDAO {
	
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrindo a transacao
			sessao.save(funcionario);
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
	
	
	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrindo a transacao
			sessao.delete(funcionario);
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
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> funcionarios = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			sessao.close();
		}

		return funcionarios;
	}

	public Funcionario buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			sessao.close();
		}

		return funcionario;

	}

}
