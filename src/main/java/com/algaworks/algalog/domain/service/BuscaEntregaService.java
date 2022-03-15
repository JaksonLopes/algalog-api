package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

    @Autowired
    private EntregaReposity entregaReposity;

    public EntregaEntity buscar (Long entregaId){
       return entregaReposity.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
