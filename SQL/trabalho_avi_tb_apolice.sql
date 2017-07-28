CREATE TABLE trabalho_avi.tb_apolice
(
    id_apolice_seguro int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    valor_franquia decimal(10),
    protecao_terceiros tinyint(1),
    protecao_causas_naturais tinyint(1),
    protecao_roubo tinyint(1)
);
CREATE UNIQUE INDEX tb_apolice_id_apolice_seguro_uindex ON trabalho_avi.tb_apolice (id_apolice_seguro);
INSERT INTO trabalho_avi.tb_apolice (id_apolice_seguro, valor_franquia, protecao_terceiros, protecao_causas_naturais, protecao_roubo) VALUES (1, 400, 1, 1, 1);
INSERT INTO trabalho_avi.tb_apolice (id_apolice_seguro, valor_franquia, protecao_terceiros, protecao_causas_naturais, protecao_roubo) VALUES (2, 300, 1, 1, 1);