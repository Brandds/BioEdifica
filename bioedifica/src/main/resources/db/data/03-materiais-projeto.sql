-- ==========================================
-- MATERIAIS DOS PROJETOS COM PROPRIEDADES TÉRMICAS
-- ==========================================

-- Projeto 1
INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 320, 2000.0, 1.15, 1.00, 0.15, 'Argamassa de assentamento', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 321, 2400.0, 1.75, 1.00, 0.20, 'Concreto (bloco e parede)', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 322, 2000.0, 1.15, 1.00, 0.03, 'Reboco', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 323, 1600.0, 0.90, 0.92, 0.10, 'Tijolo cerâmico', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 324, 2000.0, 1.05, 0.92, 0.02, 'Cerâmica', 'COBERTURA');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (1, 325, 7800.0, 0.55, 0.46, 0.005, 'Telha metálica de aço', 'COBERTURA');

-- Projeto 2
INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 326, 2000.0, 1.75, 1.00, 0.12, 'Concreto (laje)', 'COBERTURA');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 327, 1900.0, 0.95, 0.84, 0.008, 'Fibrocimento', 'COBERTURA');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 328, 750.0, 0.35, 0.84, 0.025, 'Gesso', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 329, 600.0, 0.15, 1.34, 0.05, 'Madeira', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 330, 1300.0, 0.20, 0.96, 0.01, 'PVC', 'PAREDE');

INSERT INTO MATERIAL_PROJETO (projeto_id, id_material_externo, densidade, calor_especifico, condutividade_termica, espessura, nome_material, tipo_aplicacao)
VALUES (2, 331, 2000.0, 1.15, 1.00, 0.02, 'Argamassa de reboco', 'PAREDE');

-- Ajustar a sequência do H2 para que o próximo ID seja 13
ALTER TABLE MATERIAL_PROJETO ALTER COLUMN id RESTART WITH 13;
