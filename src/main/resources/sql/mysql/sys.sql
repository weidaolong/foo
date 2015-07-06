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


DROP TABLE IF EXISTS sys_resources;

CREATE TABLE `sys_resources` (
  `id` VARCHAR(64) NOT NULL COMMENT '编号',
  `parent_id` VARCHAR(64) COMMENT '父级编号',
  `name` VARCHAR(100) NOT NULL COMMENT '名称',
  `url` VARCHAR(2000) DEFAULT NULL COMMENT '链接',
  `resources_type` CHAR(1) NOT NULL COMMENT '资源类型',
  `remarks` VARCHAR(255)  COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='资源表';
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('1','root','系统管理',NULL,'M','系统配置管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('2','root','个人管理',NULL,'M','个人配置管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('1.1','1','资源管理','/resourcesManger','M','资源管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('1.2','1','角色管理','/rolesManager','M','角色管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('1.3','1','操作管理','/operatorManager','M','操作管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('2.1','2','头像信息','/photoManager','M','头像管理');
INSERT INTO `sys_resources` (`id`,`parent_id`,`name`,`url`,`resources_type`,`remarks`) VALUES ('2.2','2','基本资料信息','/personalManager','M','基本资料管理');