
CREATE TABLE tb_perfis (
  id int PRIMARY KEY  not null AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  perfil_id INT,
  data_criacao DATETIME,
  criado_por VARCHAR(255),
  data_atualizacao DATETIME,
  atualizado_por VARCHAR(255)
);

CREATE TABLE tb_usuarios (
  id int PRIMARY KEY not null AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  perfil_id int,
  data_criacao DATETIME,
  criado_por VARCHAR(255),
  data_atualizacao DATETIME,
  atualizado_por VARCHAR(255),
  CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES tb_perfis(id)
);