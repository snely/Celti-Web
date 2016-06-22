package br.com.celti.web.model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.celti.web.model.bean.CompraEstoque;
import br.com.celti.web.model.bean.Funcionario;

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
	
	public List<CompraEstoque> listarPorPeriodo( String dataI, String dataF ){

		DateFormat f = DateFormat.getDateInstance();
		Date dDataI = new Date(), dDataF = new Date();
		try {
			dDataI = f.parse(dataI);
			dDataF = f.parse(dataI);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jpql = "Select ce from compra_estoque ce where ce.data BETWEEN :cDataI and :cDataF";
		Query query = entityManager.createQuery(jpql).setParameter("cDataF", dDataF, TemporalType.TIMESTAMP).setParameter("cDataI", dDataI, TemporalType.TIMESTAMP);
		List<CompraEstoque> l = query.getResultList();
		
		return l;
	}
}
