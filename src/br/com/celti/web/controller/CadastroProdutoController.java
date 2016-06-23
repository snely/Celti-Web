package br.com.celti.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.celti.web.model.bean.Fornecedor;
import br.com.celti.web.model.bean.Produto;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.dao.ProdutoDAO;

@ManagedBean(name = "cadastroProdutoController")
@SessionScoped

public class CadastroProdutoController implements Serializable {

	private static final long serialVersionUID = -3275099071902799338L;
	
	private String nome;
	private String preco;
	private String quantidade;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}	
	
	public String cadastrarProduto (){
		
EntityManager entitymanager = JPAUtil.getEntityManager();
		
		ProdutoDAO pDAO = new ProdutoDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		Produto p = new Produto();
		Fornecedor f = new Fornecedor();
				
		f.setCnpj("1234");
		
		p.setNome(this.nome);
		p.setQtde(this.quantidade);
		p.setValor(this.preco);
		p.setFornecedor(f);
		
		pDAO.cadastrar(p);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		
		return "" ;
	}
	
}
