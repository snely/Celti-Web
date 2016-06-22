package br.com.celti.web.model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@Entity(name="compra_estoque")
public class CompraEstoque {

	@Id
	@GeneratedValue
	@Column(name="idcompra_estoque")
	private Long id;
	
	private Integer qtde;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="produto_idproduto")
	@ForeignKey(name="idproduto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="funcionario_idfuncionario")
	@ForeignKey(name="idfuncionario") 
	private Funcionario funcionario;
	
	@Temporal(TemporalType.DATE)
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
