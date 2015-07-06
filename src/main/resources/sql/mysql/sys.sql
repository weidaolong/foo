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



DROP TABLE IF EXISTS sys_menu;

CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` varchar(10) NOT NULL COMMENT '排序',
  `url` varchar(2000) DEFAULT NULL COMMENT '链接',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
INSERT INTO `sys_menu` (`id`,`parent_id`,`name`,`sort`,`url`,`is_show`,`create_by`,`create_date`,`update_date`,`remarks`) VALUES ('1',NULL,'系统管理','1.1',NULL,'1','foo','2015-07-01 23:27:58','2015-07-01 23:27:58','系统配置管理');


DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `foo`.`sys_role`(`id`,`name`,`enname`,`useable`)VALUES(1,'admin','系统管理员',1);



DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';
INSERT INTO `foo`.`sys_role_menu`(`role_id`,`menu_id`)VALUES(1,1);


