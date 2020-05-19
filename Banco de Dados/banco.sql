drop database if exists financeiro;
create database financeiro;
use financeiro;

create table fluxo_de_caixa(
	ID int not null auto_increment primary key,
    credito float,
    debito float,
    nome varchar(45) not null
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
    credito float not null,
    debito float not null,
    nome varchar(45) not null,
    data date not null,
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


