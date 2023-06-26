package br.com.ifpe.oxefoodapi.api.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapi.modelo.cliente.Cliente;
import br.com.ifpe.oxefoodapi.modelo.cliente.ClienteService;
import br.com.ifpe.oxefoodapi.modelo.cliente.EnderecoCliente;
import br.com.ifpe.oxefoodapi.util.entity.GenericController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends GenericController {

   @Autowired
   private ClienteService clienteService;

   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

       clienteService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }



   @GetMapping
   public List<Cliente> listarTodos() {
  
       return clienteService.listarTodos();
   }

   @GetMapping("/{id}")
   public Cliente obterPorID(@PathVariable Long id) {

       return clienteService.obterPorID(id);
   }

@PostMapping("/endereco/{clienteId}")
   public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId, @RequestBody @Valid EnderecoClienteRequest request) {

       EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
       return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
   }

   @PutMapping("/endereco/{enderecoId}")
   public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoClienteRequest request) {

       EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
       return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
   }
  
   @DeleteMapping("/endereco/{enderecoId}")
   public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

       clienteService.removerEnderecoCliente(enderecoId);
       return ResponseEntity.noContent().build();
   }

}


