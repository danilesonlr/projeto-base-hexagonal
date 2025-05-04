CREATE TABLE pessoa (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE ,
    telefone VARCHAR(20) NOT NULL,
    endereco_id BIGINT,
    CONSTRAINT fk_pessoa_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);