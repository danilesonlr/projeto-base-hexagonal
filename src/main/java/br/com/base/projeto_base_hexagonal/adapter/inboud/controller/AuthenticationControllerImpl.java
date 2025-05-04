package br.com.base.projeto_base_hexagonal.adapter.inboud.controller;

import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.AuthenticationDTO;
import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.RegisterDTO;
import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.ResponseAuthenticationToken;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.AuthenticationSecurityServiceImpl;
import br.com.base.projeto_base_hexagonal.application.port.in.AuthenticationController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationSecurityServiceImpl authenticationSecurityService;

    @PostMapping("/login")
    @Override
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        String token = authenticationSecurityService.authentication(authenticationDTO.getLogin(),
                authenticationDTO.getSenha());
        return ResponseEntity.ok(ResponseAuthenticationToken.builder()
                .token(token)
                .build());
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        authenticationSecurityService.register(registerDTO.getLogin(), registerDTO.getSenha(),
                registerDTO.getRole().name());
        return ResponseEntity.ok().build();
    }
}
