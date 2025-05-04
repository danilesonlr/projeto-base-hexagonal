package br.com.base.projeto_base_hexagonal.application.port.in;

import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.AuthenticationDTO;
import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

     ResponseEntity login(AuthenticationDTO authenticationDTO);
     ResponseEntity register(RegisterDTO registerDTO);
}
