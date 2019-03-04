package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Banco;

public interface BancoRepository extends CrudRepository<Banco,Long>{
	
	public Banco findByNome(String nome);
	
	public Banco findByPorta(String porta);
	
	@Query("select count(*) from Banco s where s.desenvolvedor like ?1")
	public int findByDev(@Param(":desenvolvedor") String desenvolvedor);

}
