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
   public void update(Long id, ProdutoRequest produtoRequest) {

      Produto produto = repository.findById(id).get();
      produto.setCodigo(produtoRequest.getCodigo());
      produto.setTitulo(produtoRequest.getTitulo());
      produto.setDescricao(produtoRequest.getDescricao());
      produto.setValorUnitario(produtoRequest.getValorUnitario());
      produto.setTempoEntregaMinimo(produtoRequest.getTempoEntregaMinimo());
      produto.setTempoEntregaMaximo(produtoRequest.getTempoEntregaMaximo());
	    
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
