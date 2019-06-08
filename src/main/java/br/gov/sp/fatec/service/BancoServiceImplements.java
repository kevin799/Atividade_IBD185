package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

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
	public Banco incluiBancoClasse(Banco banco) {
		if(bancRep.findByContinsert(banco.getPorta(), banco.getServidor().getIp())==0) {
			bancRep.save(banco);
			return banco;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Banco> listar(String ip) {
		List<Servidor> servidor = servRep.findByIp(ip);
		List<Banco> banco = new ArrayList();
		List<Long> l = new ArrayList();
		
		for(Servidor s: servidor) {
			l.add(s.getId());
		}
		for(Long num:l) {
			banco.add(bancRep.findByBanco(num));
		}
		return banco;
	}

}
