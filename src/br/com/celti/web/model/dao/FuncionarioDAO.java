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

	public List<Funcionario> listar() {
		String jpql = "Select f from funcionario f order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
