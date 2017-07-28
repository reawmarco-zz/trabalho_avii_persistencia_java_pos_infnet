CREATE TABLE trabalho_avi.tb_aluguel
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_aluguel datetime,
    data_devolucao date,
    data_entrega date,
    valor_total double,
    cnh_motorista varchar(20),
    apolice_seguro int(11),
    carro_id int(11)
);
CREATE UNIQUE INDEX tb_aluguel_id_uindex ON trabalho_avi.tb_aluguel (id);
INSERT INTO trabalho_avi.tb_aluguel (id, data_aluguel, data_devolucao, data_entrega, valor_total, cnh_motorista, apolice_seguro, carro_id) VALUES (3, '2017-07-27 16:43:10', '2017-08-30', '2017-08-30', 800, '0123456', 1, null);
INSERT INTO trabalho_avi.tb_aluguel (id, data_aluguel, data_devolucao, data_entrega, valor_total, cnh_motorista, apolice_seguro, carro_id) VALUES (4, '2017-07-27 17:08:51', '2017-08-30', '2017-08-30', 700, '0123456', 2, 1);