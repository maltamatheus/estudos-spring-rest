package br.com.estudos.jpa.repositories;

import br.com.estudos.jpa.domains.entities.FamiliarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamiliaresRepository extends JpaRepository<FamiliarEntity, UUID> {
}
