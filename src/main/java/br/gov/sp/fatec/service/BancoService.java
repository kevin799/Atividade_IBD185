package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Banco;

public interface BancoService {
	
	public Banco incluiBancoClasse(Banco banco);
	
	public List<Banco> listar(String ip);
	
	public void delete(Banco banco);
	
}
