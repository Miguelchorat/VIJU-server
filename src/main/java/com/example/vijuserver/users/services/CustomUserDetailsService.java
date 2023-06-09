package com.example.vijuserver.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Servicio del usuario que se encarga de cargar el usuario ya sea por el id o su nombre de usuario
 */
@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + "no encontrado"));
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        return userEntityService.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con ID: " + id + " no encontrado"));
    }
}
