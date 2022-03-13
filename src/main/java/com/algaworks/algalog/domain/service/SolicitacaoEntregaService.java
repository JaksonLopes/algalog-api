package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.model.StatusEntregaEntity;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SolicitacaoEntregaService {

    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Autowired
    private EntregaReposity entregaReposity;

    @Transactional
    public EntregaEntity solicitraEntrega(EntregaEntity entrega){
        ClienteEntity cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setEstatusEntrega(StatusEntregaEntity.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return  entregaReposity.save(entrega);
    }
}
