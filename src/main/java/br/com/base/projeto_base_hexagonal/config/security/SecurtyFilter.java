package br.com.base.projeto_base_hexagonal.config.security;


import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.AcessorEntityRepository;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurtyFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final AcessorEntityRepository acessorEntityRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    jakarta.servlet.FilterChain filterChain) throws ServletException, IOException {

        var token = this.recorverToken(request);
        if(token != null) {
            var login = tokenService.validateToken(token);
            UserDetails userDetails = acessorEntityRepository.findByLogin(login).orElse(null);
            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recorverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
