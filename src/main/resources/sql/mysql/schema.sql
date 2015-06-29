drop table if exists team;

create table team (
  	id bigint auto_increment,
	name varchar(255) not null,
	master_id bigint,
    primary key (id)
) engine=InnoDB;