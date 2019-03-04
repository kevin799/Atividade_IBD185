package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Banco;

public interface BancoService {
	
	public Boolean incluiBanco(String nome,String tipo,String versao,String porta,String desenvolvedor,String ip);
	
	public Banco incluiBancoClasse(Banco banco);
	
	

}
