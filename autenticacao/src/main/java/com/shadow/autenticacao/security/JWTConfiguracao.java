package com.shadow.autenticacao.security;

import com.shadow.autenticacao.service.DetalheUsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {
    private final DetalheUsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    public JWTConfiguracao(DetalheUsuarioServiceImpl usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override // configurações dos serviços.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll() // Ele não via pedir senha, permitir tudo.
                .anyRequest().authenticated() //
                .and()
                .addFilter(new JWTAutenticarFilter(authenticationManager())) // filtro para autenticação.
                .addFilter(new JWTValidarFilter(authenticationManager())) // filtro para validar.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean // @Bean se tornar um componente da aplicação
    CorsConfigurationSource corsConfigurationSource() { // permite aplicação possa receber requisções de outros dominio.
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
