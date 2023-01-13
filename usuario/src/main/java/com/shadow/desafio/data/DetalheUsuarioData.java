package com.shadow.desafio.data;

import com.shadow.desafio.entities.Usuarios;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData  implements UserDetails {

    private final Optional<Usuarios> usuariosOptional;

    public DetalheUsuarioData(Optional<Usuarios> usuariosOptional) {
        this.usuariosOptional = usuariosOptional;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(); // Passando Arraylist vazio.
    }

    @Override
    public String getPassword() {
        return usuariosOptional.orElse(new Usuarios()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuariosOptional.orElse(new Usuarios()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
