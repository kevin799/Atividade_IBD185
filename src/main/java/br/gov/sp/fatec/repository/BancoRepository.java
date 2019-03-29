package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Banco;

public interface BancoRepository extends CrudRepository<Banco,Long>{
	
	public Banco findByNome(String nome);
	
	public Banco findByPorta(String porta);
	
	//public Banco findById(Long id);
	
	
	@Query("select count(s.porta) from Banco s where s.porta = :porta")
	public int findByContport(@Param("porta") String porta);

}
