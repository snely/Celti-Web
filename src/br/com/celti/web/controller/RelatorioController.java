package br.com.celti.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.celti.web.model.bean.CompraEstoque;
import br.com.celti.web.model.dao.CompraEstoqueDAO;
import br.com.celti.web.model.dao.JPAUtil;


@ManagedBean(name = "relatorioController")
@SessionScoped
public class RelatorioController implements Serializable {

	private static final long serialVersionUID = 8507347673961821362L;

	private String dataInicial;
	private String dataFinal;
	
	private List<CompraEstoque> listaCompra = new ArrayList<CompraEstoque>();
	
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public List<CompraEstoque> getListaCompra() {
		return listaCompra;
	}
	
	public void setListaCompra(List<CompraEstoque> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	public String mostrarRelatorio() {
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		CompraEstoqueDAO ceDAO = new CompraEstoqueDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		List<CompraEstoque> l = ceDAO.listar();
		
		this.listaCompra.clear();
		
		entitymanager.getTransaction().commit();
			
		for (CompraEstoque ce : l) {
			this.listaCompra.add(ce);
		}
		
		return "";
	}
	
	
	
}
