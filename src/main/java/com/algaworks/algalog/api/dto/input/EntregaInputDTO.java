package com.algaworks.algalog.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaInputDTO {

    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private DestinatarioInputDto destinatario;

    @Valid
    @NotNull
    private BigDecimal taxa;

}
