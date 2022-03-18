package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.model.OcorrenciaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService  buscaEntregaService;

    // TODO: 14/03/2022 lembra de pesquisar mais sobre  orElseThrow
    @Transactional
    public OcorrenciaEntity registrar (Long entregaId, String descricao){
        EntregaEntity  entrega = buscaEntregaService.buscar(entregaId);
       return entrega.adicionarOcorrencia(descricao);
    }

}
