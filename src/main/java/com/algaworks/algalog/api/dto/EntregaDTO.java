package com.algaworks.algalog.api.dto;

import com.algaworks.algalog.domain.model.StatusEntregaEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDTO {
    private Long id;
    private ClienteDTo nomeCliente;
    private DestinaratioDTO destinatario;
    private BigDecimal taxa;
    private StatusEntregaEntity Status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
