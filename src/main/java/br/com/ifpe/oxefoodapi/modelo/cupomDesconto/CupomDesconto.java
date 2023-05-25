package br.com.ifpe.oxefoodapi.modelo.cupomDesconto;

import java.time.LocalDate;

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
@Table(name = "CupomDesconto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CupomDesconto extends EntidadeAuditavel  {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   @Column
   private String Codigo;

   @Column
   private Double PercentualDesconto;

   @Column
   private Double ValorDesconto;

   @Column
   private Double ValorMinimoPermitidoParaOPedido;

   @Column
   private int QuantidadeMaximaDeUsoPorCliente;

   @Column
   private LocalDate InicioDaVigencia;

   @Column
   private LocalDate FimDaVigencia;



}

