package br.com.celti.web.model.dao.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.celti.web.model.bean.Funcionario;
import br.com.celti.web.model.bean.TipoFuncionario;
import br.com.celti.web.model.dao.FuncionarioDAO;
import br.com.celti.web.model.dao.JPAUtil;

public class FuncionarioDAOTest {

	@Test
	public void testCadastrar() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		
		FuncionarioDAO fDAO = new FuncionarioDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		Funcionario f = new Funcionario();
		TipoFuncionario tf = new TipoFuncionario();
				
		tf.setId(new Long(1));
		
		f.setNome("Fulano de Almeida");
		f.setLogin("fulano");
		f.setSenha("123");
		f.setContato("contato");
		f.setEndereco("endereco");
		f.setTipoFuncionario(tf);
		
		fDAO.cadastrar(f);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
	}
	
	@Test 
	public void testValidar(){
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		
		FuncionarioDAO fDAO = new FuncionarioDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		Funcionario f = new Funcionario();
			
		f = fDAO.validar("fulano", "123");

		entitymanager.getTransaction().commit();
		
		System.out.println(f.getNome());
	}

}
