package br.com.ifpe.oxefoodapi.modelo.entregador;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.api.entregador.EntregadorRequest;
import br.com.ifpe.oxefoodapi.util.entity.GenericService;

@Service
public class EntregadorService extends GenericService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       super.preencherCamposAuditoria(entregador);
       return repository.save(entregador);
   }

public static Entregador save(EntregadorRequest build) {
    return null;
}

}