package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.model.StatusEntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaReposity entregaReposity;

    @Transactional
    public EntregaEntity solicitraEntrega(EntregaEntity entrega){
        ClienteEntity cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setEstatusEntrega(StatusEntregaEntity.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return  entregaReposity.save(entrega);
    }
}
