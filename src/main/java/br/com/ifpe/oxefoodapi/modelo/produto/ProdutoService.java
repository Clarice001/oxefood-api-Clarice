package br.com.ifpe.oxefoodapi.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.api.produto.ProdutoRequest;
import br.com.ifpe.oxefoodapi.util.entity.GenericService;

@Service
public class ProdutoService extends GenericService {

   @Autowired
   private ProdutoRepository repository;

   @Transactional
   public Produto save(Produto produto) {

       super.preencherCamposAuditoria(produto);
       return repository.save(produto);
   }

   @Transactional
   public void update(Long id, Produto produto2) {

      Produto produto = repository.findById(id).get();
      produto.setCodigo(produto2.getCodigo());
      produto.setTitulo(produto2.getTitulo());
      produto.setDescricao(produto2.getDescricao());
      produto.setValorUnitario(produto2.getValorUnitario());
      produto.setTempoEntregaMinimo(produto2.getTempoEntregaMinimo());
      produto.setTempoEntregaMaximo(produto2.getTempoEntregaMaximo());
	    
      super.preencherCamposAuditoria(produto);
      repository.save(produto);
  }

  @Transactional
   public void delete(Long id) {

       Produto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);
       super.preencherCamposAuditoria(produto);

       repository.save(produto);
   }


public static Produto save(ProdutoRequest build) {
    return null;
}

public List<Produto> listarTodos() {
  
    return repository.findAll();
}

public Produto obterPorID(Long id) {

    return repository.findById(id).get();
}

}
