use banco;

create table bnt_banco_tabela(
	ban_id bigint unsigned not null,
    tab_id bigint unsigned not null,
    primary key (ban_id,tab_id)
);

create table ser_servidor (
  ser_id bigint unsigned not null auto_increment,
  ser_ip varchar(50) not null,
  ser_nome varchar(50) not null,
  ser_maquina varchar(50) not null,
  ser_processador varchar(50) not null,
  ser_memoria int not null,
  ser_espaco varchar(50) not null,
  primary key (ser_id),
  unique key uni_ser_ip (ser_ip)
);

create table ban_banco (
  ban_id bigint unsigned not null auto_increment,
  ban_nome varchar(50) not null,
  ban_tipo varchar(50) not null,
  ban_versao varchar(50) not null,
  ban_porta varchar(50) not null,
  ban_desenvolvedor varchar(50) not null,
  primary key (ban_id),
  unique key uni_ban_nome (ban_nome)
);

create table tab_tabela (
  tab_id bigint unsigned not null auto_increment,
  tab_nome varchar(50) not null,
  primary key (tab_id),
  unique key uni_tab_nome (tab_nome)
);

create table seb_servidor_banco (
  ban_id bigint unsigned not null,
  ser_id bigint unsigned not null,
  primary key (ban_id,SER_ID)
);


