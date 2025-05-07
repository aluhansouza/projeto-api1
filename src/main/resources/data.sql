


INSERT INTO tb_perfis (nome) VALUES ('ADMIN'), ('USUARIO');



INSERT INTO tb_usuarios (nome, email, senha, perfil_id)
VALUES 
  ('João da Silva', 'joao@email.com', '123456', 1),
  ('Maria Oliveira', 'maria@email.com', 'abcdef', 2);