DROP TABLE alertas;
DROP TABLE entregas;
DROP TABLE motoristas;
DROP TABLE veiculos;
DROP TABLE usuarios;

CREATE TABLE usuarios (
    id SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_acesso ENUM('administrador', 'editor', 'leitor') NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id)
);

CREATE TABLE veiculos (
  id SERIAL NOT NULL,
  placa VARCHAR(10) NOT NULL UNIQUE,
  modelo VARCHAR(50) NOT NULL,
  tipo VARCHAR(30),
  capacidade DECIMAL(65,2),
  status ENUM('ativo', 'manutencao') NOT NULL,
  -- doc_vencimento DATE,
  PRIMARY KEY (id)
);

CREATE TABLE motoristas (
  id SERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  cnh VARCHAR(11) NOT NULL UNIQUE,
  categoria_cnh ENUM ('A', 'B', 'AB', 'C', 'D', 'E') NOT NULL,
  validade_cnh DATE NOT NULL,
  treinamento_ok BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id)
);

CREATE TABLE entregas (
  id SERIAL NOT NULL,
  destino VARCHAR(100) NOT NULL,
  carga_perigosa BOOLEAN DEFAULT FALSE,
  status ENUM ('pendente', 'em_transito', 'concluida') DEFAULT 'pendente',
  data_entrega DATE NOT NULL,
  id_motoristas BIGINT UNSIGNED,
  id_veiculos BIGINT UNSIGNED,
  PRIMARY KEY (id),
  CONSTRAINT fk_entregas_motoristas
    FOREIGN KEY (id_motoristas)
    REFERENCES motoristas (id),
  CONSTRAINT fk_entregas_veiculos
    FOREIGN KEY (id_veiculos)
    REFERENCES veiculos (id)
);

CREATE TABLE alertas (
  id SERIAL NOT NULL,
  tipo_alerta VARCHAR(100) NOT NULL,
  descricao TEXT NOT NULL,
  data_alerta TIMESTAMP NOT NULL,
  id_motoristas BIGINT UNSIGNED,
  id_veiculos BIGINT UNSIGNED,
  PRIMARY KEY (id),
  CONSTRAINT fk_alertas_motoristas
    FOREIGN KEY (id_motoristas)
    REFERENCES motoristas (id),
  CONSTRAINT fk_alertas_veiculos
    FOREIGN KEY (id_veiculos)
    REFERENCES veiculos (id)
);

insert into veiculos values (default, '1234A567', 'Dodge Ram', 'Picape', 100.5, 2);
insert into veiculos values (default, '9876B543', 'Palio', 'Popular', 25.25, 1);

insert into usuarios values (default, 'Admininastro', 'admin', '1234', 1, default);
insert into usuarios values (default, 'Comum', 'comum', '1234', 2, default);
insert into usuarios values (default, 'Leitor', 'ler', '1234', 3, default);

insert into motoristas values (default, 'João', '11111111111', '11111111', 'C', '2027-11-10', default);
insert into motoristas values (default, 'Olivia', '12312345699', '22222222' , 'D', '2028-04-21', default);

insert into entregas values (default, 'Curitiba', false, default, '2025-11-10', 1, 2);
insert into entregas values (default, 'Florianópolis', true, 'concluida', '2025-04-21', 2, 1);