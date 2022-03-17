package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.model.StatusEntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinalizacaoEntregaServicer {

    @Autowired
    private EntregaReposity entregaReposity;

    @Autowired
    private  BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar (Long entregaId){
        EntregaEntity entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaReposity.save(entrega);

    }
}
