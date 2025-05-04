package br.com.base.projeto_base_hexagonal.application.core.domain;

import br.com.base.projeto_base_hexagonal.application.core.exception.BusinessValidateException;
import br.com.base.projeto_base_hexagonal.application.core.exception.enums.ErroCodeEnum;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dateNascimento;
    private String telefone;
    private String cep;
    private Endereco endereco;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String cpf, LocalDate dateNascimento, String telefone, String cep,
                  Endereco endereco) {
        validarCamposObrigatorios(nome, cpf, dateNascimento, telefone, cep);
        validarIdadeMinima(dateNascimento);

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dateNascimento = dateNascimento;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
    }

    private boolean validarIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDateNascimento() {
        return dateNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDateNascimento(LocalDate dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private void validarCamposObrigatorios(String nome, String cpf, LocalDate dataNascimento, String telefone, String cep) {
        if (isBlank(nome)) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0001.getCode(), ErroCodeEnum.BUS0001.getMessage());
        }
        if (isBlank(telefone)) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0002.getCode(), ErroCodeEnum.BUS0002.getMessage());
        }
        if (isBlank(cpf)) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0003.getCode(), ErroCodeEnum.BUS0003.getMessage());
        }
        if (dataNascimento == null) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0004.getCode(), ErroCodeEnum.BUS0004.getMessage());
        }
        if (isBlank(cep)) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0005.getCode(), ErroCodeEnum.BUS0005.getMessage());
        }
    }

    private void validarIdadeMinima(LocalDate dataNascimento) {
        if (!validarIdade(dataNascimento)) {
            throw new BusinessValidateException(ErroCodeEnum.BUS0006.getCode(), ErroCodeEnum.BUS0006.getMessage());
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
