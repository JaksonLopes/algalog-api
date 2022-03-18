package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.dto.ClienteDTo;
import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.model.EntregaEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Clientemapper {

    private ModelMapper modelMapper;

    public ClienteDTo EntityParaDto(ClienteEntity cliente){

        return modelMapper.map(cliente,ClienteDTo.class);
    }

    public List <ClienteDTo> converteListaDto(List<ClienteEntity> cliente){
        return cliente.stream().map(this::EntityParaDto)
                .collect(Collectors.toList());
    }

}
