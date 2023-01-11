package com.shadow.autenticacao.service;

import com.shadow.autenticacao.data.DetalheUsuarioData;
import com.shadow.autenticacao.model.UsuarioModel;
import com.shadow.autenticacao.repository.UsuarioRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findByLogin(username);
        if (usuarioModel.isEmpty()) {
            throw new UsernameNotFoundException("Usuario [ " + username + " ] não encontrado");
        }
        return new DetalheUsuarioData(usuarioModel);
    }
}
