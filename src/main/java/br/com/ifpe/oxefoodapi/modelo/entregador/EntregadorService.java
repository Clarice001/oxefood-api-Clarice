package br.com.ifpe.oxefoodapi.modelo.entregador;

import java.util.List;

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

   @Transactional
   public void update(Long id, Entregador entregadorAlterado) {

      Entregador entregador = repository.findById(id).get();
      entregador.setNome(entregadorAlterado.getNome());
      entregador.setCpf(entregadorAlterado.getCpf());
      entregador.setRg(entregadorAlterado.getRg());
      entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
      entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
      entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
      entregador.setValorFrete(entregadorAlterado.getValorFrete());
      entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
      entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
      entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
      entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
      entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
      entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
      entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
      entregador.setAtivo(entregadorAlterado.getAtivo());
      super.preencherCamposAuditoria(entregador);
      repository.save(entregador);
  }

  @Transactional
   public void delete(Long id) {

       Entregador entregador = repository.findById(id).get();
       entregador.setHabilitado(Boolean.FALSE);
       super.preencherCamposAuditoria(entregador);

       repository.save(entregador);
   }


public static Entregador save(EntregadorRequest build) {
    return null;
}
public List<Entregador> listarTodos() {
  
    return repository.findAll();
}

public Entregador obterPorID(Long id) {

    return repository.findById(id).get();
}

}