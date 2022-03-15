package com.algaworks.algalog.domain.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "entrega")
public class EntregaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @ManyToOne //pode ter muitas entregas para um cliente
    private ClienteEntity cliente;

    @Embedded //Quero extrair os dados do destinatario para outra class porem mapeando para a mesma tabela
    private DestinatarioEntity destinatario;

    private BigDecimal taxa;

    @OneToMany(mappedBy = "entrega",cascade = CascadeType.ALL )
    private List<OcorrenciaEntity> ocorrencia = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusEntregaEntity estatusEntrega;


    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    public OcorrenciaEntity adicionarOcorrencia(String descricao) {
        var ocorrencia = new OcorrenciaEntity();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        this.getOcorrencia().add(ocorrencia);
        return ocorrencia;
    }
}
