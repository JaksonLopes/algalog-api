package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FinalizacaoEntregaServicer {

    private EntregaReposity entregaReposity;
    private  BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar (Long entregaId){
        EntregaEntity entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaReposity.save(entrega);

    }
}
