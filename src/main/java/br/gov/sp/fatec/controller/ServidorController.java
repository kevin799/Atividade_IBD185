package br.gov.sp.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.ServidorRepository;

@RestController
@RequestMapping	(value="/servidor")
public class ServidorController {
	
	@Autowired
	private ServidorRepository servidorRepo;
	
	@RequestMapping(value ="/getByIp")
	//@JsonView(View.All.Class)
	public ResponseEntity<Servidor> get(@RequestParam(value="ip", defaultValue="1") String ip){
		Servidor servidor = servidorRepo.findByIp(ip);
		
		if(servidor == null) {
			return new	ResponseEntity<Servidor>(HttpStatus.NOT_FOUND);
		}
		return new	ResponseEntity<Servidor>(servidor, HttpStatus.OK);

	}

}
