package br.com.base.projeto_base_hexagonal.adapter.inboud.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseAuthenticationToken {
    String token;
}
