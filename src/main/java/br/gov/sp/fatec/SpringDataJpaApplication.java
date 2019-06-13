package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import br.gov.sp.fatec.model.Banco;
import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.model.ServidorPrincipal;
import br.gov.sp.fatec.repository.BancoRepository;
import br.gov.sp.fatec.repository.ServidorPrincipalRepository;
import br.gov.sp.fatec.repository.ServidorRepository;
import br.gov.sp.fatec.service.BancoService;
import br.gov.sp.fatec.service.ServidorPrincipalService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	
	@Autowired
	private ServidorRepository servRep;
	private Servidor serv;
	
	@Autowired
	private BancoRepository bancRep;
	@Autowired
	private BancoService bancoService;
	@Autowired
	private ServidorPrincipalService servPrServ;
	private ServidorPrincipal servP;
	@Autowired
	private ServidorPrincipalRepository spr;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		/////////////////////////////
		//System.out.println("Encontrou========>");
		//System.out.println(servRep.findByQntip("192.161.1.2"));
		serv = new Servidor("192.161.1.12", "Servidor 2", "AWS", "i7", 8, "1Tb",1);
		//servidorService.incluiServidor(serv);
		//System.out.println("Encontrou========>"+ bancoService.incluiBanco("SQL Server", "Developer", "2017", "8082", "Microsoft","192.161.1.1"));
		/*
		Banco ban = new Banco("Oracle", "Developer", "2017", 8081, "",serv,1);
		//ban.setServidor(new ArrayList<Servidor>());
		//ban.getServidor().add(serv);
		
		System.out.println("Encontrou========>"+ bancoService.incluiBancoClasse(ban));
		System.out.println("Lista servidores======>"+servRep.findBySerip());
		System.out.println("USO DE JOIN========>"+bancRep.findByContinsert(8080,"192.161.1.12"));
		System.out.println(servRep.findByMaquinaContainsIgnoreCaseOrNomeContainsIgnoreCase("AWS","Servidor 3"));
		////////////////////////////
		servP = new ServidorPrincipal("192.161.1.12", "Servidor 2", "AWS", "i7", 8, "1Tb",1);
		System.out.println("Encontrou com servidor principal ========>"+ servPrServ.salvar(servP));
		//spr.deslogaServidor("192.161.1.13");
		//bancRep.findByAll("192.161.1.12");
		long a = 1;
		System.out.println("Busca por ip =====> " + servRep.buscaByIp(a).getMaquina());
		System.out.println("Busca por ip banco =====> " + bancRep.findByBanco(a).getNome());
		List<Banco> b = new ArrayList();
		b = bancoService.listar("192.161.1.12");
		System.out.println("Busca todos =====> " +b.size());
		
		List<Servidor> servidor = servRep.buscaPorIp("192.161.1.12");
		
		System.out.println("Busca todos =====> " +servidor.size());
		
		for(Banco banc:b) {
			System.out.println("Busca todos =====> " + banc.getNome());
			
		}
		servP = new ServidorPrincipal("192.161.1.150", "Servidor 5", "AWS", "i7", 8, "1Tb",1);
		//System.out.println("Busca todos =====> " +servPrServ.atualizaServidor("192.161.1.11", "Mudou", "AWS", "i7", 64, "2Tb"));
		System.out.println("Servidor Principal insert===>" + servPrServ.salvar(servP));
		//System.out.println("Busca todos =====> " +servPrServ.ligarServidor("192.161.1.13"));
		////////////////////////////
		//System.out.println("Encontrou========>"+servRep.findByQntip("192.161.1.2"));
		//System.out.println("Encontrou========>"+bancRep.findByDev("Oracle"));
		*/
		//System.out.println("Encontrou========>"+bancRep.findByContport("8083"));
		//System.out.println(servRep.findByIp("192.161.1.2")!=null);
		//System.out.println(servidorService.findByNome("192.161.1.1").getIp());
		//System.out.println(servidorService.findById("192.161.1.1").getNome());
		//bancoService.delete(bancRep.findById(2));
		//System.out.println(bancRep.findById(2)==null);
		
		
	}

}
