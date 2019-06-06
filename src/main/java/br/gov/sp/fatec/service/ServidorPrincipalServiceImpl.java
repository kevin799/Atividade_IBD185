package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.ServidorPrincipal;
import br.gov.sp.fatec.repository.ServidorPrincipalRepository;

@Service("ServidorPrincipalService")
public class ServidorPrincipalServiceImpl implements ServidorPrincipalService{

	@Autowired
	public ServidorPrincipalRepository serPrRep;
	
	@Override
	@Transactional
	public ServidorPrincipal salvar(ServidorPrincipal servidorP) {
		if(serPrRep.findByIp(servidorP.getIp())==null) {
			serPrRep.save(servidorP);
			return servidorP;
		}
		else {
			return null;
		}
	}

}
