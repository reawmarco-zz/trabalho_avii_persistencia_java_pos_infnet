create table carro_acessorios
(
	id_carro int null,
	id_acessorio int null
)
;

create table tb_acessorio
(
	id int auto_increment
		primary key,
	descricao varchar(250) null
)
;

create table tb_aluguel
(
	id int auto_increment
		primary key,
	data_aluguel datetime null,
	data_devolucao date null,
	data_entrega date null,
	valor_total double null,
	cnh_motorista varchar(20) null,
	apolice_seguro int null,
	carro_id int null,
	constraint tb_aluguel_id_uindex
		unique (id)
)
;

create table tb_apolice
(
	id_apolice_seguro int auto_increment
		primary key,
	valor_franquia decimal null,
	protecao_terceiros tinyint(1) null,
	protecao_causas_naturais tinyint(1) null,
	protecao_roubo tinyint(1) null,
	constraint tb_apolice_id_apolice_seguro_uindex
		unique (id_apolice_seguro)
)
;

create table tb_carro
(
	id int auto_increment
		primary key,
	placa varchar(7) null,
	chassi varchar(20) null,
	cor varchar(15) null,
	valor_diaria decimal null,
	modelo_carro_id int null,
	constraint tb_carro_id_uindex
		unique (id)
)
;

create table tb_fabricante
(
	id int auto_increment
		primary key,
	nome varchar(50) null
)
;

create table tb_funcionario
(
	cpf varchar(20) not null,
	nome varchar(200) null,
	num_matricula int null,
	sexo char null,
	data_nascimento date null,
	id int auto_increment
		primary key,
	constraint tb_funcionario_id_uindex
		unique (id)
)
;

create table tb_modelo_carro
(
	id int auto_increment
		primary key,
	descricao varchar(300) null,
	fabricante_id int null,
	categoria varchar(50) null,
	constraint tb_modelo_carro_id_uindex
		unique (id)
)
;

create table tb_motorista
(
	id int auto_increment
		primary key,
	nome varchar(200) null,
	data_nascimento date null,
	cpf varchar(20) null,
	num_cnh varchar(20) null,
	sexo varchar(10) null,
	constraint tb_motorista_id_uindex
		unique (id)
)
;

