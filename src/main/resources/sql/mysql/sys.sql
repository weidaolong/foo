DROP TABLE IF EXISTS sys_user;
create table sys_user (
	id bigint auto_increment ,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64),
	roles varchar(255),
	register_date datetime,
	primary key (id)
) engine=InnoDB  DEFAULT CHARSET=utf8  ;

insert into sys_user (login_name, name, password, salt, roles,register_date) values('foo','foo','2e6013e4dca19cf02983bb16998e950b27f1f74a','d7c1ce98702d7553','user','2015-07-01 23:25:42');
insert into sys_user (login_name, name, password, salt, roles,register_date) VALUES ('zhangsan','zhangsan','e4358adb95a4db63e8bbea1384a37dda09db6a4d','82631ef48db81d16','user','2015-07-01 23:27:58');