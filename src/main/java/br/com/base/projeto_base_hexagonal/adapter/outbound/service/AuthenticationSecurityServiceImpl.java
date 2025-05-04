package br.com.base.projeto_base_hexagonal.adapter.outbound.service;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.acesso.AcessoEntity;
import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.acesso.enums.AcessoRoleEnum;
import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.AcessorEntityRepository;
import br.com.base.projeto_base_hexagonal.application.core.exception.BusinessValidateException;
import br.com.base.projeto_base_hexagonal.application.core.exception.enums.ErroCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationSecurityServiceImpl {

    private final AuthenticationManager authenticationManager;
    private final AcessorEntityRepository acessorEntityRepository;
    private final TokenService tokenService;

    public String authentication(String login, String senha){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login, senha);
        var auth = authenticationManager.authenticate(usernamePassword);
        AcessoEntity user = (AcessoEntity) auth.getPrincipal();
        return tokenService.generateToken(user.getUsername(), user.getPassword());
    }

    public void register(String login, String passaword, String role) {
        if(this.acessorEntityRepository.findByLogin(login).isPresent()){
            throw new BusinessValidateException(ErroCodeEnum.AUT0001.getMessage(), ErroCodeEnum.AUT0001.getCode());
        }
        String encryptePassword = new BCryptPasswordEncoder().encode(passaword);
        AcessoEntity acesso = AcessoEntity.builder()
                .login(login)
                .passaword(encryptePassword)
                .role(AcessoRoleEnum.valueOf(role))
                .build();
        acessorEntityRepository.save(acesso);
    }
}
