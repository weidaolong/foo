DROP TABLE IF EXISTS `sys_user`;
create table sys_user (
	ID INT PRIMARY KEY ,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64),
	roles varchar(255)
)  ;
insert into `sys_user` (`id`, `login_name`, `name`, `password`, `salt`, `roles`) values(1,'zhangsan','zhangsan','zhangsan','zhangsan','1');