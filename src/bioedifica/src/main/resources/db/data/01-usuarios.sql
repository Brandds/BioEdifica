-- ==========================================
-- DADOS INICIAIS: USUÁRIOS DO SISTEMA
-- ==========================================
INSERT INTO USUARIO (nome, email, senha, perfil) VALUES ('Admin', 'admin@bioedifica.com', '123456', 'ADMIN');
INSERT INTO USUARIO (nome, email, senha, perfil) VALUES ('Arquiteto', 'ana@bioedifica.com', 'senhaana', 'ARQUITETO');
INSERT INTO USUARIO (nome, email, senha, perfil) VALUES ('Engenheiro', 'joao@bioedifica.com', 'senha123', 'ENGENHEIRO');

-- Ajustar a sequência do H2 para que o próximo ID seja 4
ALTER TABLE USUARIO ALTER COLUMN id RESTART WITH 4;

