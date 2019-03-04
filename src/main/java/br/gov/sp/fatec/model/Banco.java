package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BAN_BANCO")
public class Banco {
	
	public Banco(){
		
	}
	
	public Banco(String nome,String tipo,String versao,String porta,String desenvolvedor) {
		this.nome = nome;
		this.tipo = tipo;
		this.versao = versao;
		this.porta = porta;
		this.desenvolvedor = desenvolvedor;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BAN_ID")
	private Long id;
	
	@Column(name = "BAN_NOME")
	private String nome;
	
	@Column(name = "BAN_TIPO")
	private String tipo;
	
	@Column(name = "BAN_VERSAO")
	private String versao;
	
	@Column(name = "BAN_PORTA")
	private String porta;
	
	@Column(name = "BAN_DESENVOLVEDOR")
	private String desenvolvedor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "seb_servidor_banco",
			joinColumns = { @JoinColumn(name = "SER_ID") },
			inverseJoinColumns = { @JoinColumn(name = "BAN_ID" )}
			)
	private List<Servidor> servidor;
			
			

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
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public List<Servidor> getServidor() {
		return servidor;
	}

	public void setServidor(List<Servidor> servidor) {
		this.servidor = servidor;
	}
	
	
	
	
	
	
	

}
