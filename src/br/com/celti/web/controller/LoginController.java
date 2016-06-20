package br.com.celti.web.controller;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.celti.web.model.bean.Funcionario;
import br.com.celti.web.model.dao.FuncionarioDAO;
import br.com.celti.web.model.dao.JPAUtil;
import br.com.celti.web.model.utils.SessionUtils;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String login;
	private String senha;
	private Funcionario user;
	
	private boolean logado = false;

	public LoginController() {
		HttpSession hs = SessionUtils.getSession();
		Funcionario f = SessionUtils.getFuncionarioUser();
		
		System.out.println(hs);
		System.out.println(f);
		this.logado = (hs != null && f != null) ? true : false;
		
		if (this.logado) {
			FacesContext.getCurrentInstance().getExternalContext().encodeActionURL("logado");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().encodeActionURL("nlogado");
		}
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

	public Funcionario getUser() {
		return user;
	}

	public void setUser(Funcionario user) {
		this.user = user;
	}

	//validate login
	public String validarLogin() {

		EntityManager entitymanager = JPAUtil.getEntityManager();
		FuncionarioDAO fDAO = new FuncionarioDAO(entitymanager);
		entitymanager.getTransaction().begin();
		
		this.user = fDAO.validar(login, senha);
		entitymanager.getTransaction().commit();
		
		if (this.user != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("user", user);
			return "logado";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			JOptionPane.showMessageDialog(null, "Login ou senha estão incorretos. Tente novamente!");
			return "nlogado";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "nlogado";
	}

}
