package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.ServidorRepository;

@Service("ServidorService")
public class ServidorServiceImplements implements ServidorService{
	
	@Autowired
	private ServidorRepository servRep;
	
	public void setServidor(ServidorRepository servRep) {
		this.servRep = servRep;
	}
			
	@Override
	@Transactional
	public Servidor incluiServidor(Servidor servidor) {
		
		return servRep.save(servidor);
		
	}

	

}
