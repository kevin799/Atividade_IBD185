package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Banco;
import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.BancoRepository;
import br.gov.sp.fatec.repository.ServidorRepository;

@Service("BancoService")
public class BancoServiceImplements implements BancoService{
	
	@Autowired
	public ServidorRepository servRep;
	
	@Autowired
	public BancoRepository bancRep;	

	@Override
	@Transactional
	public Boolean incluiBanco(String nome, String tipo, String versao, String porta, String desenvolvedor, String ip) {
		Servidor serv = servRep.findByIp(ip);
		Banco banco = bancRep.findByPorta(porta);
		if((serv != null) && (banco == null)) {
			banco = new Banco(nome, tipo,versao,porta,desenvolvedor);
			bancRep.save(banco);
			return true;
		}
		
		return false;
	}

	@Override
	public Banco incluiBancoClasse(Banco banco) {
		return bancRep.save(banco);
	}

}
