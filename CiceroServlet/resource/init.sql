/*
create table contato (
	id bigint not null auto_increment,
	nome varchar(255),
	email varchar(255),
	endereco varchar(255),
	data_nascimento date,
	primary key (id)
);

insert into contato (nome, email, endereco, data_nascimento) 
values ('Teste 01', 'teste01@gmail.com', 'rua fulano de tal', STR_TO_DATE ('1982-02-01', '%Y-%m-%d') );
*/

select * from cicerodb.contato;