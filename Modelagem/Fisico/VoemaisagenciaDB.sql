CREATE DATABASE voemaisagenciaDB;
USE voemaisagenciaDB;

CREATE TABLE permissoes(
id_permissoes INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
tipo_permissoes VARCHAR(30)
);

CREATE TABLE cliente(
id_cliente INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nome VARCHAR(100) NOT NULL,
sobrenome VARCHAR(100) NOT NULL,
endereco VARCHAR(150) NOT NULL,
telefone VARCHAR(20) NOT NULL,
cpf CHAR(11) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(20) NOT NULL
);

CREATE TABLE viagem(
id_viagem INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
destinos varchar(100),
data_ida DATE NOT NULL,
data_volta DATE NOT NULL
);

CREATE TABLE pacote(
id_pacote INT PRIMARY KEY NOT NULL,
cliente_id INT NOT NULL,
viagem_id INT NOT NULL,
FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente),
FOREIGN KEY (viagem_id) REFERENCES viagem(id_viagem)
);

CREATE TABLE passagem(
id_passagem INT PRIMARY KEY NOT NULL,
pacote_id INT NOT NULL,
dataDacompra timestamp,
FOREIGN KEY (pacote_id) REFERENCES pacote(id_pacote)
);






