package br.com.celti.web.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.celti.web.model.bean.CompraEstoque;

public class CompraEstoqueDAO {
private EntityManager entityManager;
	
	public CompraEstoqueDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(CompraEstoque compraEstoque){
		entityManager.persist(compraEstoque);
	}
	
	public void alterar(CompraEstoque compraEstoque){
		
		entityManager.merge(compraEstoque);
	}
	public void excluir(CompraEstoque compraEstoque){
		entityManager.remove(entityManager.merge(compraEstoque));
	}
	
	public CompraEstoque consultar(Long id){
		return entityManager.getReference(CompraEstoque.class, id);
	}
	
	public List<CompraEstoque> listar(){
		String jpql = "Select ce from compra_estoque ce order by data DESC";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
