package br.com.celti.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.celti.web.model.bean.Fornecedor;
import br.com.celti.web.model.bean.Funcionario;
import br.com.celti.web.model.bean.TipoFuncionario;
import br.com.celti.web.model.dao.FornecedorDAO;
import br.com.celti.web.model.dao.FuncionarioDAO;
import br.com.celti.web.model.dao.JPAUtil;

@ManagedBean(name = "cadastroFuncionarioController")
@SessionScoped
public class CadastroFuncionarioController implements Serializable {
	
	private static final long serialVersionUID = 4627956945726682013L;
	
	private String nome;
	private String login;
	private String senha;
	private String endereco;
	private String contato;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public String cadastrar(){
		
		EntityManager entitymanager = JPAUtil.getEntityManager();
		
		FuncionarioDAO fDAO = new FuncionarioDAO(entitymanager);

		entitymanager.getTransaction().begin();
		
		Funcionario f = new Funcionario();
		TipoFuncionario tf = new TipoFuncionario();
				
		tf.setId(new Long(1));
		
		f.setNome(this.nome);
		f.setLogin(this.login);
		f.setSenha(this.senha);
		f.setContato(this.contato);
		f.setEndereco(this.endereco);
		f.setTipoFuncionario(tf);
		
		fDAO.cadastrar(f);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		return "";
		
	}

}
