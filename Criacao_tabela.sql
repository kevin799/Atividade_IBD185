
use banco;
create table ser_servidor (
  ser_id bigint not null auto_increment primary key,
  ser_ip varchar(50) not null,
  ser_nome varchar(50) not null,
  ser_maquina varchar(50) not null,
  ser_processador varchar(50) not null,
  ser_memoria int not null,
  ser_espaco varchar(50) not null,
  ser_status int
);

create table ban_banco (
  ban_id bigint not null auto_increment primary key ,
  ban_nome varchar(50) not null,
  ban_tipo varchar(50) not null,
  ban_versao varchar(50) not null,
  ban_porta int not null,
  ban_desenvolvedor varchar(50) not null,
  ser_id bigint,
  ban_status int
);

ALTER TABLE ban_banco ADD FOREIGN KEY FK_SERV_ID (ser_id) REFERENCES ser_servidor(ser_id);

CREATE TABLE USR_USUARIO (
  USR_ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  USR_NOME VARCHAR(20) NOT NULL,
  USR_SENHA VARCHAR(50) NOT NULL,
  PRIMARY KEY (USR_ID),
  UNIQUE KEY UNI_USUARIO_NOME (USR_NOME)
);

CREATE TABLE AUT_AUTORIZACAO (
  AUT_ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  AUT_NOME VARCHAR(20) NOT NULL,
  PRIMARY KEY (AUT_ID),
  UNIQUE KEY UNI_AUT_NOME (AUT_NOME)
);

CREATE TABLE UAU_USUARIO_AUTORIZACAO (
  USR_ID BIGINT UNSIGNED NOT NULL,
  AUT_ID BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (USR_ID, AUT_ID),
  FOREIGN KEY AUT_USUARIO_FK (USR_ID) REFERENCES USR_USUARIO (USR_ID) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY AUT_AUTORIZACAO_FK (AUT_ID) REFERENCES AUT_AUTORIZACAO (AUT_ID) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE ANT_ANOTACAO (
  ANT_ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  ANT_ASSUNTO VARCHAR(100) NOT NULL,
  ANT_TEXTO VARCHAR(500) NOT NULL,
  ANT_DATA_HORA DATETIME NOT NULL,
  USR_CRIACAO_ID BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (ANT_ID),
  FOREIGN KEY ANT_USR_FK (USR_CRIACAO_ID) REFERENCES USR_USUARIO(USR_ID) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO USR_USUARIO(USR_NOME, USR_SENHA) VALUES('teste', CONCAT('{MD5}', MD5('teste')));
INSERT INTO USR_USUARIO(USR_NOME, USR_SENHA) VALUES('admin', CONCAT('{MD5}', MD5('admin')));
INSERT INTO AUT_AUTORIZACAO(AUT_NOME) VALUES('ROLE_USUARIO');
INSERT INTO AUT_AUTORIZACAO(AUT_NOME) VALUES('ROLE_ADMIN');
INSERT INTO UAU_USUARIO_AUTORIZACAO(USR_ID, AUT_ID)
SELECT USR_ID, AUT_ID
FROM USR_USUARIO, AUT_AUTORIZACAO
WHERE USR_NOME = 'teste'
AND AUT_NOME = 'ROLE_USUARIO';
INSERT INTO UAU_USUARIO_AUTORIZACAO(USR_ID, AUT_ID)
SELECT USR_ID, AUT_ID
FROM USR_USUARIO, AUT_AUTORIZACAO
WHERE USR_NOME = 'admin';

create table ser_servidor_principal (
  ser_id bigint not null auto_increment primary key,
  ser_ip varchar(50) not null,
  ser_nome varchar(50) not null,
  ser_maquina varchar(50) not null,
  ser_processador varchar(50) not null,
  ser_memoria int not null,
  ser_espaco varchar(50) not null,
  ser_status int
);