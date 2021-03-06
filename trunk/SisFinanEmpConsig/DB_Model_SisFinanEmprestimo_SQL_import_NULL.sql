create database SisFinanEmpConsig;

use SisFinanEmpConsig;

create table nivel(
niv_cod smallint not null primary key auto_increment,
niv_desc varchar(30) not null);


create table Usuario(
usu_login varchar(25) not null,
usu_senha varchar(10) not null,
usu_gravar boolean null,
usu_foto longblob default null,
niv_cod smallint not null);

alter table usuario add constraint fkniv_cod foreign key (niv_cod) references nivel (niv_cod);

create table Estado(
est_cod smallint not null primary key auto_increment,
est_uf char(2) not null,
est_nome varchar(25) not null);


create table Cidade(
cid_cod int not null primary key auto_increment,
cid_nome varchar(100) not null,
est_cod smallint not null);


alter table Cidade add constraint fkest_cod foreign key (est_cod) references Estado (est_cod);


create table Bairro(
bai_cod bigint not null primary key auto_increment,
bai_nome varchar(100) not null,
cid_cod int not null);


alter table Bairro add constraint fkcid_cod foreign key (cid_cod) references Cidade (cid_cod);


create table Tipo_Log(
tpl_cod smallint not null primary key auto_increment,
tpl_desc varchar(25) not null); 								


create table Logradouro(
log_cod bigint not null primary key auto_increment,
log_desc varchar(200) not null,
log_num smallint not null,
log_compl varchar(30) default null,
bai_cod bigint not null,
tpl_cod smallint not null);


alter table Logradouro add constraint fkbai_cod foreign key (bai_cod) references Bairro (bai_cod);


alter table Logradouro add constraint fktpl_cod foreign key (tpl_cod) references Tipo_Log (tpl_cod);

create table Cliente(
cli_cod integer not null primary key auto_increment
);

create table Contrato(
cont_cod bigint not null primary key auto_increment
);