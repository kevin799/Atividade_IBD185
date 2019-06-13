package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;

import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.model.ServidorPrincipal;
import br.gov.sp.fatec.repository.ServidorPrincipalRepository;
import br.gov.sp.fatec.repository.ServidorRepository;

@Service("ServidorPrincipalService")
@Transactional
public class ServidorPrincipalServiceImpl implements ServidorPrincipalService{

	@Autowired
	public ServidorPrincipalRepository serPrRep;
	@Autowired
	public ServidorRepository serRep;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	public ServidorPrincipal salvar(ServidorPrincipal servidorP) {
		ServidorPrincipal p = null;
		List<ServidorPrincipal> retorno = new ArrayList<ServidorPrincipal>();
		retorno = serPrRep.findByIp(servidorP.getIp());
		for(ServidorPrincipal servidor: retorno) {
			p = servidor;
		}
		if(p==null) {
			serPrRep.save(servidorP);
			return servidorP;
		}
		else {
			return null;
		}
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public List<ServidorPrincipal> lista() {
		List<ServidorPrincipal> retorno = new ArrayList<ServidorPrincipal>();
		for(ServidorPrincipal servidor: serPrRep.findAll()) {
			retorno.add(servidor);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ServidorPrincipal ligarServidor(String ip) {
		ServidorPrincipal s = null;
		for (ServidorPrincipal servidor: serPrRep.findByIp(ip)) {
			s = servidor;
			
		}
		s.setStatus(1);
		serPrRep.save(s);
		return s;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ServidorPrincipal desligaServidor(String ip) {
		ServidorPrincipal s = null;
		for (ServidorPrincipal servidor: serPrRep.findByIp(ip)) {
			s = servidor;
			
		}
		s.setStatus(0);
		serPrRep.save(s);
		return s;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ServidorPrincipal atualizaServidor(String ip, String nome, String maquina, String processador, int memoria,
			String espaco) {
		ServidorPrincipal s = null;
		
		for (ServidorPrincipal servidor: serPrRep.findByIp(ip)) {
			s = servidor;	
		}
		s.setNome(nome);
		s.setMaquina(maquina);
		s.setProcessador(processador);
		s.setMemoria(memoria);
		s.setEspaco(espaco);
		serPrRep.save(s);
		
		
		for(Servidor servidor:serRep.findByIp(ip)) {
			servidor.setNome(nome);
			servidor.setMaquina(s.getMaquina());
			servidor.setProcessador(processador);
			servidor.setMemoria(memoria);
			servidor.setEspaco(espaco);
			serRep.save(servidor);
		}
		
		return s;
	}

}
