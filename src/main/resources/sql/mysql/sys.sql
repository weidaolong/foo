DROP TABLE IF EXISTS `sys_user`;
create table sys_user (
	id bigint auto_increment COMMENT '编号',
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64),
	roles varchar(255),
	register_date timestamp not null default 0,
	primary key (id)
) engine=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户表' ;

insert into `sys_user` ( `login_name`, `name`, `password`, `salt`, `roles`) values('zhangsan','zhangsan','zhangsan','zhangsan','1');