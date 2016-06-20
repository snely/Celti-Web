package br.com.celti.web.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.celti.web.model.bean.Funcionario;

public class FuncionarioDAO {

	private EntityManager entityManager;

	public FuncionarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Funcionario funcionario) {
		entityManager.persist(funcionario);
	}

	public void alterar(Funcionario funcionario) {

		entityManager.merge(funcionario);
	}

	public void excluir(Funcionario funcionario) {
		entityManager.remove(entityManager.merge(funcionario));
	}

	public Funcionario consultar(Long id) {
		return entityManager.getReference(Funcionario.class, id);
	}

	public Funcionario validar(String login, String senha) {
		String jpql = "Select f from funcionario f where f.login = :customLogin";
		Query query = entityManager.createQuery(jpql).setParameter("customLogin", login);
		List<Funcionario> l = query.getResultList();
		
		if (l.size() == 0) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	public List<Funcionario> listar() {
		String jpql = "Select f from funcionario f order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
