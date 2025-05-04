package br.com.base.projeto_base_hexagonal.config.security;


import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.AcessorEntityRepository;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.AuthenticationSecurityServiceImpl;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final SecurtyFilter securityFilter;

    /**
     * ESSE BEAN E UTILIZADO PARA CONFIGURAR O SPRING SECURITY E RETICAR O A POLITICA DE STATEFULL (LOGIN E SENHA)
     * PARA STATELESS (VIA TOKEN)
     *
     * E BLOQUEANDO REQUISIÇÕES SEM A AUTENTICAÇÃO COM O AUTORIZE HTTP REQUESTS
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain secuirFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf( csrf -> csrf.disable())
                // ALTERANDO DE STATFULL PARA STATELESS
                .sessionManagement(session
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //ADICIONANDO AS PERMISSÕES E RESTRIÇÕES
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                //LIBERANDO ENDPOINT DE LOGIN
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                //LIBERAR O SWAGGER
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/swagger-resources/**").permitAll()
                                .requestMatchers("/webjars/**").permitAll()
                                //LIBERAR O H2 CONSOLE
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/js/**").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                //REGRA PARA SOMENTE USUARIO LOGADO COMO ADMIN PODE UTILIZAR O SERVIÇO DE SALVAR
                                .requestMatchers(HttpMethod.POST, "/v1/salvar").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authentication) throws Exception {
        return authentication.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
