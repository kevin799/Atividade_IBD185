package br.gov.sp.fatec.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.sp.fatec.model.ServidorPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import br.gov.sp.fatec.repository.ServidorPrincipalRepository;
import br.gov.sp.fatec.service.ServidorPrincipalService;
import br.gov.sp.fatec.view.View;


@RestController
@RequestMapping(value = "/servidorPrincipal")
public class ServidorPrincipalController {
	
	@Autowired
	private ServidorPrincipalService serR;
	@Autowired
	private ServidorPrincipalRepository serRepos;
	
	
	@CrossOrigin
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@JsonView(View.ServidorPrincipal.class)
	public ResponseEntity<br.gov.sp.fatec.model.ServidorPrincipal> save(@RequestBody br.gov.sp.fatec.model.ServidorPrincipal servidor,HttpServletRequest req, HttpServletResponse res){
		servidor = serR.salvar(servidor);
		
		res.addHeader("Location",
						req.getServerName()+":"+req.getServerPort()+
						req.getContextPath()+"/servidorPrincipal/getById?id="+servidor.getId());
		return servidor == null?
				new ResponseEntity<>(HttpStatus.NOT_FOUND):
				new ResponseEntity<>(servidor,HttpStatus.OK);
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getAll")
	//@JsonView(View.ServidorPrincipal.class)
	public ResponseEntity<List<ServidorPrincipal>>findAll(){
		List<ServidorPrincipal> servidor = (List<ServidorPrincipal>) serRepos.findAll();
		
		return new ResponseEntity<List<ServidorPrincipal>>(servidor, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getByIp")
	public ResponseEntity<List<ServidorPrincipal>>findIp(@RequestParam(value="ip",defaultValue="1") String ip){
		List<ServidorPrincipal> servidor = (List<ServidorPrincipal>) serRepos.findByIp(ip);
		if(servidor == null) {
			return new ResponseEntity<List<ServidorPrincipal>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ServidorPrincipal>>(servidor,HttpStatus.OK);
		
	}
	
	
	/*@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	@JsonView(View.ServidorP.class)
	public ResponseEntity<Collection<br.gov.sp.fatec.model.ServidorPrincipal>> getAll(){
		return new ResponseEntity<Collection<br.gov.sp.fatec.model.ServidorPrincipal>>(serR.lista(), HttpStatus.OK);
	}*/
	
}
