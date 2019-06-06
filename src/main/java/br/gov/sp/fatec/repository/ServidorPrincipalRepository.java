package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.ServidorPrincipal;

public interface ServidorPrincipalRepository extends CrudRepository<ServidorPrincipal,Long>{
	
	public ServidorPrincipal findByIp(String ip);

}
