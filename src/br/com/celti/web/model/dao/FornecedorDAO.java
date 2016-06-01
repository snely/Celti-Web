package br.com.celti.web.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.celti.web.model.bean.Fornecedor;

public class FornecedorDAO {

	private EntityManager entityManager;
	
	public FornecedorDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Fornecedor tipo){
		entityManager.persist(tipo);
	}
	
	public void alterar(Fornecedor tipo){
		
		entityManager.merge(tipo);
	}
	public void excluir(Fornecedor tipo){
		entityManager.remove(entityManager.merge(tipo));
	}
	
	public Fornecedor consultar(String cnpj){
		return entityManager.getReference(Fornecedor.class, cnpj);
	}
	
	public List<Fornecedor> listar(){
		String jpql = "Select tf from fornecedor tf order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
}

