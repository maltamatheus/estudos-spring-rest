package br.com.estudos.jpa.repositories;

import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssinaturaRepository extends JpaRepository<AssinanteEntity, UUID> {
}
