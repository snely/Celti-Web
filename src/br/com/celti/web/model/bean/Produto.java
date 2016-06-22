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

@Entity(name = "produto")
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "idproduto")
	private Long id;
	
	private String nome;
	private float valor;
	private int qtde;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fornecedor_cnpj")
	@ForeignKey(name="cnpj")
	private Fornecedor fornecedor;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
