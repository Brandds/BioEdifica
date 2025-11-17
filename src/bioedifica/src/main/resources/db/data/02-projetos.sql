-- ==========================================
-- DADOS INICIAIS: PROJETOS
-- ==========================================
INSERT INTO PROJETO (nome, descricao, usuario_id, ativo) VALUES ('Projeto Exemplo', 'Descrição do projeto exemplo', 1, true);
INSERT INTO PROJETO (nome, descricao, usuario_id, ativo) VALUES ('Projeto Residencial', 'Projeto de uma residência sustentável', 2, true);
INSERT INTO PROJETO (nome, descricao, usuario_id, ativo) VALUES ('Projeto Comercial', 'Projeto de um edifício comercial', 1, true);

-- Ajustar a sequência do H2 para que o próximo ID seja 4
ALTER TABLE PROJETO ALTER COLUMN id RESTART WITH 4;

