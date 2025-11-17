-- 1) Estado (id explícito)
INSERT INTO estado (id, uf, nome) values (1, 'ES', 'Espírito Santo');

-- 2) Cidades (ids explícitos, estado_id = 1)
INSERT INTO cidade (id, nome, estado_id, tipo) values (1, 'Afonso Cláudio', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (2, 'Água Doce do Norte', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (3, 'Águia Branca', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (4, 'Alegre', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (5, 'Alfredo Chaves', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (6, 'Alto Rio Novo', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (7, 'Anchieta', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (8, 'Apiacá', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (9, 'Aracruz', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (10, 'Atilio Vivacqua', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (11, 'Baixo Guandu', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (12, 'Barra de São Francisco', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (13, 'Boa Esperança', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (14, 'Bom Jesus do Norte', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (15, 'Brejetuba', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (16, 'Cachoeiro de Itapemirim', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (17, 'Cariacica', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (18, 'Castelo', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (19, 'Colatina', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (20, 'Conceição da Barra', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (21, 'Conceição do Castelo', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (22, 'Divino de São Lourenço', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (23, 'Domingos Martins', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (24, 'Dores do Rio Preto', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (25, 'Ecoporanga', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (26, 'Fundão', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (27, 'Governador Lindenberg', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (28, 'Guaçuí', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (29, 'Guarapari', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (30, 'Ibatiba', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (31, 'Ibiraçu', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (32, 'Ibitirama', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (33, 'Iconha', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (34, 'Irupi', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (35, 'Itaguaçu', 1, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (36, 'Itapemirim', 1, 'OFICIAL');

-- 3) Zoneamento (inserts referenciando city ids explicitamente)

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(1, '2M', -20.08, -41.13, 379, 20.7, 78, 4753, 3.6, 11.4);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(2, '3B', -18.55, -40.99, 205, 22.3, 71, 4767, 3.2, 10.9);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(3, '4A', -18.98, -40.74, 144, 23.5, 73, 4799, 3.1, 10.9);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(4, '4A', -20.76, -41.54, 265, 23.6, 73, 4831, 1.4, 11.2);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(5, '4A', -20.64, -40.75, 118, 23.5, 75, 5099, 2.0, 8.7);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) values(6, '3B', -19.06, -41.02, 528, 22.8, 69, 4816, 4.0, 11.5);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(7, '4A', -20.80, -40.64, 21, 23.8, 76, 5018, 4.1, 9.4);

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(8, '4A', -21.15, -41.57, 96, 22.9, 76, 4909, 3.4, 10.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(9, '4A', -19.82, -40.28, 66, 23.5, 79, 4835, 3.4, 8.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(10, '3A', -20.91, -41.20, 75, 22.4, 76, 4947, 3.9, 10.9) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(11, '4A', -19.52, -41.01, 73, 23.9, 77, 4961, 3.4, 11.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(12, '4B', -18.75, -40.90, 198, 23.0, 70, 4846, 3.4, 10.9) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(13, '4A', -18.54, -40.30, 138, 24.1, 77, 4820, 3.3, 10.2) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(14, '3A', -21.12, -41.67, 188, 22.7, 76, 4870, 3.1, 10.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(15, '2M', -20.14, -41.30, 882, 20.2, 76, 4625, 3.8, 11.4) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(16, '3A', -20.85, -41.12, 28, 22.8, 76, 5013, 3.5, 10.9) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(17, '4A', -20.26, -40.42, 43, 23.2, 77, 4783, 3.5, 7.6) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(18, '3A', -20.60, -41.20, 108, 22.2, 76, 4896, 3.2, 10.9) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(19, '4A', -19.55, -40.63, 154, 23.8, 79, 4849, 3.8, 10.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(20, '4A', -18.59, -39.74, 4, 24.3, 77, 5130, 3.8, 9.5) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(21, '2M', -20.36, -41.24, 628, 20.1, 75, 4759, 3.7, 11.4) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(22, '2M', -20.62, -41.69, 870, 19.6, 73, 4786, 3.1, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(23, '2M', -20.36, -40.66, 529, 20.2, 76, 4673, 3.7, 10.1) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(24, '2M', -20.69, -41.84, 839, 20.0, 74, 4800, 3.2, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(25, '4A', -18.37, -40.84, 226, 23.3, 73, 4784, 3.3, 10.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(26, '3A', -19.94, -40.41, 57, 22.7, 82, 4604, 3.4, 8.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(27, '4A', -19.19, -40.45, 185, 23.3, 77, 4761, 3.6, 9.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(28, '2M', -20.77, -41.67, 591, 20.3, 74, 4800, 3.1, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(29, '4A', -20.68, -40.51, 13, 23.3, 76, 4954, 4.0, 9.4) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(30, '2M', -20.23, -41.51, 746, 20.2, 75, 4707, 3.7, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(31, '3A', -19.84, -40.37, 48, 22.6, 81, 4746, 3.4, 8.8) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(32, '1M', -20.55, -41.67, 888, 18.5, 73, 4742, 3.3, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(33, '3A', -20.79, -40.81, 14, 22.9, 76, 4676, 4.0, 9.4) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(34, '2M', -20.35, -41.64, 806, 19.9, 75, 4715, 3.4, 12.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(35, '3A', -19.80, -40.86, 141, 22.5, 80, 4820, 3.7, 10.3) ;

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica)VALUES(36, '4A', -21.01, -40.83, 5, 23.8, 76, 5021, 4.6, 9.1) ;

-- ==============================
-- Minas Gerais (MG) - adicionados
-- estado id = 2
-- ==============================
INSERT INTO estado (id, uf, nome) values (2, 'MG', 'Minas Gerais');

-- Cidades (ids explícitos, estado_id = 2)
INSERT INTO cidade (id, nome, estado_id, tipo) values (37, 'Abadia dos Dourados', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (38, 'Abaeté', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (39, 'Abre Campo', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (40, 'Acaiaca', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (41, 'Açucena', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (42, 'Água Boa', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (43, 'Água Comprida', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (44, 'Aguanil', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (45, 'Águas Formosas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (46, 'Águas Vermelhas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (47, 'Aimorés', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (48, 'Aiuruoca', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (49, 'Alagoa', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (50, 'Albertina', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (51, 'Além Paraíba', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (52, 'Alfenas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (53, 'Alfredo Vasconcelos', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (54, 'Almenara', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (55, 'Alpercata', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (56, 'Alpinópolis', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (57, 'Alterosa', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (58, 'Alto Caparaó', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (59, 'Alto Jequitibá', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (60, 'Alto Rio Doce', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (61, 'Alvarenga', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (62, 'Alvinópolis', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (63, 'Alvorada de Minas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (64, 'Amparo do Serra', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (65, 'Andradas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (66, 'Andrelândia', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (67, 'Angelândia', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (68, 'Antônio Carlos', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (69, 'Antônio Dias', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (70, 'Antônio Prado de Minas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (71, 'Araçaí', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (72, 'Aracitaba', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (73, 'Araçuaí', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (74, 'Araguari', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (75, 'Arantina', 2, 'OFICIAL');

-- Zoneamento (valores normalizados)
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (37, '3B', -18.48, -47.39, 783, 22.6, 68, 5339, 3.8, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (38, '3B', -19.16, -45.44, 637, 22.9, 65, 5344, 3.0, 13.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (39, '3A', -20.30, -42.47, 631, 21.2, 78, 4826, 4.1, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (40, '3A', -20.36, -43.14, 491, 21.3, 77, 4753, 3.2, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (41, '3B', -19.07, -42.54, 495, 22.3, 70, 4728, 2.4, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (42, '3B', -17.99, -42.38, 503, 22.7, 68, 4985, 2.9, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (43, '4B', -20.06, -48.11, 534, 24.5, 64, 5150, 4.1, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (44, '2M', -20.94, -45.39, 817, 20.8, 70, 4974, 3.4, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (45, '4B', -17.08, -40.94, 265, 23.9, 68, 5011, 3.0, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (46, '3B', -15.74, -41.46, 729, 21.4, 72, 5152, 2.2, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (47, '4A', -19.50, -41.07, 177, 24.2, 77, 4961, 3.4, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (48, '1M', -21.97, -44.60, 992, 17.7, 77, 4760, 3.1, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (49, '1M', -22.17, -44.64, 1145, 16.8, 79, 4580, 3.3, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (50, '2M', -22.20, -46.61, 993, 20.0, 71, 4848, 3.7, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (51, '3A', -21.88, -42.72, 227, 21.9, 81, 4701, 2.5, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (52, '3B', -21.43, -45.95, 887, 21.2, 72, 4935, 2.8, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (53, '1M', -21.15, -43.77, 1062, 18.5, 75, 4694, 3.6, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (54, '5A', -16.18, -40.69, 190, 25.3, 69, 4834, 1.5, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (55, '4B', -18.97, -41.97, 191, 24.5, 69, 4916, 3.3, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (56, '2M', -20.86, -46.39, 880, 20.6, 69, 5028, 3.1, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (57, '3B', -21.25, -46.14, 800, 21.0, 70, 4898, 2.9, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (58, '1M', -20.43, -41.87, 1072, 18.5, 78, 4669, 3.5, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (59, '2M', -20.42, -41.97, 642, 19.5, 78, 4668, 3.6, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (60, '2M', -21.03, -43.41, 775, 20.1, 75, 4667, 3.8, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (61, '3B', -19.42, -41.73, 376, 22.3, 72, 4677, 3.1, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (62, '3A', -20.11, -43.05, 644, 21.0, 74, 4680, 2.8, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (63, '2M', -18.73, -43.36, 662, 20.7, 66, 4842, 2.0, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (64, '3A', -20.51, -42.80, 603, 21.3, 80, 4749, 3.7, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (65, '2M', -22.07, -46.57, 891, 19.7, 70, 4795, 4.0, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (66, '1M', -21.74, -44.31, 971, 18.7, 76, 4750, 3.7, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (67, '2M', -17.73, -42.26, 868, 20.7, 65, 4885, 3.7, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (68, '1M', -21.32, -43.75, 1045, 18.4, 75, 4656, 3.3, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (69, '3B', -19.65, -42.87, 619, 21.5, 71, 4742, 2.6, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (70, '3A', -21.02, -42.11, 333, 22.3, 76, 4757, 2.6, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (71, '3B', -19.20, -44.25, 706, 22.6, 66, 5323, 3.2, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (72, '2M', -21.34, -43.37, 603, 20.3, 77, 4621, 3.0, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (73, '4B', -16.85, -42.06, 321, 24.6, 64, 5260, 4.0, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (74, '3B', -18.65, -48.19, 930, 22.3, 66, 5299, 4.0, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (75, '1M', -21.91, -44.26, 1052, 18.2, 77, 4689, 3.5, 11.4);

-- ==============================
-- Minas Gerais (MG) - continuação
-- ids sequenciais 76..117
-- ==============================

INSERT INTO cidade (id, nome, estado_id, tipo) values (76, 'Araponga', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (77, 'Araporã', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (78, 'Arapuá', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (79, 'Araújos', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (80, 'Araxá', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (81, 'Arceburgo', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (82, 'Arcos', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (83, 'Areado', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (84, 'Argirita', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (85, 'Aricanduva', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (86, 'Arinos', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (87, 'Astolfo Dutra', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (88, 'Ataléia', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (89, 'Augusto de Lima', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (90, 'Baependi', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (91, 'Baldim', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (92, 'Bambuí', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (93, 'Bandeira', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (94, 'Bandeira do Sul', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (95, 'Barão de Cocais', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (96, 'Barão de Monte Alto', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (97, 'Barbacena', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (98, 'Barra Longa', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (99, 'Barroso', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (100, 'Bela Vista de Minas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (101, 'Belmiro Braga', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (102, 'Belo Horizonte', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (103, 'Belo Oriente', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (104, 'Belo Vale', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (105, 'Berilo', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (106, 'Berizal', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (107, 'Bertópolis', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (108, 'Betim', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (109, 'Bias Fortes', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (110, 'Bicas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (111, 'Biquinhas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (112, 'Boa Esperança', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (113, 'Bocaina de Minas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (114, 'Bocaiúva', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (115, 'Bom Despacho', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (116, 'Bom Jardim de Minas', 2, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (117, 'Bom Jesus da Penha', 2, 'OFICIAL');

INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (76, '2M', -20.67, -42.52, 962, 19.0, 79, 4793, 3.9, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (77, '4B', -18.44, -49.18, 472, 24.9, 65, 5404, 0.9, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (78, '3B', -19.03, -46.15, 986, 21.6, 67, 5250, 3.6, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (79, '3B', -19.94, -45.17, 769, 21.8, 68, 5189, 3.2, 13.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (80, '3B', -19.59, -46.94, 982, 21.6, 65, 5176, 2.4, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (81, '3B', -21.36, -46.94, 706, 21.8, 67, 5011, 3.2, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (82, '3B', -20.29, -45.54, 738, 21.6, 68, 5136, 3.2, 13.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (83, '2M', -21.36, -46.14, 786, 20.9, 70, 4899, 2.8, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (84, '3A', -21.61, -42.83, 412, 22.2, 79, 4697, 3.1, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (85, '3B', -17.87, -42.55, 808, 20.9, 66, 4913, 2.8, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (86, '5B', -15.92, -46.10, 509, 25.0, 63, 5647, 2.7, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (87, '3A', -21.32, -42.86, 412, 21.7, 78, 4804, 2.5, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (88, '4A', -18.04, -41.11, 236, 23.5, 73, 4810, 3.4, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (89, '4B', -18.10, -44.27, 529, 23.1, 63, 5489, 3.8, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (90, '2M', -21.96, -44.89, 928, 18.9, 77, 4897, 3.4, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (91, '3B', -19.28, -43.96, 685, 22.4, 67, 5319, 4.1, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (92, '3B', -20.02, -45.98, 708, 22.0, 68, 5172, 3.0, 13.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (93, '3B', -15.88, -40.56, 376, 22.4, 70, 4976, 3.4, 9.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (94, '2M', -21.73, -46.38, 958, 19.8, 71, 4848, 3.2, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (95, '2M', -19.94, -43.48, 751, 20.1, 68, 4699, 2.9, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (96, '3A', -21.24, -42.24, 205, 22.4, 77, 4904, 2.7, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (97, '2M', -21.22, -43.77, 1124, 18.9, 69, 5009, 0.7, 9.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (98, '3A', -20.29, -43.04, 400, 22.2, 77, 4760, 2.8, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (99, '2M', -21.19, -43.97, 970, 19.3, 74, 4762, 3.8, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (100, '3B', -19.83, -43.09, 716, 21.0, 71, 4774, 3.1, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (101, '2M', -21.94, -43.41, 574, 20.7, 81, 4530, 3.2, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (102, '3B', -19.91, -43.93, 842, 22.1, 65, 5251, 2.6, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (103, '4A', -19.22, -42.48, 282, 23.2, 72, 4892, 2.6, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (104, '2M', -20.41, -44.03, 809, 19.6, 74, 5066, 3.4, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (105, '4B', -16.96, -42.46, 457, 23.8, 64, 5216, 3.3, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (106, '3B', -15.61, -41.74, 728, 22.0, 70, 5152, 3.5, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (107, '4A', -17.06, -40.58, 264, 23.9, 74, 4974, 2.9, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (108, '3B', -19.97, -44.20, 817, 21.1, 69, 5158, 3.6, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (109, '2M', -21.60, -43.76, 797, 19.1, 76, 4543, 2.7, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (110, '3A', -21.72, -43.06, 647, 21.0, 80, 4640, 3.5, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (111, '4B', -18.78, -45.50, 637, 23.2, 64, 5431, 3.1, 12.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (112, '3B', -21.09, -45.56, 803, 21.0, 70, 4955, 3.4, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (113, '1M', -22.17, -44.40, 1197, 17.9, 79, 4494, 2.8, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (114, '4B', -17.11, -43.81, 692, 23.2, 63, 5545, 3.9, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (115, '3B', -19.74, -45.26, 708, 22.5, 68, 5247, 3.0, 13.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (116, '1M', -21.95, -44.19, 1109, 18.0, 78, 4659, 3.0, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (117, '2M', -21.01, -46.52, 983, 20.2, 69, 4986, 3.6, 11.1);

-- ==============================
-- Rio de Janeiro (RJ)
-- estado id = 3
-- ==============================
INSERT INTO estado (id, uf, nome) values (3, 'RJ', 'Rio de Janeiro');

-- Cidades (ids explícitos, estado_id = 3)
INSERT INTO cidade (id, nome, estado_id, tipo) values (118, 'Angra dos Reis', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (119, 'Aperibé', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (120, 'Araruama', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (121, 'Areal', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (122, 'Armação dos Búzios', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (123, 'Arraial do Cabo', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (124, 'Barra do Piraí', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (125, 'Barra Mansa', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (126, 'Belford Roxo', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (127, 'Bom Jardim', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (128, 'Bom Jesus do Itabapoana', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (129, 'Cabo Frio', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (130, 'Cachoeiras de Macacu', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (131, 'Cambuci', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (132, 'Campos dos Goytacazes', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (133, 'Cantagalo', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (134, 'Carapebus', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (135, 'Cardoso Moreira', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (136, 'Carmo', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (137, 'Casimiro de Abreu', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (138, 'Comendador Levy Gasparian', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (139, 'Conceição de Macabu', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (140, 'Cordeiro', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (141, 'Duas Barras', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (142, 'Duque de Caxias', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (143, 'Engenheiro Paulo de Frontin', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (144, 'Guapimirim', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (145, 'Iguaba Grande', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (146, 'Itaboraí', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (147, 'Itaguaí', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (148, 'Italva', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (149, 'Itaocara', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (150, 'Itaperuna', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (151, 'Itatiaia', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (152, 'Japeri', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (153, 'Laje do Muriaé', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (154, 'Macaé', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (155, 'Macuco', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (156, 'Magé', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (157, 'Mangaratiba', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (158, 'Maricá', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (159, 'Mendes', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (160, 'Mesquita', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (161, 'Miguel Pereira', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (162, 'Miracema', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (163, 'Natividade', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (164, 'Nilópolis', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (165, 'Niterói', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (166, 'Nova Friburgo', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (167, 'Nova Iguaçu', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (168, 'Paracambi', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (169, 'Paraíba do Sul', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (170, 'Paraty', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (171, 'Paty do Alferes', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (172, 'Petrópolis', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (173, 'Pinheiral', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (174, 'Piraí', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (175, 'Porciúncula', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (176, 'Porto Real', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (177, 'Quatis', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (178, 'Queimados', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (179, 'Quissamã', 3, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (180, 'Resende', 3, 'OFICIAL');

-- Zoneamento RJ (valores normalizados)
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (118, '2M', -23.00, -44.32, 160, 20.8, 78, 4334, 2.6, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (119, '4A', -21.63, -42.10, 66, 23.5, 77, 4863, 2.7, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (120, '4A', -22.87, -42.33, 26, 23.3, 80, 4860, 3.9, 7.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (121, '3A', -22.23, -43.11, 529, 21.1, 83, 4754, 3.5, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (122, '4A', -22.75, -41.88, 12, 23.3, 79, 5064, 4.1, 7.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (123, '4A', -22.98, -42.03, 12, 23.3, 79, 5023, 4.2, 7.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (124, '3A', -22.47, -43.83, 369, 21.5, 78, 4653, 3.5, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (125, '2M', -22.55, -44.18, 427, 20.9, 77, 4652, 2.7, 10.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (126, '4A', -22.76, -43.40, 40, 23.1, 78, 4615, 2.7, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (127, '2M', -22.15, -42.43, 740, 20.0, 84, 4546, 3.3, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (128, '3A', -21.14, -41.68, 92, 22.7, 76, 4870, 3.3, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (129, '4A', -22.89, -42.03, 10, 23.3, 79, 4921, 3.9, 7.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (130, '3A', -22.47, -42.65, 50, 22.0, 83, 4569, 2.7, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (131, '4A', -21.57, -41.92, 45, 24.1, 75, 4739, 1.1, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (132, '4A', -21.76, -41.32, 11, 24.0, 74, 5149, 3.0, 9.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (133, '2M', -21.98, -42.37, 423, 20.4, 82, 4668, 3.0, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (134, '4A', -22.18, -41.66, 12, 23.2, 79, 4865, 4.1, 8.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (135, '4A', -21.48, -41.62, 90, 23.7, 76, 4917, 3.4, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (136, '3A', -21.93, -42.60, 310, 21.6, 82, 4784, 2.8, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (137, '3A', -22.48, -42.21, 49, 22.7, 81, 4574, 3.4, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (138, '3A', -22.04, -43.21, 458, 21.4, 81, 4597, 3.1, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (139, '3A', -22.08, -41.87, 65, 22.4, 79, 4649, 3.6, 8.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (140, '2M', -22.03, -42.36, 520, 20.4, 83, 4668, 3.0, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (141, '2M', -22.05, -42.52, 599, 20.3, 84, 4596, 2.9, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (142, '3A', -22.79, -43.30, 26, 22.5, 80, 4595, 0.9, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (143, '3A', -22.55, -43.68, 413, 21.5, 79, 4681, 3.2, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (144, '2M', -22.53, -42.99, 44, 20.7, 84, 4319, 2.4, 7.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (145, '3A', -22.85, -42.23, 7, 22.9, 80, 4860, 4.2, 7.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (146, '3A', -22.76, -42.86, 18, 22.9, 80, 4785, 3.3, 7.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (147, '4A', -22.86, -43.78, 28, 23.0, 78, 4688, 3.6, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (148, '4A', -21.43, -41.70, 49, 23.3, 77, 4931, 3.3, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (149, '4A', -21.67, -42.08, 118, 23.8, 77, 4934, 2.7, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (150, '4A', -21.20, -41.88, 197, 23.2, 77, 4954, 2.8, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (151, '2M', -22.49, -44.57, 408, 20.8, 77, 4436, 2.3, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (152, '3A', -22.64, -43.66, 53, 22.2, 78, 4614, 2.7, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (153, '3A', -21.21, -42.13, 216, 22.8, 77, 4906, 2.7, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (154, '4A', -22.38, -41.78, 8, 23.9, 81, 4981, 2.7, 9.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (155, '3A', -21.98, -42.25, 267, 21.3, 80, 4736, 3.7, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (156, '4A', -22.66, -43.03, 9, 23.2, 81, 4655, 2.5, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (157, '3A', -22.96, -44.04, 37, 21.5, 78, 4399, 3.8, 10.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (158, '4A', -22.94, -42.82, 3, 23.4, 79, 4785, 3.2, 7.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (159, '3A', -22.52, -43.73, 458, 21.5, 79, 4698, 3.2, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (160, '3A', -22.80, -43.46, 557, 22.9, 79, 4615, 2.7, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (161, '2M', -22.46, -43.48, 684, 20.8, 81, 4691, 3.3, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (162, '4A', -21.41, -42.19, 148, 23.1, 77, 4797, 2.6, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (163, '3A', -21.04, -41.97, 409, 22.5, 76, 4917, 2.8, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (164, '4A', -22.81, -43.42, 17, 23.1, 79, 4615, 2.7, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (165, '4A', -22.88, -43.10, 17, 23.4, 80, 4785, 2.7, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (166, '1M', -22.29, -42.54, 857, 17.5, 84, 4867, 2.0, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (167, '3A', -22.76, -43.46, 20, 22.9, 79, 4615, 2.4, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (168, '3A', -22.61, -43.71, 80, 22.2, 78, 4641, 3.1, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (169, '3A', -22.16, -43.30, 346, 21.6, 81, 4711, 3.2, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (170, '3A', -23.22, -44.72, 6, 22.7, 82, 4844, 1.5, 7.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (171, '2M', -22.43, -43.43, 592, 20.0, 81, 4757, 3.3, 10.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (172, '2M', -22.52, -43.19, 858, 19.8, 82, 4508, 2.7, 8.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (173, '3A', -22.52, -44.00, 402, 21.4, 78, 4671, 2.7, 10.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (174, '3A', -22.62, -43.91, 388, 21.6, 78, 4650, 3.1, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (175, '3A', -20.96, -42.05, 246, 22.5, 77, 4897, 3.0, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (176, '2M', -22.42, -44.30, 395, 20.5, 77, 4600, 2.3, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (177, '2M', -22.40, -44.26, 409, 20.5, 77, 4600, 2.5, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (178, '4A', -22.71, -43.55, 65, 23.1, 79, 4659, 2.5, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (179, '4A', -22.10, -41.47, 9, 23.8, 78, 4939, 4.2, 9.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (180, '3A', -22.47, -44.45, 406, 21.7, 74, 4711, 1.9, 10.5);

-- ==============================
-- São Paulo (SP)
-- estado id = 4
-- ==============================
INSERT INTO estado (id, uf, nome) values (4, 'SP', 'São Paulo');

-- Cidades (ids explícitos, estado_id = 4) a partir de 181
INSERT INTO cidade (id, nome, estado_id, tipo) values (181, 'Adamantina', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (182, 'Adolfo', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (183, 'Aguaí', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (184, 'Águas da Prata', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (185, 'Águas de Lindóia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (186, 'Águas de Santa Bárbara', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (187, 'Águas de São Pedro', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (188, 'Agudos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (189, 'Alambari', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (190, 'Alfredo Marcondes', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (191, 'Altair', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (192, 'Altinópolis', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (193, 'Alto Alegre', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (194, 'Alumínio', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (195, 'Álvares Florence', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (196, 'Álvares Machado', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (197, 'Álvaro de Carvalho', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (198, 'Alvinlândia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (199, 'Americana', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (200, 'Américo Brasiliense', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (201, 'Américo de Campos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (202, 'Amparo', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (203, 'Analândia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (204, 'Andradina', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (205, 'Angatuba', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (206, 'Anhembi', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (207, 'Anhumas', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (208, 'Aparecida', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (209, 'Aparecida Oeste', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (210, 'Apiaí', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (211, 'Araçariguama', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (212, 'Araçatuba', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (213, 'Araçoiaba da Serra', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (214, 'Aramina', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (215, 'Arandu', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (216, 'Arapeí', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (217, 'Araraquara', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (218, 'Araras', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (219, 'Arco-Íris', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (220, 'Arealva', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (221, 'Areias', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (222, 'Areiópolis', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (223, 'Ariranha', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (224, 'Artur Nogueira', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (225, 'Arujá', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (226, 'Aspásia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (227, 'Assis', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (228, 'Atibaia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (229, 'Auriflama', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (230, 'Avaí', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (231, 'Avanhandava', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (232, 'Avaré', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (233, 'Bady Bassitt', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (234, 'Balbinos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (235, 'Bálsamo', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (236, 'Bananal', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (237, 'Barão de Antonina', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (238, 'Barbosa', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (239, 'Bariri', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (240, 'Barra Bonita', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (241, 'Barra do Chapéu', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (242, 'Barra do Turvo', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (243, 'Barretos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (244, 'Barrinha', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (245, 'Barueri', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (246, 'Bastos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (247, 'Batatais', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (248, 'Bauru', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (249, 'Bebedouro', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (250, 'Bento de Abreu', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (251, 'Bernardino de Campos', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (252, 'Bertioga', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (253, 'Bilac', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (254, 'Birigui', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (255, 'Biritiba-Mirim', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (256, 'Boa Esperança do Sul', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (257, 'Bocaina', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (258, 'Bofete', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (259, 'Boituva', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (260, 'Bom Jesus dos Perdões', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (261, 'Bom Sucesso de Itararé', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (262, 'Borá', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (263, 'Boracéia', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (264, 'Borborema', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (265, 'Borebi', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (266, 'Botucatu', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (267, 'Bragança Paulista', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (268, 'Braúna', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (269, 'Brejo Alegre', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (270, 'Brodowski', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (271, 'Brotas', 4, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (272, 'Buri', 4, 'OFICIAL');

-- Zoneamento SP (cada INSERT em uma linha)
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (181, '4B', -21.68, -51.07, 465, 23.9, 66, 5125, 3.9, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (182, '4B', -21.23, -49.65, 437, 24.2, 65, 5115, 3.7, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (183, '3B', -22.06, -46.97, 668, 21.8, 68, 5001, 3.7, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (184, '2M', -21.93, -46.72, 896, 19.6, 69, 4893, 4.2, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (185, '2M', -22.47, -46.63, 885, 20.6, 70, 4931, 3.9, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (186, '3B', -22.88, -49.24, 551, 21.2, 70, 4893, 4.4, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (187, '3B', -22.60, -47.87, 494, 22.2, 68, 4824, 3.5, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (188, '3B', -22.47, -48.99, 590, 21.9, 69, 4929, 3.9, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (189, '2M', -23.55, -47.90, 586, 20.0, 80, 4762, 3.8, 9.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (190, '4B', -21.95, -51.41, 421, 23.7, 65, 5144, 4.2, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (191, '4B', -20.52, -49.06, 559, 24.2, 65, 5178, 3.6, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (192, '3B', -21.02, -47.37, 926, 21.8, 68, 5034, 4.1, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (193, '4B', -21.58, -50.17, 504, 23.7, 65, 5097, 3.9, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (194, '2M', -23.53, -47.25, 772, 20.1, 71, 4768, 4.3, 9.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (195, '4B', -20.32, -49.91, 444, 24.2, 64, 5194, 3.6, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (196, '4B', -22.08, -51.47, 472, 23.6, 65, 5119, 4.0, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (197, '4B', -22.08, -49.72, 625, 22.9, 66, 5036, 4.1, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (198, '3B', -22.44, -49.76, 658, 22.3, 69, 4964, 4.2, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (199, '3B', -22.74, -47.33, 562, 21.9, 67, 4913, 3.8, 10.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (200, '3B', -21.73, -48.11, 694, 22.5, 67, 5027, 3.9, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (201, '4B', -20.30, -49.74, 471, 24.5, 65, 5184, 3.5, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (202, '2M', -22.71, -46.77, 669, 20.6, 69, 4924, 4.1, 10.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (203, '3B', -22.13, -47.66, 670, 21.1, 70, 4938, 3.7, 10.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (204, '4B', -20.89, -51.38, 408, 24.7, 65, 5172, 3.8, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (205, '2M', -23.49, -48.41, 635, 20.2, 80, 4694, 4.0, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (206, '3B', -22.79, -48.13, 496, 21.9, 69, 4941, 3.7, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (207, '4B', -22.29, -51.39, 459, 23.3, 65, 5090, 4.2, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (208, '2M', -22.85, -45.23, 550, 20.8, 80, 4628, 2.5, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (209, '4B', -20.45, -50.88, 416, 24.9, 63, 5202, 3.6, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (210, '1M', -24.51, -48.84, 902, 18.0, 79, 4189, 2.5, 9.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (211, '2M', -23.44, -47.06, 712, 19.7, 72, 4707, 4.1, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (212, '4B', -21.21, -50.44, 405, 24.3, 66, 5159, 3.7, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (213, '2M', -23.50, -47.62, 616, 20.6, 74, 4756, 3.8, 9.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (214, '4B', -20.09, -47.79, 618, 23.8, 65, 5202, 4.2, 10.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (215, '2M', -23.14, -49.05, 624, 20.6, 71, 4826, 4.0, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (216, '2M', -22.67, -44.44, 498, 19.1, 77, 4591, 2.7, 10.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (217, '3B', -21.78, -48.18, 681, 22.5, 67, 5009, 4.0, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (218, '3B', -22.36, -47.38, 637, 21.5, 69, 4941, 3.7, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (219, '4B', -21.77, -50.47, 428, 23.6, 67, 5088, 4.1, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (220, '4B', -22.03, -48.91, 433, 23.3, 67, 5080, 4.0, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (221, '3A', -22.58, -44.70, 518, 21.3, 77, 4704, 2.8, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (222, '3B', -22.67, -48.67, 648, 21.2, 68, 4968, 4.3, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (223, '4B', -21.19, -48.79, 579, 23.2, 68, 5355, 2.0, 13.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (224, '3B', -22.57, -47.17, 645, 21.9, 68, 4948, 3.6, 10.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (225, '2M', -23.40, -46.32, 792, 19.4, 75, 4398, 3.2, 9.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (226, '4B', -20.16, -50.73, 402, 24.8, 62, 5208, 3.5, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (227, '3B', -22.66, -50.42, 580, 22.4, 69, 4958, 4.3, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (228, '2M', -23.12, -46.56, 785, 19.7, 75, 4782, 3.6, 9.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (229, '4B', -20.68, -50.56, 451, 24.5, 64, 5186, 3.6, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (230, '3B', -22.15, -49.34, 459, 22.8, 69, 4986, 4.0, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (231, '4B', -21.46, -49.95, 442, 23.7, 65, 5114, 3.7, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (232, '2M', -23.11, -48.93, 789, 20.5, 71, 4823, 4.1, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (233, '4B', -20.92, -49.44, 520, 23.7, 66, 5121, 3.5, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (234, '4B', -21.90, -49.36, 448, 23.2, 66, 5071, 4.1, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (235, '4B', -20.73, -49.59, 550, 23.7, 66, 5152, 3.5, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (236, '2M', -22.68, -44.33, 484, 19.9, 77, 4622, 2.8, 10.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (237, '3B', -23.63, -49.56, 579, 21.3, 73, 4845, 3.9, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (238, '4B', -21.27, -49.95, 401, 24.2, 65, 5137, 3.7, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (239, '4B', -22.07, -48.74, 426, 23.1, 67, 5053, 4.1, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (240, '3B', -22.49, -48.56, 473, 22.6, 68, 5199, 1.7, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (241, '1M', -24.47, -49.02, 785, 18.4, 78, 4215, 3.0, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (242, '2M', -24.76, -48.50, 166, 19.2, 79, 4056, 2.8, 9.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (243, '4B', -20.55, -48.57, 541, 23.1, 66, 5472, 1.2, 14.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (244, '4B', -21.19, -48.16, 508, 23.3, 66, 5106, 3.7, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (245, '2M', -23.51, -46.88, 753, 19.5, 74, 4525, 3.1, 9.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (246, '4B', -21.92, -50.74, 449, 23.3, 68, 5075, 4.2, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (247, '3B', -20.89, -47.59, 857, 21.6, 67, 5073, 4.4, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (248, '3B', -22.32, -49.09, 512, 22.1, 71, 5284, 1.6, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (249, '4B', -20.95, -48.48, 568, 23.5, 65, 5136, 3.6, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (250, '4B', -21.27, -50.81, 444, 24.1, 66, 5388, 2.0, 12.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (251, '3B', -23.02, -49.47, 684, 21.6, 70, 4916, 4.4, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (252, '3A', -23.85, -46.14, 36, 21.2, 75, 3970, 3.0, 8.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (253, '4B', -21.40, -50.47, 437, 23.8, 66, 5128, 4.0, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (254, '4B', -21.29, -50.34, 410, 24.1, 66, 5144, 3.8, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (255, '2M', -23.57, -46.04, 766, 19.4, 76, 4422, 3.5, 8.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (256, '3B', -21.99, -48.39, 478, 22.8, 67, 5005, 4.3, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (257, '3B', -22.14, -48.52, 596, 22.8, 67, 5002, 4.4, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (258, '2M', -23.11, -48.26, 564, 20.6, 72, 4800, 3.6, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (259, '3B', -23.29, -47.68, 656, 21.1, 70, 4837, 3.8, 10.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (260, '4B', -23.14, -46.47, 765, 19.3, 76, 4751, 3.4, 9.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (261, '1M', -24.32, -49.15, 996, 17.7, 79, 4450, 3.2, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (262, '4B', -22.27, -50.54, 435, 22.8, 69, 5019, 4.4, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (263, '4B', -22.19, -48.78, 489, 23.0, 68, 5021, 4.1, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (264, '4B', -21.62, -49.07, 406, 23.9, 67, 5081, 3.9, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (265, '3B', -22.57, -48.97, 617, 21.7, 69, 4931, 3.7, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (266, '2M', -22.88, -48.44, 826, 20.7, 69, 4893, 4.0, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (267, '2M', -22.95, -46.54, 854, 19.7, 76, 4807, 3.8, 10.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (268, '4B', -21.50, -50.32, 453, 23.7, 66, 5118, 4.0, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (269, '4B', -21.17, -50.19, 398, 24.3, 66, 5117, 3.6, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (270, '3B', -20.98, -47.66, 864, 22.8, 67, 5050, 4.1, 10.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (271, '3B', -22.28, -48.13, 662, 21.4, 68, 4955, 4.6, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (272, '2M', -23.80, -48.60, 606, 19.9, 79, 4592, 3.3, 11.0);

-- ==============================
-- Distrito Federal (DF)
-- estado id = 5
-- ==============================
INSERT INTO estado (id, uf, nome) values (5, 'DF', 'Distrito Federal');

-- Cidades (ids explícitos, estado_id = 5)
INSERT INTO cidade (id, nome, estado_id, tipo) values (273, 'Brasília', 5, 'OFICIAL');

-- Zoneamento DF
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (273, '3B', -15.78, -47.93, 1136, 22.0, 66, 5453, 2.5, 11.3);


-- ==============================
-- Goiás (GO)
-- estado id = 6
-- ==============================
INSERT INTO estado (id, uf, nome) values (6, 'GO', 'Goiás');

-- Cidades (ids explícitos, estado_id = 6) a partir de 274
INSERT INTO cidade (id, nome, estado_id, tipo) values (274, 'Abadia de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (275, 'Abadiânia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (276, 'Acreúna', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (277, 'Adelândia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (278, 'Água Fria de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (279, 'Água Limpa', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (280, 'Águas Lindas de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (281, 'Alexânia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (282, 'Aloândia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (283, 'Alto Horizonte', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (284, 'Alto Paraíso de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (285, 'Alvorada do Norte', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (286, 'Amaralina', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (287, 'Americano do Brasil', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (288, 'Amorinópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (289, 'Anápolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (290, 'Anhanguera', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (291, 'Anicuns', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (292, 'Aparecida de Goiânia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (293, 'Aparecida do Rio Doce', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (294, 'Aporé', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (295, 'Araçu', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (296, 'Aragarças', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (297, 'Aragoiânia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (298, 'Araguapaz', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (299, 'Arenópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (300, 'Aruanã', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (301, 'Aurilândia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (302, 'Avelinópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (303, 'Baliza', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (304, 'Barro Alto', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (305, 'Bela Vista de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (306, 'Bom Jardim de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (307, 'Bom Jesus de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (308, 'Bonfinópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (309, 'Bonópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (310, 'Brazabrantes', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (311, 'Britânia', 6, 'OFICIAL');

-- Zoneamento GO (cada INSERT em uma linha) — valores exemplo normalizados
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (274, '3B', -16.82, -49.24, 912, 22.1, 66, 5402, 3.1, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (275, '3B', -15.78, -48.25, 759, 22.3, 65, 5380, 3.0, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (276, '3B', -17.72, -50.05, 656, 22.0, 66, 5310, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (277, '3B', -16.91, -49.48, 814, 21.8, 67, 5355, 2.9, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (278, '3B', -16.24, -47.24, 462, 22.5, 64, 5450, 3.0, 10.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (279, '3B', -17.78, -49.48, 560, 22.0, 65, 5333, 2.8, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (280, '3B', -16.75, -48.25, 830, 22.2, 64, 5360, 3.4, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (281, '3B', -16.05, -48.85, 910, 22.6, 63, 5405, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (282, '3B', -17.03, -49.64, 780, 22.0, 65, 5364, 3.0, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (283, '3B', -14.94, -49.01, 914, 21.9, 66, 5410, 3.1, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (284, '1M', -14.73, -47.52, 1046, 18.7, 68, 5080, 2.4, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (285, '3B', -14.23, -46.26, 895, 22.4, 65, 5471, 2.9, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (286, '3B', -16.40, -49.85, 632, 22.1, 65, 5378, 2.8, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (287, '3B', -16.46, -49.54, 710, 22.3, 64, 5388, 3.0, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (288, '3B', -16.81, -50.44, 688, 22.2, 65, 5345, 3.3, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (289, '3B', -16.33, -49.23, 678, 22.0, 66, 5359, 2.9, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (290, '3B', -16.97, -50.87, 593, 22.1, 65, 5370, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (291, '3B', -16.65, -49.30, 692, 22.0, 65, 5376, 3.0, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (292, '3B', -16.52, -49.15, 698, 22.3, 65, 5381, 3.1, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (293, '3B', -17.28, -49.25, 564, 22.2, 65, 5369, 3.0, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (294, '3B', -18.02, -50.24, 420, 22.6, 64, 5322, 3.2, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (295, '3B', -16.20, -49.90, 640, 22.1, 65, 5374, 3.0, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (296, '3B', -15.76, -52.13, 250, 23.0, 62, 5100, 3.3, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (297, '3B', -16.89, -49.37, 720, 22.0, 65, 5367, 3.1, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (298, '3B', -15.85, -50.99, 305, 22.4, 64, 5298, 3.0, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (299, '3B', -16.07, -50.12, 410, 22.2, 65, 5339, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (300, '3B', -15.05, -49.89, 360, 22.5, 64, 5420, 2.9, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (301, '3B', -16.76, -50.58, 540, 22.1, 65, 5325, 3.0, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (302, '3B', -16.43, -50.85, 610, 22.0, 65, 5331, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (303, '3B', -14.78, -52.93, 280, 22.8, 63, 5060, 3.1, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (304, '3B', -14.17, -49.07, 720, 22.2, 64, 5435, 3.2, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (305, '3B', -15.12, -49.62, 610, 22.0, 65, 5390, 3.0, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (306, '3B', -15.33, -49.25, 580, 22.1, 65, 5401, 3.1, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (307, '3B', -15.98, -49.63, 700, 22.2, 64, 5360, 3.2, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (308, '3B', -16.05, -49.02, 745, 22.0, 65, 5378, 3.0, 11.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (309, '3B', -14.63, -49.11, 880, 21.9, 66, 5455, 3.1, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (310, '3B', -14.85, -49.65, 950, 21.8, 66, 5438, 3.0, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (311, '3B', -14.88, -51.56, 340, 22.6, 64, 5085, 3.2, 11.4);

-- ==============================
-- Goiás (GO) - adicionais
-- cidades e zoneamentos fornecidos pelo usuário
-- ids sequenciais a partir de 312
-- ==============================
INSERT INTO cidade (id, nome, estado_id, tipo) values (312, 'Buriti Alegre', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (313, 'Buriti de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (314, 'Buritinópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (315, 'Cabeceiras', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (316, 'Cachoeira Alta', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (317, 'Cachoeira de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (318, 'Cachoeira Dourada', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (319, 'Caçu', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (320, 'Caiapônia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (321, 'Caldas Novas', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (322, 'Caldazinha', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (323, 'Campestre de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (324, 'Campinaçu', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (325, 'Campinorte', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (326, 'Campo Alegre de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (327, 'Campo Limpo de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (328, 'Campos Belos', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (329, 'Campos Verdes', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (330, 'Carmo do Rio Verde', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (331, 'Castelândia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (332, 'Catalão', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (333, 'Caturaí', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (334, 'Cavalcante', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (335, 'Ceres', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (336, 'Cezarina', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (337, 'Chapadão do Céu', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (338, 'Cidade Ocidental', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (339, 'Cocalzinho de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (340, 'Colinas do Sul', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (341, 'Córrego do Ouro', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (342, 'Corumbá de Goiás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (343, 'Corumbaíba', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (344, 'Cristalina', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (345, 'Cristianópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (346, 'Crixás', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (347, 'Cromínia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (348, 'Cumari', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (349, 'Damianópolis', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (350, 'Damolândia', 6, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (351, 'Davinópolis', 6, 'OFICIAL');

-- Zoneamento para as cidades adicionadas (valores normalizados)
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (312, '4B', -18.14, -49.04, 819, 23.8, 65, 5230, 3.6, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (313, '5B', -16.18, -50.43, 540, 25.1, 63, 5303, 3.5, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (314, '4B', -14.48, -46.41, 549, 24.5, 59, 5621, 3.4, 10.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (315, '4B', -15.80, -46.93, 914, 23.1, 64, 5511, 3.0, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (316, '4B', -18.76, -50.94, 502, 24.6, 65, 5238, 3.5, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (317, '4B', -16.66, -50.65, 767, 24.0, 62, 5236, 3.4, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (318, '5B', -18.49, -49.48, 433, 25.2, 64, 5230, 3.9, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (319, '4B', -18.56, -51.13, 503, 24.6, 65, 5240, 3.3, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (320, '4B', -16.95, -51.81, 708, 23.8, 64, 5402, 1.6, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (321, '4B', -17.74, -48.62, 686, 23.7, 65, 5291, 3.4, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (322, '4B', -16.71, -49.00, 855, 23.6, 65, 5283, 3.5, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (323, '4B', -16.76, -49.70, 641, 24.7, 65, 5264, 3.3, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (324, '4B', -13.79, -48.57, 697, 24.8, 59, 5274, 2.9, 11.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (325, '5B', -14.31, -49.15, 542, 25.8, 64, 5320, 2.8, 11.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (326, '3B', -17.64, -47.78, 888, 22.8, 66, 5280, 3.7, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (327, '3B', -16.30, -49.09, 877, 22.8, 66, 5231, 3.3, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (328, '5B', -13.04, -46.77, 630, 25.4, 60, 5544, 3.6, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (329, '5B', -14.24, -49.65, 386, 26.9, 66, 5328, 3.4, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (330, '4B', -15.35, -49.71, 610, 24.6, 64, 5267, 3.1, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (331, '5B', -18.09, -50.20, 451, 25.3, 65, 5290, 3.4, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (332, '3B', -18.17, -47.94, 845, 22.7, 66, 5301, 3.3, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (333, '4B', -16.44, -49.49, 759, 23.7, 65, 5258, 3.6, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (334, '4B', -13.80, -47.46, 807, 23.2, 55, 5401, 3.8, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (335, '4B', -15.31, -49.60, 569, 24.4, 64, 5232, 3.2, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (336, '4B', -16.97, -49.78, 595, 24.7, 64, 5287, 3.4, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (337, '4B', -18.41, -52.55, 748, 22.9, 67, 5092, 3.0, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (338, '3B', -16.08, -47.93, 1065, 22.3, 64, 5282, 3.3, 11.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (339, '3B', -15.79, -48.77, 1118, 21.9, 63, 5227, 4.0, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (340, '4B', -14.15, -48.08, 533, 24.9, 59, 5386, 3.2, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (341, '4B', -16.29, -50.55, 544, 24.8, 63, 5267, 3.2, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (342, '3B', -15.92, -48.81, 986, 22.2, 65, 5189, 3.7, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (343, '4B', -18.14, -48.56, 612, 24.1, 64, 5299, 3.5, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (344, '3B', -16.77, -47.61, 1235, 21.5, 61, 5306, 3.5, 11.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (345, '4B', -17.20, -48.70, 813, 23.4, 65, 5296, 3.7, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (346, '5B', -14.54, -49.97, 412, 26.4, 66, 5308, 3.4, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (347, '4B', -17.29, -49.38, 709, 23.9, 65, 5276, 3.4, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (348, '4B', -18.26, -48.15, 712, 24.3, 65, 5298, 3.4, 11.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (349, '4B', -14.56, -46.18, 761, 24.0, 60, 5594, 3.7, 10.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (350, '4B', -16.25, -49.36, 853, 23.4, 65, 5273, 3.7, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (351, '4B', -18.15, -47.56, 775, 23.2, 66, 5344, 3.6, 11.3);

-- ==============================
-- Mato Grosso (MT)
-- estado id = 7
-- ==============================
INSERT INTO estado (id, uf, nome) values (7, 'MT', 'Mato Grosso');

-- Cidades (ids explícitos, estado_id = 7) a partir de 352
INSERT INTO cidade (id, nome, estado_id, tipo) values (352, 'Acorizal', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (353, 'Água Boa', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (354, 'Alta Floresta', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (355, 'Alto Araguaia', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (356, 'Alto Boa Vista', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (357, 'Alto Garças', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (358, 'Alto Paraguai', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (359, 'Alto Taquari', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (360, 'Apiacás', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (361, 'Araguaiana', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (362, 'Araguainha', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (363, 'Araputanga', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (364, 'Arenápolis', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (365, 'Aripuanã', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (366, 'Barão de Melgaço', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (367, 'Barra do Bugres', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (368, 'Barra do Garças', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (369, 'Bom Jesus do Araguaia', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (370, 'Brasnorte', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (371, 'Cáceres', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (372, 'Campinápolis', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (373, 'Campo Novo do Parecis', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (374, 'Campo Verde', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (375, 'Campos de Júlio', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (376, 'Canabrava do Norte', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (377, 'Canarana', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (378, 'Carlinda', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (379, 'Castanheira', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (380, 'Chapada dos Guimarães', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (381, 'Cláudia', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (382, 'Cocalinho', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (383, 'Colíder', 7, 'OFICIAL');

-- Zoneamento MT (valores normalizados)
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (352, '5A', -15.19, -56.36, 180, 26.6, 69, 5138, 3.0, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (353, '5B', -14.05, -52.16, 452, 26.3, 66, 5266, 3.0, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (354, '5A', -9.87, -56.09, 285, 25.5, 79, 5233, 1.4, 11.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (355, '4B', -17.32, -53.22, 674, 23.5, 68, 5154, 3.1, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (356, '6B', -11.67, -51.39, 238, 27.4, 58, 5147, 2.9, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (357, '4B', -16.95, -53.53, 778, 23.5, 66, 5146, 3.5, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (358, '5A', -14.51, -56.48, 227, 25.8, 71, 5073, 3.1, 12.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (359, '3B', -17.82, -53.28, 883, 22.5, 68, 5307, 2.2, 11.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (360, '5A', -9.54, -57.46, 249, 26.3, 76, 5051, 0.8, 11.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (361, '5B', -15.73, -51.83, 308, 26.6, 66, 5262, 2.7, 12.1);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (362, '4B', -16.86, -53.03, 477, 24.9, 66, 5236, 2.7, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (363, '5A', -15.46, -58.34, 221, 26.1, 73, 4893, 3.1, 12.7);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (364, '5A', -14.45, -56.84, 322, 25.9, 70, 5040, 2.4, 12.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (365, '5A', -10.17, -59.46, 226, 25.8, 78, 4677, 1.8, 11.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (366, '6A', -16.21, -55.96, 130, 27.0, 70, 5175, 2.9, 12.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (367, '5A', -15.07, -57.19, 182, 26.3, 74, 5063, 3.1, 12.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (368, '5B', -15.88, -52.26, 359, 26.2, 66, 5256, 2.5, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (369, '5B', -12.17, -51.50, 268, 26.8, 60, 5163, 2.4, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (370, '5A', -12.15, -57.98, 307, 25.4, 75, 5174, 1.2, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (371, '5A', -16.08, -57.68, 124, 26.9, 73, 5063, 3.3, 12.4);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (372, '5B', -14.52, -52.89, 432, 25.5, 66, 5295, 3.4, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (373, '4B', -13.66, -57.89, 570, 24.5, 60, 5343, 1.7, 10.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (374, '4B', -15.54, -55.16, 753, 23.8, 69, 5444, 2.6, 9.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (375, '4A', -13.72, -59.29, 639, 23.9, 77, 4762, 3.0, 12.9);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (376, '6B', -11.06, -51.82, 202, 27.0, 64, 5144, 2.3, 12.6);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (377, '5B', -13.55, -52.27, 425, 26.3, 66, 5233, 2.9, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (378, '5A', -9.95, -55.84, 268, 25.4, 75, 5225, 1.0, 9.8);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (379, '5A', -11.13, -58.61, 307, 25.6, 77, 4786, 2.2, 12.3);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (380, '5B', -15.46, -55.75, 827, 25.1, 65, 4962, 2.8, 12.5);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (381, '5A', -11.51, -54.88, 358, 25.6, 70, 5011, 2.3, 13.0);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (382, '6A', -14.39, -51.00, 246, 27.2, 67, 5280, 2.7, 12.2);
INSERT INTO zoneamento_bioclimatico (cidade_id, zona_bioclimatica, latitude, longitude, altitude, temperatura_bulbo_seco, umidade_relativa, radiacao_horizontal_global, velocidade_vento, amplitude_termica) VALUES (383, '5A', -10.81, -55.46, 303, 26.0, 73, 4984, 2.8, 12.8);

-- ==============================
-- Mato Grosso (MT) - adicionais
-- cidades e zoneamentos fornecidos pelo usuário
-- ids sequenciais a partir de 384
-- ==============================
INSERT INTO cidade (id, nome, estado_id, tipo) values (384, 'Colniza', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (385, 'Comodoro', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (386, 'Confresa', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (387, 'Conquista Oeste', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (388, 'Cotriguaçu', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (389, 'Cuiabá', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (390, 'Curvelândia', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (391, 'Denise', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (392, 'Diamantino', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (393, 'Dom Aquino', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (394, 'Feliz Natal', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (395, 'Figueirópolis oeste', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (396, 'Gaúcha do Norte', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (397, 'General Carneiro', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (398, 'Glória oeste', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (399, 'Guarantã do Norte', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (400, 'Guiratinga', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (401, 'Indiavaí', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (402, 'Ipiranga do Norte', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (403, 'Itanhangá', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (404, 'Itaúba', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (405, 'Itiquira', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (406, 'Jaciara', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (407, 'Jangada', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (408, 'Jauru', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (409, 'Juara', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (410, 'Juína', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (411, 'Juruena', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (412, 'Juscimeira', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (413, 'Lambari Doeste', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (414, 'Lucas do Rio Verde', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (415, 'Luciara', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (416, 'Marcelândia', 7, 'OFICIAL');
INSERT INTO cidade (id, nome, estado_id, tipo) values (417, 'Matupá', 7, 'OFICIAL');

-- Ajustar as sequências do H2 para que os próximos IDs sejam corretos
ALTER TABLE estado ALTER COLUMN id RESTART WITH 8;
ALTER TABLE cidade ALTER COLUMN id RESTART WITH 418;


 






