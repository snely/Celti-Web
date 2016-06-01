package br.com.celti.web.model.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.celti.web.model.bean.Fornecedor;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.dao.FornecedorDAO;
import junit.framework.Assert;

public class FornecedorDAOTest {

	@Test
	public void testCadastrar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		FornecedorDAO tfDAO = new FornecedorDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		Fornecedor tf = new Fornecedor();
				
		tf.setCnpj("123");//TROCAR SEMPRE QUE COMPILAR O JUNIT
		tf.setNome("Matheus");
		tf.setContato("contato");
		tf.setEndereco("endereco");
		
		tfDAO.cadastrar(tf);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
/*
		EntityManager entitymanager = JPAUtil.getEntityManager();
		FornecedorDAOTest tfDAO = new FornecedorDAOTest(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		Fornecedor tf = tfDAO.consultar(new Long(1));
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		Assert.assertNotNull(tf.getDescricao());
		System.out.println(tf.getDescricao());*/
		
	}

	/*@Test
	public void testlistar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		FornecedorDAOTest tfDAO = new FornecedorDAOTest();
		
		entitymanager.getTransaction().begin();
		
		List<Fornecedor> ltf = tfDAO.listar();
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		//Assert.assertNotNull(tf.getDescricao());
		for (Fornecedor tf : ltf) {
			Assert.assertNotNull(tf.getnome());
			System.out.println(tf.getnome());
		}
		}*/


}
