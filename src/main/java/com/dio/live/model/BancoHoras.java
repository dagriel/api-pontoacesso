package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class BancoHoras /*implements Serializable*/ {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public  class BancoHorasId implements Serializable{

        private long idBancoHoras;
        @ManyToOne
        private Movimentacao movimentacao;
        @ManyToOne
        private Usuario usuario;
        //private long idMovimentacao;
        //private long idUsuario;
    }

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BancoHorasId bancoHorasId;
    //private LocalDateTime dataTrabalhada;
    private LocalDate dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

}
