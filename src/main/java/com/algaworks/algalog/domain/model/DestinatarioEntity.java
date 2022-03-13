package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable //tem quer ter essa anotação para a class que usar o @Embedded saber que pode ser incluida
public class DestinatarioEntity {

    @Column(name = "destinatario_nome")
    private String nome;

    @Column(name = "destinatario_logradouro")
    private  String logradouro;

    @Column(name = "destinatario_numero")
    private String numero;

    @Column(name = "destinatario_complemento")
    private  String complemento ;

    @Column(name = "destinatario_bairro")
    private String bairro;


}
