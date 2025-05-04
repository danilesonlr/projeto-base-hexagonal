package br.com.base.projeto_base_hexagonal.adapter.outbound.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PESSOA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dateNascimento;
    @Column(name = "TELEFONE")
    private String telefone;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID")
    private EnderecoEntity endereco;
}
