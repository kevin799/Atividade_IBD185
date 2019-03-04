package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Banco;
import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.BancoRepository;
import br.gov.sp.fatec.repository.ServidorRepository;
import br.gov.sp.fatec.service.BancoService;
import br.gov.sp.fatec.service.ServidorService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SpringDataJpaTest {
	
	private static final String IP ="192.161.1.3";
	private static final String NOME ="Servidor 2";
	private static final String MAQUINA ="AWS";
	private static final String PROCESSADOR ="i7";
	private static final int MEMORIA = 8;
	private static final String ESPACO ="1Tb";
	
	private static final String NOME_BANCO = "SQL Server";
	private static final String TIPO = "Developer";
	private static final String VERSAO = "2017";
	private static final String PORTA ="8085";
	private static final String DESENVOLVEDOR = "Microoft";
	
	
	
	@Autowired
	private ServidorRepository servRep;
	@Autowired
	private ServidorService servidorService;
	@Autowired
	private BancoRepository bancRep;
	@Autowired
	private BancoService bancoService;
	
	public void setServidorRepo(ServidorRepository servidor) {
		this.servRep = servidor;
	}
	
	

	@Test
	public void TestServiceServidorInsertBD(){
		Servidor serivdor1 = new Servidor();
		serivdor1.setServidor(IP, NOME, MAQUINA, PROCESSADOR, MEMORIA, ESPACO );
		servRep.save(serivdor1);
		servidorService.incluiServidor(serivdor1);
		System.out.println(servRep.findByQntip(IP));
		assertEquals(servRep.findByQntip(IP),1);		
	}
	
	@Test
	public void TestServiceServidorCosnultaBD(){
		Servidor serivdor1 = new Servidor();
		serivdor1.setServidor(IP, NOME, MAQUINA, PROCESSADOR, MEMORIA, ESPACO );
		servRep.save(serivdor1);
		servidorService.incluiServidor(serivdor1);
		
		assertEquals(servRep.findByIp(IP).getMaquina(),MAQUINA);		
	}
	
	@Test
	public void TestServiceBancoInclusaoConsultaBDDadosRepetidos(){
		Servidor serivdor1 = new Servidor();
		serivdor1.setServidor(IP, NOME, MAQUINA, PROCESSADOR, MEMORIA, ESPACO );
		Banco ban = new Banco(NOME_BANCO,TIPO,VERSAO,PORTA,DESENVOLVEDOR);
		ban.setServidor(new ArrayList<Servidor>());
		ban.getServidor().add(serivdor1);
		bancoService.incluiBancoClasse(ban);
		//Impede que haja insercao de dados repetidos em um mesmo IP
		assertFalse(bancoService.incluiBanco(NOME_BANCO,TIPO,VERSAO,PORTA,DESENVOLVEDOR,IP));
	}
	
	@Test
	public void TestRepositoryBancoConsultaBD(){
		Servidor serivdor1 = new Servidor();
		serivdor1.setServidor(IP, NOME, MAQUINA, PROCESSADOR, MEMORIA, ESPACO );
		Banco ban = new Banco(NOME_BANCO,TIPO,VERSAO,PORTA,DESENVOLVEDOR);
		ban.setServidor(new ArrayList<Servidor>());
		ban.getServidor().add(serivdor1);
		bancoService.incluiBancoClasse(ban);
		assertEquals(bancRep.findByPorta(PORTA).getNome(),"SQL Server");
	}
	
	

}
