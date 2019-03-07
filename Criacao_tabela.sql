
use banco;
create table ser_servidor (
  ser_id bigint not null auto_increment primary key,
  ser_ip varchar(50) not null,
  ser_nome varchar(50) not null,
  ser_maquina varchar(50) not null,
  ser_processador varchar(50) not null,
  ser_memoria int not null,
  ser_espaco varchar(50) not null
);

create table ban_banco (
  ban_id bigint not null auto_increment primary key ,
  ban_nome varchar(50) not null,
  ban_tipo varchar(50) not null,
  ban_versao varchar(50) not null,
  ban_porta varchar(50) not null,
  ban_desenvolvedor varchar(50) not null,
  ser_id bigint #,
  #foreign key FK_SER_ID (ser_id)  references bnt_banco_tabela(ser_id)
);

ALTER TABLE ban_banco ADD FOREIGN KEY FK_SERV_ID (ser_id) REFERENCES ser_servidor(ser_id);

