package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Banco;

public interface BancoRepository extends CrudRepository<Banco,Long>{
	
	public Banco findByNome(String nome);
	
	public Banco findByPorta(Integer porta);
	
	//public Banco findById(Long id);
	
	
	@Query("select count(s.porta) from Banco s where s.porta = :porta")
	public int findByContport(@Param("porta") Integer porta);
	
	@Query(value="select count(b.ban_porta) from ban_banco b JOIN ser_servidor s ON (b.ser_id = s.ser_id) where b.ban_porta  = :porta and s.ser_ip = :ip", nativeQuery = true)
	public int findByContinsert(@Param("porta") Integer porta,@Param("ip") String ip );
	
	
}
