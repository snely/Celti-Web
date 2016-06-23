package br.com.celti.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.celti.web.model.bean.Fornecedor;
import br.com.celti.web.model.dao.FornecedorDAO;
import br.com.celti.web.model.dao.JPAUtil;

@ManagedBean(name = "cadastroFornecedorController")
@SessionScoped
public class CadastroFornecedorController implements Serializable {

	private static final long serialVersionUID = 1250136977046990356L;
	
	private String cnpj;
	private String nome;
	private String endereco;
	private String contato;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

	public String cadastrarFornecedor(){     
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		FornecedorDAO tfDAO = new FornecedorDAO(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		Fornecedor tf = new Fornecedor();
				
		tf.setCnpj(this.cnpj);
		tf.setNome(this.contato);
		tf.setContato(this.endereco);
		tf.setEndereco(this.nome);
		
		tfDAO.cadastrar(tf);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		
		
		
		
		return "";
	}
	
	
	
}


