package br.com.ifsp.quiapp.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ifsp.quiapp.model.Usuario;

public class MyUserDetails implements UserDetails{
    private Usuario usuarioDoSitema;

    public MyUserDetails(Usuario usuario){
        this.usuarioDoSitema = usuario;
    }
    @Override
    // Ignorar este método
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }

    @Override
    public String getPassword() {
        return this.usuarioDoSitema.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioDoSitema.getUsername();
    }

    @Override
    // Ignorar este método
    public boolean isAccountNonExpired() {
     return true;
    }

    @Override
    // Ignorar este método
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // Ignorar este método
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    // Ignorar este método
    public boolean isEnabled() {
        return true;
    }
}
