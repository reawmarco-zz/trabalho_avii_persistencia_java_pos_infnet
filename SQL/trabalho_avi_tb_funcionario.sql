CREATE TABLE trabalho_avi.tb_funcionario
(
    cpf varchar(20) NOT NULL,
    nome varchar(200),
    num_matricula int(11),
    sexo char(1),
    data_nascimento date,
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE UNIQUE INDEX tb_funcionario_id_uindex ON trabalho_avi.tb_funcionario (id);
INSERT INTO trabalho_avi.tb_funcionario (cpf, nome, num_matricula, sexo, data_nascimento, id) VALUES ('', 'Marco Funcionario', 0, 'M', '1992-04-14', 1);
INSERT INTO trabalho_avi.tb_funcionario (cpf, nome, num_matricula, sexo, data_nascimento, id) VALUES ('12345', 'Marco Funcionario', 1234567890, 'M', '1992-05-14', 2);
INSERT INTO trabalho_avi.tb_funcionario (cpf, nome, num_matricula, sexo, data_nascimento, id) VALUES ('', 'Marco', 123456, 'M', '1992-12-14', 3);