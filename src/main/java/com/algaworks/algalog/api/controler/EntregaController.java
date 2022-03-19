package com.algaworks.algalog.api.controler;

import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.api.dto.input.EntregaInputDTO;
import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaServicer;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private FinalizacaoEntregaServicer finalizacaoEntregaServicer;
    private EntregaReposity entregaReposity;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaMapper entregaMapper ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar (@Valid @RequestBody EntregaInputDTO entregaInputDTO){
        //convertendo a solicitação em DTO
        EntregaEntity novaEntrega = entregaMapper.dtoParaEntity(entregaInputDTO);//recebendo da tela um dto e convertendo pra entidade pra poder realizar a consulta
        EntregaEntity emtregaSolicitada = solicitacaoEntregaService.solicitraEntrega(novaEntrega);//apos a consulta converte novamente para DTO

        return  entregaMapper.EntityParaDto(emtregaSolicitada);
    }

    @GetMapping
    public List<EntregaDTO> listar(){
        //fazendo a converção de uma lista para uma lista dto * lembrando q tem q criar um metodo na nossa class EntregaMapper
        return entregaMapper.converterListaDTO(entregaReposity.findAll()) ;
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar (@PathVariable Long entregaId){
        return entregaReposity.findById(entregaId)//convertendo de Entidade para DTO
                .map(entrega -> ResponseEntity.ok(entregaMapper.EntityParaDto(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaServicer.finalizar(entregaId);

    }
}
