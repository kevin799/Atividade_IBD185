package br.gov.sp.fatec.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.gov.sp.fatec.model.ServidorPrincipal;

public interface ServidorPrincipalRepository extends CrudRepository<ServidorPrincipal,Long>{
	
	public List<ServidorPrincipal> findByIp(String ip);
	
	@Query(value="select * from ser_servidor_principal", nativeQuery = true)
	public List<ServidorPrincipal> findTudo();
	/*
	@Query(value="update ser_servidor_principal set ser_status = 1 where ser_ip = :ip ", nativeQuery = true)
	public void ligaServidor(@Param("ip") String ip);
	
	@Query(value="update banco.ser_servidor_principal set ser_status = 0 where ser_ip = :ip ", nativeQuery = true)
	public void deslogaServidor(@Param("ip") String ip);
	*/
}
