package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.ClienteEntity;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

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
    public ClienteEntity buscar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(()-> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public void excluir (Long clienteID){
        clienteRepository.deleteById(clienteID);
    }
}
