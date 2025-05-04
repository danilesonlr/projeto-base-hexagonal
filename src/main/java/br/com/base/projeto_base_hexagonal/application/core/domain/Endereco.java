package br.com.base.projeto_base_hexagonal.application.core.domain;

public class Endereco {

    private String cep;

    private String logradouro;

    private String uf;

    private String localidade;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String cidade) {
        this.localidade = cidade;
    }
}