package com.example.vijuserver.security.jwt;

import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtros necesarios de la JWT
 */
@Log
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter  extends OncePerRequestFilter {

    private final JwtProvider tokenProvider;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String token = getJwtFromRequest(request);
            if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
                Long userId = tokenProvider.getUserIdFromJWT(token);

                UserEntity user = (UserEntity) userDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, user.getRole(),user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        } catch (Exception ex) {
            log.info("No se ha podido establecer la autenticación de usuario en el contexto de seguridad");
        }

        filterChain.doFilter(request, response);

    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtProvider.TOKEN_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtProvider.TOKEN_PREFIX)) {
            return bearerToken.substring(JwtProvider.TOKEN_PREFIX.length(), bearerToken.length());
        }
        return null;
    }
}
