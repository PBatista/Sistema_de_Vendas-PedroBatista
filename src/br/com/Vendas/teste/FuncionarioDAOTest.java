package br.com.Vendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome("Luis Gustavo");
		funcionario.setCpf("12345678482");
		funcionario.setSenha("123");
		funcionario.setFuncao("Gerente");
			
		FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
		funcionariosDAO.salvar(funcionario);


	}
	
	@Test
	public void excluir () {
		FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
		Funcionario funcionario = funcionariosDAO.buscarPorCodigo(1L);
		funcionariosDAO.excluir(funcionario);
	}
	
	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO funcionarioDAO = new FuncionariosDAO();
		List<Funcionario> funcionarios = funcionarioDAO.listar();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

	}


}
