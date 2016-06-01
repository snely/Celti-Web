package br.com.celti.web.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.celti.web.model.bean.Produto;

public class ProdutoDAO {

	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Produto produto) {
		entityManager.persist(produto);
	}

	public void alterar(Produto produto) {

		entityManager.merge(produto);
	}

	public void excluir(Produto produto) {
		entityManager.remove(entityManager.merge(produto));
	}

	public Produto consultar(Long id) {
		return entityManager.getReference(Produto.class, id);
	}

	public List<Produto> listar() {
		String jpql = "Select p from produto p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
}
