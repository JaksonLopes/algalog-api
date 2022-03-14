package com.algaworks.algalog.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DestinatarioInputDto {


    @NotBlank
    private String nome;

    @NotBlank
    private  String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private  String complemento ;

    @NotBlank
    private String bairro;
}
