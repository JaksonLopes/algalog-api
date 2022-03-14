package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.api.dto.input.EntregaInputDTO;
import com.algaworks.algalog.domain.model.EntregaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaDTO EntityParaDto(EntregaEntity entrega){
        return modelMapper.map(entrega,EntregaDTO.class);
    }

    public List<EntregaDTO> converterListaDTO(List<EntregaEntity> entrega){
        return  entrega.stream()
                .map(this::EntityParaDto)
                .collect(Collectors.toList());
    }
    //recebendo do front um um Dto e convertendo para entity para poder percistir
    public  EntregaEntity dtoParaEntity(EntregaInputDTO entregaInputDTO){
        return modelMapper.map(entregaInputDTO ,EntregaEntity.class);

    }
}
