package br.com.celti.web.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.celti.web.model.bean.TipoFuncionario;

public class TipoFuncionarioDAO {

	private EntityManager entityManager;
	
	public TipoFuncionarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(TipoFuncionario tipo){
		entityManager.persist(tipo);
	}
	
	public void alterar(TipoFuncionario tipo){
		
		entityManager.merge(tipo);
	}
	public void excluir(TipoFuncionario tipo){
		entityManager.remove(entityManager.merge(tipo));
	}
	
	public TipoFuncionario consultar(Long id){
		return entityManager.getReference(TipoFuncionario.class, id);
	}
	
	public List<TipoFuncionario> listar(){
		String jpql = "Select tf from tipo_funcionario tf order by descricao";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
}
