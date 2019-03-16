package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.sp.fatec.model.Banco;
import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.BancoRepository;
import br.gov.sp.fatec.repository.ServidorRepository;
import br.gov.sp.fatec.service.BancoService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	
	@Autowired
	private ServidorRepository servRep;
	private Servidor serv;
	@Autowired
	private BancoRepository bancRep;
	@Autowired
	private BancoService bancoService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		/////////////////////////////
		//System.out.println("Encontrou========>");
		//System.out.println(servRep.findByQntip("192.161.1.2"));
		serv = new Servidor("192.161.1.10", "Servidor 2", "AWS", "i7", 8, "1Tb");
		//servidorService.incluiServidor(serv);
		//System.out.println("Encontrou========>"+ bancoService.incluiBanco("SQL Server", "Developer", "2017", "8082", "Microsoft","192.161.1.1"));
		Banco ban = new Banco("Oracle", "Developer", "2017", "8085", "Oracle",serv);
		//ban.setServidor(new ArrayList<Servidor>());
		//ban.getServidor().add(serv);
		System.out.println("Encontrou========>"+ bancoService.incluiBancoClasse(ban));
		////////////////////////////
		//System.out.println("Encontrou========>"+servRep.findByQntip("192.161.1.2"));
		//System.out.println("Encontrou========>"+bancRep.findByDev("Oracle"));
		
		//System.out.println("Encontrou========>"+bancRep.findByContport("8083"));
		//System.out.println(servRep.findByIp("192.161.1.2")!=null);
		//System.out.println(servidorService.findByNome("192.161.1.1").getIp());
		//System.out.println(servidorService.findById("192.161.1.1").getNome());
		
	}

}
