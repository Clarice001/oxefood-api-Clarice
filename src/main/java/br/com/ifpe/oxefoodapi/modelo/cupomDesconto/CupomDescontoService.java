package br.com.ifpe.oxefoodapi.modelo.cupomDesconto;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.util.entity.GenericService;

@Service
public class CupomDescontoService extends GenericService {

   @Autowired
   private CupomDescontoRepository repository;

   @Transactional
   public CupomDesconto save(CupomDesconto cupomDesconto) {

       super.preencherCamposAuditoria(cupomDesconto);
       return repository.save(cupomDesconto);
   }

}
