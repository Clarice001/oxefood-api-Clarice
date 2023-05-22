package br.com.ifpe.oxefoodapi.api.cupomDesconto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapi.modelo.cupomDesconto.CupomDesconto;
import br.com.ifpe.oxefoodapi.modelo.cupomDesconto.CupomDescontoService;
import br.com.ifpe.oxefoodapi.util.entity.GenericController;

@RestController
@RequestMapping("/api/cupomDesconto")
public class CupomDescontoController extends GenericController {

   @Autowired
   private CupomDescontoService CupomDescontoService;

   public CupomDescontoService getCupomDescontoService() {
    return CupomDescontoService;
}

public void setCupomDescontoService(CupomDescontoService cupomDescontoService) {
    CupomDescontoService = cupomDescontoService;
}

@PostMapping
   public ResponseEntity<CupomDesconto> save(@RequestBody @Valid CupomDescontorRequest request) {

       CupomDesconto cupomDesconto = cupomDescontoService.save(request.build());
       return new ResponseEntity<CupomDesconto>(cupomDesconto, HttpStatus.CREATED);
   }
}