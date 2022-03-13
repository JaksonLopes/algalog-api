package com.algaworks.algalog.api.controler;

import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteEntity> listar(){
        return clienteRepository.findAll();
    }
    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteEntity> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId) // Arrow Functions .map ver ser a requisição trouxe dados se não chama ,orElse
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClienteEntity adcionar(@RequestBody @Valid ClienteEntity cliente){
       //return clienteRepository.save(cliente);
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteEntity> atualizar(@Valid @PathVariable Long clienteId, @RequestBody ClienteEntity cliente){
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        return ResponseEntity.ok(catalogoClienteService.salvar(cliente));
    }

    @DeleteMapping("{clienteId}")
    public ResponseEntity<Void>deletar(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
          catalogoClienteService.excluir(clienteId);
        return  ResponseEntity.noContent().build();

    }

}
