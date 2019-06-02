package br.gov.sp.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.ServidorRepository;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping	(value="/servidor")
@CrossOrigin
public class ServidorController {
	
	
	
	
	@Autowired
	private ServidorRepository servidorRepo;
	
	@RequestMapping(value = "/getServidorMaqServ")
	@JsonView(View.ServidorHardware.class)
	public ResponseEntity<List<Servidor>> getServidorMaqServ(@RequestParam(value="maquina") String maquina, @RequestParam(value="servidor") String servidor){
		
		List<Servidor> listaServ = servidorRepo.findByMaquinaContainsIgnoreCaseOrNomeContainsIgnoreCase(maquina, servidor);
		
		if (listaServ == null) {
			return new	ResponseEntity<List<Servidor>>(HttpStatus.NOT_FOUND);
			
		}
		return new	ResponseEntity<List<Servidor>>(listaServ, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/getByIp")
	@JsonView(View.ServidorCompleto.class)
	public ResponseEntity<Servidor> get(@RequestParam(value="ip", defaultValue="1") String ip){
		System.out.println(ip);
		Servidor servidor = servidorRepo.findByIp(ip);
		
		System.out.println(servidor.getNome());
		
		if(servidor == null) {
			return new	ResponseEntity<Servidor>(HttpStatus.NOT_FOUND);
		}
		return new	ResponseEntity<Servidor>(servidor, HttpStatus.OK);

	}

}
