package br.com.celti.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "menuPrincipalController")
@SessionScoped
public class MenuPrincipalController implements Serializable {

	private static final long serialVersionUID = 4380206611800319580L;

	public String abrirTelaRelatorios() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("relatorios.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String abrirPrincipal() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
