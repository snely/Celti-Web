package br.com.celti.web.model.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.celti.web.model.bean.TipoFuncionario;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.dao.TipoFuncionarioDAO;
import junit.framework.Assert;

public class TipoFuncionarioDAOTest {

	@Test
	public void testCadastrar() {
/*
		EntityManager entitymanager = JPAUtil.getEntityManager();
		TipoFuncionarioDAO tfDAO = new TipoFuncionarioDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		TipoFuncionario tf = new TipoFuncionario();
				
		tf.setDescricao("Novo");
		
		tfDAO.cadastrar(tf);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		Assert.assertNotNull(tf.getDescricao());
		*/
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
//		fail("Not yet implemented");

		EntityManager entitymanager = JPAUtil.getEntityManager();
		TipoFuncionarioDAO tfDAO = new TipoFuncionarioDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		TipoFuncionario tf = tfDAO.consultar(new Long(1));
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		System.out.println(tf.getDescricao());
		
	}

	@Test
	public void testListar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		TipoFuncionarioDAO tfDAO = new TipoFuncionarioDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		List<TipoFuncionario> ltf = tfDAO.listar();
		
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		
		//Assert.assertNotNull(tf.getDescricao());
		for (TipoFuncionario tf : ltf) {
			System.out.println(tf.getId());
		}
	}

}
