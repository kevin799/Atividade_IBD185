package br.gov.sp.fatec.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import br.gov.sp.fatec.model.ServidorPrincipal;

public interface ServidorPrincipalRepository extends CrudRepository<ServidorPrincipal,Long>{
	
	public ServidorPrincipal findByIp(String ip);
	
	@Query(value="select * from ser_servidor_principal", nativeQuery = true)
	public List<ServidorPrincipal> findTudo();

}
