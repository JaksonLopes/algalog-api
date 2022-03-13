package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity salvar(ClienteEntity cliente){
        boolean emailEmuso  = clienteRepository.findByEmail(cliente.getEmail())
                .stream().anyMatch(clienteExiste -> !clienteExiste.equals(cliente));

        if (emailEmuso){
            throw new NegocioException("Email ja cadastrado ");
        }
        return  clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir (Long clienteID){
        clienteRepository.deleteById(clienteID);
    }
}
