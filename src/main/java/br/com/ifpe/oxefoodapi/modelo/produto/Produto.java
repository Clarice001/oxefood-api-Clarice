package br.com.ifpe.oxefoodapi.modelo.produto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


import br.com.ifpe.oxefoodapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel  {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   @Column
   private String codigo;

   @Column
   private String titulo;

   @Column
   private String descricao;

   @Column
   private Integer tempoEntregaMinimo;

   @Column
   private Integer tempoEntregaMaximo;



}

