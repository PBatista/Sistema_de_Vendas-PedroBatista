package br.com.Vendas.teste;

import org.junit.Test;

import br.com.Vendas.util.HibernateUtil;

public class GerarTabelaTest {

	@Test
	public void gerar() {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
