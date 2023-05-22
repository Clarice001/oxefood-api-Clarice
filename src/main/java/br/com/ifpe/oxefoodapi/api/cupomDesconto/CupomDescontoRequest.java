package br.com.ifpe.oxefoodapi.api.cupomDesconto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapi.modelo.cupomDesconto.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CupomDescontoRequest {

   private String codigo;

   private Double PercentualDesconto;

   private String ValorDesconto;

   private String ValorMinimoPermitidoParaOPedido;

   private String QuantidadeMaximaDeUsoPorCliente;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate InicioDaVigencia;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate FimDaVigencia;

   public CupomDesconto build() {

       return CupomDesconto.builder()
               .codigo(codigo)
               .PercentualDesconto(PercentualDesconto)
               .ValorDesconto(ValorDesconto)
               .ValorMinimoPermitidoParaOPedido(ValorMinimoPermitidoParaOPedido)
               .QuantidadeMaximaDeUsoPorCliente(QuantidadeMaximaDeUsoPorCliente)
               .InicioDaVigencia(InicioDaVigencia)
               .FimDaVigencia(FimDaVigencia)
               .build();
   }
}
