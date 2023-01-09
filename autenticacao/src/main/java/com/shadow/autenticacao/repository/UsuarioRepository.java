package com.shadow.autenticacao.repository;

import com.shadow.autenticacao.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    public Optional<UsuarioModel> findByLogin(String login); // Consultar Login.
}
