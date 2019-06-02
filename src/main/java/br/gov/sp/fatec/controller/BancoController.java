package br.gov.sp.fatec.controller;

import br.gov.sp.fatec.model.Banco;
import br.gov.sp.fatec.model.Servidor;
import br.gov.sp.fatec.repository.BancoRepository;
import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/banco")
@CrossOrigin
public class BancoController {
    
    @Autowired
    private BancoRepository bancoRepo;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @JsonView(View.BancoCompleto.class)
    public ResponseEntity<Banco> save(@RequestBody Banco banco, HttpServletRequest req, HttpServletResponse res) {
        banco = bancoRepo.save(banco);
      
        res.addHeader(
                "Location",
                req.getServerName()+":"+req.getServerPort() +
                req.getContextPath()+"/banco/getById?id="+banco.getId());
        return banco == null ?
        		new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(banco, HttpStatus.OK);
    }

    @RequestMapping(value = "/findByName")
    @JsonView(View.BancoCompleto.class)
    public ResponseEntity<Banco> findByName(@RequestParam(value="name") String name) {
        Banco banco = bancoRepo.findByNome(name);
        return banco == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(banco, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/findByID")
    @JsonView(View.BancoNomeTipo.class)
    public ResponseEntity<Banco> findByID(@RequestParam(value="id") Long id) {
        Optional<Banco> banco = bancoRepo.findById(id);
        return banco.isPresent() ?
        		new ResponseEntity<Banco>(banco.get(), HttpStatus.OK):
                new ResponseEntity<Banco>(HttpStatus.NOT_FOUND);
    }
    
}
