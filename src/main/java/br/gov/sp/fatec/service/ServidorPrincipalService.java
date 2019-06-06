package br.gov.sp.fatec.service;

import java.util.Collection;
import java.util.List;

import br.gov.sp.fatec.model.ServidorPrincipal;

public interface ServidorPrincipalService {
	public ServidorPrincipal salvar(ServidorPrincipal servidorP);
	
	public List<ServidorPrincipal> lista();
	
	public ServidorPrincipal ligarServidor(String ip);
	
	public ServidorPrincipal desligaServidor(String ip);
	
	public ServidorPrincipal atualizaServidor(String ip, String nome, String maquina,String processador,int memoria,String espaco);
	
}
