package br.gov.sp.fatec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="SER_SERVIDOR")
public class Servidor {
	
	public Servidor(){
		
	}
	
	public Servidor(String ip, String nome, String maquina,String processador,int memoria,String espaco){
		this.ip = ip;
		this.nome = nome;
		this.maquina = maquina;
		this.processador = processador;
		this.memoria = memoria;
		this.espaco = espaco;
	}
	
	public void setServidor(String ip, String nome, String maquina,String processador,int memoria,String espaco) {
		this.ip = ip;
		this.nome = nome;
		this.maquina = maquina;
		this.processador = processador;
		this.memoria = memoria;
		this.espaco = espaco;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SER_ID")
	private Long id; 
	
	@Column(name = "SER_IP",unique=true, length = 50, nullable = false)
	private String ip;
	
	@Column(name = "SER_NOME")
	private String nome;
	
	@Column(name = "SER_MAQUINA")
	private String maquina;
	
	@Column(name = "SER_PROCESSADOR")
	private String processador;
	
	@Column(name = "SER_MEMORIA")
	private int memoria;
	
	@Column(name = "SER_ESPACO")
	private String espaco;
	
	@OneToMany(mappedBy = "servidor")
	private List<Banco> bancosServidor = new ArrayList<Banco>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	
	
	

}
