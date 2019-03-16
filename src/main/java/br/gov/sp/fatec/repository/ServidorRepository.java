package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Servidor;

public interface ServidorRepository extends CrudRepository<Servidor,Long>{
	
	public Servidor findByIp(String ip);
	
	@Query("select s from Servidor s where s.ip = :nome")
	public Servidor findByNome(@Param("nome") String nome);
	
	@Query("select count(*) from Servidor s where s.ip = :ip")
	public int findByQntip(@Param("ip") String ip);


}
