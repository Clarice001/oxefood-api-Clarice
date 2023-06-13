package br.com.ifpe.oxefoodapi.api.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapi.modelo.produto.Produto;
import br.com.ifpe.oxefoodapi.modelo.produto.ProdutoService;
import br.com.ifpe.oxefoodapi.util.entity.GenericController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends GenericController {

   @Autowired
   private ProdutoService produtoService;

   public void setProdutoService(ProdutoService produtoService) {
    this.produtoService = produtoService;
}

public ProdutoService getProdutoService() {
    return produtoService;
}

@PutMapping("/{id}")
   public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

       produtoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }


@PostMapping
   public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

       Produto produto = ProdutoService.save(request.build());
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }
   @GetMapping
   public List<Produto> listarTodos() {
  
       return produtoService.listarTodos();
   }

   @GetMapping("/{id}")
   public Produto obterPorID(@PathVariable Long id) {

       return produtoService.obterPorID(id);
   }
}


