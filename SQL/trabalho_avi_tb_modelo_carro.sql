CREATE TABLE trabalho_avi.tb_modelo_carro
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao varchar(300),
    fabricante_id int(11),
    categoria varchar(50)
);
CREATE UNIQUE INDEX tb_modelo_carro_id_uindex ON trabalho_avi.tb_modelo_carro (id);
INSERT INTO trabalho_avi.tb_modelo_carro (id, descricao, fabricante_id, categoria) VALUES (1, 'Onix', 1, 'HATCH MEDIO');
INSERT INTO trabalho_avi.tb_modelo_carro (id, descricao, fabricante_id, categoria) VALUES (2, 'Gol', 2, null);
INSERT INTO trabalho_avi.tb_modelo_carro (id, descricao, fabricante_id, categoria) VALUES (4, 'Opalao', null, null);