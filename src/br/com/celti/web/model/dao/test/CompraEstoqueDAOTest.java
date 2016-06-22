package br.com.celti.web.model.dao.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.celti.web.model.bean.CompraEstoque;
import br.com.celti.web.model.bean.Funcionario;
import br.com.celti.web.model.bean.Produto;
import br.com.celti.web.model.dao.CompraEstoqueDAO;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.dao.ProdutoDAO;

public class CompraEstoqueDAOTest {
/*
	@Test
	public void testCadastrar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		
		CompraEstoqueDAO ceDAO = new CompraEstoqueDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		CompraEstoque ce = new CompraEstoque();
		Funcionario f = new Funcionario();
		Produto p = new Produto();

		f.setId(new Long(1));
		p.setId(new Long(3));
		
		ce.setData(new Date());
		ce.setQtde(15);
		ce.setFuncionario(f);
		ce.setProduto(p);
		
		ceDAO.cadastrar(ce);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
	}
*/
	/*
	@Test
	public void testListar() {
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		CompraEstoqueDAO ceDAO = new CompraEstoqueDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		List<CompraEstoque> lce = ceDAO.listar();
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		for (CompraEstoque ce : lce) {
			System.out.println(ce.getFuncionario().getNome());
			System.out.println(ce.getProduto().getNome());
			System.out.println(ce.getQtde());
			System.out.println(ce.getData());
		}
		
	}*/

	@Test
	public void testListarPorPeriodo() {
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		CompraEstoqueDAO ceDAO = new CompraEstoqueDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		List<CompraEstoque> lce = ceDAO.listarPorPeriodo("21/06/2016", "22/06/2016");
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		for (CompraEstoque ce : lce) {
			System.out.println(ce.getFuncionario().getNome());
			System.out.println(ce.getProduto().getNome());
			System.out.println(ce.getQtde());
			System.out.println(ce.getData());
		}
		
	}
}
