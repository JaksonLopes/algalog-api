package com.algaworks.algalog.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaInputDTO {

    @NotBlank
    private String descricao;
}
