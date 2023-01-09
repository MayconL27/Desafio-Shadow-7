package com.shadow.autenticacao.jwt.data;

import com.shadow.autenticacao.model.UsuarioModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
@Data
public class DetalheUsuarioData implements UserDetails {

    private final Optional<UsuarioModel> usuarioModel;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Pemrissões do usuario.
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuarioModel.orElse(new UsuarioModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuarioModel.orElse(new UsuarioModel()).getLogin();
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
