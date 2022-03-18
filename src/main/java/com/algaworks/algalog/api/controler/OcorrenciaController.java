package com.algaworks.algalog.api.controler;

import com.algaworks.algalog.api.dto.OcorrenciaDTO;
import com.algaworks.algalog.api.dto.input.OcorrenciaInputDTO;
import com.algaworks.algalog.api.mapper.OcorrenciaMapper;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.model.OcorrenciaEntity;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registra (@PathVariable Long entregaId,@RequestBody @Valid OcorrenciaInputDTO ocorrenciaInputDTO){

       OcorrenciaEntity ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,ocorrenciaInputDTO.getDescricao());
       return ocorrenciaMapper.toDto(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar (@PathVariable Long entregaId){
        EntregaEntity entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toColetionDto(entrega.getOcorrencia()) ;
    }
}
