drop database if exists financeiro;
create database financeiro;
use financeiro;

SET GLOBAL log_bin_trust_function_creators = 1;
SET SQL_SAFE_UPDATES = 0;

create table fluxo_de_caixa(
	ID int not null auto_increment primary key,
    credito float,
    debito float,
    nome varchar(45) not null,
    data varchar(45) not null
);

create table contas_a_pagar(
	ID int not null auto_increment primary key,
    fornecedor varchar(45) not null,
    contas_a_pagar float not null,
    contas_pagas float not null,
    data varchar(45) not null,
    fk_idfluxo int,
    constraint fk1 
		foreign key (fk_idfluxo) references fluxo_de_caixa(ID) on update cascade
);
SELECT * FROM contas_a_pagar;

create table contas_a_receber(
	ID int not null auto_increment primary key,
    cliente varchar(45) not null,
    contas_a_receber float not null,
    contas_recebidas float not null,
    data varchar(45) not null,
    fk_idfluxo int,
    constraint fk2 
		foreign key (fk_idfluxo) references fluxo_de_caixa(ID) on update cascade
);
SELECT * FROM contas_a_receber;

create table relatorio(
	ID int not null auto_increment primary key,
    credito float,
    debito float,
    nome varchar(45) not null,
    data varchar(45) not null,
    fk_idfluxo int,
    constraint fk3 
		foreign key (fk_idfluxo) references fluxo_de_caixa(ID)
);

create table gestao_de_custo(
	ID int not null auto_increment primary key,
    nome varchar(45) not null,
    valor float not null,
    fk_idfluxo int,
    constraint fk4
		foreign key (fk_idfluxo) references fluxo_de_caixa(ID) on update cascade
);

create table extrato(
	ID int not null auto_increment primary key,
    nome varchar(45) not null,
    valor_de_entrada float not null,
    valor_de_saida float not null,
    fk_idfluxo int,
    constraint fk5
		foreign key (fk_idfluxo) references fluxo_de_caixa(ID) on update cascade
);

create table extrato_has_contas_a_pagar(
	fk_extrato int,
    fk_contas_a_pagar int,
    constraint fk6
		foreign key (fk_extrato) references extrato(ID) on update cascade,
	constraint fk7
		foreign key(fk_contas_a_pagar) references contas_a_pagar(ID) on update cascade
);

create table extrato_has_contas_a_receber(
	fk_extrato int,
    fk_contas_a_receber int,
    constraint fk8
		foreign key (fk_extrato) references extrato(ID) on update cascade,
	constraint fk9
		foreign key(fk_contas_a_receber) references contas_a_receber(ID) on update cascade
);

delimiter $$
drop function if exists  Registro $$
create function Registro(data_fluxo varchar(45))# returns varchar(20)
begin
    declare credito_r float;
    declare debito_r float;
    declare nome_r varchar(45);
    declare fk_idfluxo_r int;
    declare retorno varchar(20);
    
	SET fk_idfluxo_r = (SELECT ID from fluxo_de_caixa Where data = data_fluxo);
    SET credito_r = (SELECT credito from fluxo_de_caixa Where data = data_fluxo);
    SET debito_r = (SELECT debito from fluxo_de_caixa Where data = data_fluxo);
    SET nome_r = (SELECT nome from fluxo_de_caixa Where data = data_fluxo);
    
    INSERT INTO relatorio(credito, debito, nome, fk_idfluxo, data) VALUES (credito_r, debito_r, nome_r, fk_idfluxo_r, data_fluxo);
	
    #SET retorno = 'Estoque atualizado';
    #return (retorno);
end$$
delimiter ;

#INSERT INTO fluxo_de_caixa (credito, debito, nome, data) values ('200','0','teste1','27/05/2020');
#SELECT * FROM fluxo_de_caixa;
#SELECT Registro('27/05/2020') FROM fluxo_de_caixa;
#SELECT * FROM relatorio;

