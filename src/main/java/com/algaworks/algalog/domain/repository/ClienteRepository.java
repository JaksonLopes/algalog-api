package com.algaworks.algalog.domain.repository;

import com.algaworks.algalog.domain.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository  extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity>findByNome(String nome);
    List<ClienteEntity>findByNomeContaining(String nome);
    Optional<ClienteEntity> findByEmail(String email);
}
