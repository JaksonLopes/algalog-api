package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.dto.OcorrenciaDTO;
import com.algaworks.algalog.domain.model.OcorrenciaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OcorrenciaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaDTO toDto (OcorrenciaEntity ocorrencia){
        return  modelMapper.map(ocorrencia,OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toColetionDto (List<OcorrenciaEntity> ocorrencia){
        return ocorrencia.stream().map(this::toDto).collect(Collectors.toList());
    }
}
