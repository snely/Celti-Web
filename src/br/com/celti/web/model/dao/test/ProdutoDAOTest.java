package br.com.celti.web.model.dao.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.celti.web.model.bean.Fornecedor;
import br.com.celti.web.model.bean.Produto;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.dao.ProdutoDAO;

public class ProdutoDAOTest {

	@Test
	public void testCadastrar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		
		ProdutoDAO pDAO = new ProdutoDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		Produto p = new Produto();
		Fornecedor f = new Fornecedor();
				
		f.setCnpj("123");
		
		p.setNome("ACER Aspire");
		p.setQtde(2);
		p.setValor(4100.3f);
		p.setFornecedor(f);
		
		pDAO.cadastrar(p);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
	}
	@Test
	public void testConsultar() {
//		fail("Not yet implemented");

		EntityManager entitymanager = JPAUtil.getEntityManager();
		ProdutoDAO pDAO = new ProdutoDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		Produto p = pDAO.consultar(new Long(1));
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		System.out.println(p.getNome());
		
	}

	@Test
	public void testListar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		ProdutoDAO pDAO = new ProdutoDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		List<Produto> lp = pDAO.listar();
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		for (Produto p : lp) {
			System.out.println(p.getNome());
		}
	}
}
