package com.algaworks.algalog.api.controler;

import com.algaworks.algalog.domain.model.EntregaEntity;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaEntity solicitar (@RequestBody EntregaEntity entrega){
        return  solicitacaoEntregaService.solicitraEntrega(entrega);
    }
}
