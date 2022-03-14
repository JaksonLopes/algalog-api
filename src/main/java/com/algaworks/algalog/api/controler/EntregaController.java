package com.algaworks.algalog.api.controler;

import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.repository.EntregaReposity;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaReposity entregaReposity;

    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaEntity solicitar (@Valid @RequestBody EntregaEntity entrega){
        return  solicitacaoEntregaService.solicitraEntrega(entrega);
    }

    @GetMapping
    public List<EntregaEntity> listar(){
        return entregaReposity.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaEntity> buscar (@PathVariable Long entregaId){
        return entregaReposity.findById(entregaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
