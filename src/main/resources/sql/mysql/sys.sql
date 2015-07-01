DROP TABLE IF EXISTS sys_user;
create table sys_user (
	id bigint auto_increment ,
	logins_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64),
	roles varchar(255),
	primary key (id)
) engine=InnoDB  DEFAULT CHARSET=utf8  ;

insert into sys_user (logins_name, name, password, salt, roles) values('foo','foo','2e6013e4dca19cf02983bb16998e950b27f1f74a','d7c1ce98702d7553','user');
