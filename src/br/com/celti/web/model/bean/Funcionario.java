package br.com.celti.web.model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

@Entity(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue
	@Column(name= "idfuncionario")
	private Long id;
	
	private String nome;
	private String login;
	private String senha;
	private String endereco;
	private String contato;
		
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_funcionario_idtipo_funcionario")
	@ForeignKey(name="idtipo_funcionario")
    private TipoFuncionario tipoFuncionario;
	
    @OneToMany(cascade=CascadeType.ALL)
    private Set<CompraEstoque> items = new HashSet<CompraEstoque>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	public Set<CompraEstoque> getItems() {
		return items;
	}
	public void setItems(Set<CompraEstoque> items) {
		this.items = items;
	} 
	
}
