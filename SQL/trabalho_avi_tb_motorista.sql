CREATE TABLE trabalho_avi.tb_motorista
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(200),
    data_nascimento date,
    cpf varchar(20),
    num_cnh varchar(20),
    sexo varchar(10)
);
CREATE UNIQUE INDEX tb_motorista_id_uindex ON trabalho_avi.tb_motorista (id);
INSERT INTO trabalho_avi.tb_motorista (id, nome, data_nascimento, cpf, num_cnh, sexo) VALUES (1, 'Marco Motorista', '1992-04-14', '', '0123456', 'M');
INSERT INTO trabalho_avi.tb_motorista (id, nome, data_nascimento, cpf, num_cnh, sexo) VALUES (2, 'Marco Motora', '1992-02-14', '', '1234567', 'M');