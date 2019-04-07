package br.com.Vendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;

public class FornecedorDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fornecedor fornecedor1 = new Fornecedor();
		Fornecedor fornecedor2 = new Fornecedor();
		Fornecedor fornecedor3 = new Fornecedor();

		fornecedor1.setDescricao("Pedro Campos");
		fornecedor2.setDescricao("Mauro Santos");
		fornecedor3.setDescricao("Luis Paulo");

		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();

		fornecedoresDAO.salvar(fornecedor1);
		fornecedoresDAO.salvar(fornecedor2);
		fornecedoresDAO.salvar(fornecedor3);

	}

	@Test
	public void editar() {
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
		Fornecedor fornecedor = fornecedoresDAO.buscarPorCodigo(7L);
		fornecedor.setDescricao("Paula Campos");;
		fornecedoresDAO.editar(fornecedor);	
	}

	@Test
	@Ignore
	public void excluir() {
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
		Fornecedor fornecedor = fornecedoresDAO.buscarPorCodigo(6L);
		fornecedoresDAO.excluir(fornecedor);

	}

	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fornecedoresDAO.listar();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}

	}

	@Test
	@Ignore
	public void listarPorCodigo() {
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
		Fornecedor fornecedor1 = fornecedoresDAO.buscarPorCodigo(3L);
		Fornecedor fornecedor2 = fornecedoresDAO.buscarPorCodigo(4L);

		System.out.println(fornecedor1);
		System.out.println(fornecedor2);

	}

}
