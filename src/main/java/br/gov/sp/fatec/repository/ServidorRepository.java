package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Servidor;

public interface ServidorRepository extends CrudRepository<Servidor,Long>{
	
	public Servidor findByIp(String ip);
	
	public List<Servidor> findByMaquinaContainsIgnoreCaseOrNomeContainsIgnoreCase(String maquina,String servidor);
	/*
	@Query("select s from Servidor s where s.maquina = :maquina or s.servidor = :servidor")
	public List<Servidor> findByMaquinaOrServidorname (@Param("maquina") String maquina,@Param("servidor") String servidor);
 	*/
	@Query("select s from Servidor s where s.ip = :nome")
	public Servidor findByNome(@Param("nome") String nome);
	
	@Query("select count(*) from Servidor s where s.ip = :ip")
	public int findByQntip(@Param("ip") String ip);
	
	@Query(value="select distinct s.ser_ip from ser_servidor s", nativeQuery = true)
	public List<String> findBySerip();


}
