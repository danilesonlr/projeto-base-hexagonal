package br.com.base.projeto_base_hexagonal.adapter.outbound.service;

import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.AcessorEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private final AcessorEntityRepository acessorEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return acessorEntityRepository.findByLogin(username)
                .orElse(null);
    }
}
