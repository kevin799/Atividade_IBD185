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
	public Boolean incluiBancoClasse(Banco banco) {
		if(bancRep.findByContport(banco.getPorta())!=1) {
			bancRep.save(banco);
			return true;
		}
		else {
			return false;
		}
	}

}
