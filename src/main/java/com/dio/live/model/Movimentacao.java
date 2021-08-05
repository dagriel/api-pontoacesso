package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Data
@Builder
@Entity
public class Movimentacao /*implements Serializable*/{

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @EqualsAndHashCode
        //@Data
        @Embeddable
        public  class  MovimentacaoId implements Serializable{
            private long idMovimento;
            @ManyToOne
            private Usuario usuario;
            //private long idUsuario;
        }

        @EmbeddedId
        private MovimentacaoId movimentacaoId;
        private LocalDateTime dataEntrada;
        private LocalDateTime dataSaida;
        private BigDecimal periodo;
        @ManyToOne
        private Ocorrencia ocorrencia;
        @ManyToOne
        private Calendario calendario;

}
