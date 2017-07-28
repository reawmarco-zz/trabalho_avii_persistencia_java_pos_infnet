CREATE TABLE trabalho_avi.tb_carro
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    placa varchar(7),
    chassi varchar(20),
    cor varchar(15),
    valor_diaria decimal(10),
    modelo_carro_id int(11)
);
CREATE UNIQUE INDEX tb_carro_id_uindex ON trabalho_avi.tb_carro (id);
INSERT INTO trabalho_avi.tb_carro (id, placa, chassi, cor, valor_diaria, modelo_carro_id) VALUES (1, 'teste', '1', 'azul', 30, 1);