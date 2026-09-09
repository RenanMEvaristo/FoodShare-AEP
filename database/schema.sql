CREATE DATABASE IF NOT EXISTS foodshare_db;
USE foodshare_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tipo_usuario ENUM('DOADOR', 'INSTITUICAO') NOT NULL
);

CREATE TABLE IF NOT EXISTS doadores (
    id_doador INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    nome_fantasia VARCHAR(100) NOT NULL,
    CONSTRAINT fk_doador_usuario FOREIGN KEY (id_usuario) 
        REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS instituicoes (
    id_instituicao INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    responsavel VARCHAR(100) NOT NULL,
    capacidade_diaria INT NOT NULL,
    CONSTRAINT fk_instituicao_usuario FOREIGN KEY (id_usuario) 
        REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS doacoes (
    id_doacao INT AUTO_INCREMENT PRIMARY KEY,
    id_doador INT NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    quantidade DECIMAL(10,2) NOT NULL,
    validade DATE NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'DISPONIVEL',
    CONSTRAINT fk_doacao_doador FOREIGN KEY (id_doador) 
        REFERENCES doadores(id_doador) ON DELETE CASCADE
);
