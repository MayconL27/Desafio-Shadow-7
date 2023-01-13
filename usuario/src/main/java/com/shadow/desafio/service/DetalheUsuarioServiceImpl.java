package com.shadow.desafio.service;

import com.shadow.desafio.data.DetalheUsuarioData;
import com.shadow.desafio.entities.Usuarios;
import com.shadow.desafio.repositories.UsuariosRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuariosRepository repository;

    public DetalheUsuarioServiceImpl(UsuariosRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // consulta do usuario
        Optional<Usuarios> usuario = Optional.ofNullable(repository.findByUsername(username));
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [ " + username + " ] não encontrado");
        }
        return new DetalheUsuarioData(usuario);
    }
}
