drop table if exists ss_team;

create table ss_team (
  	id bigint auto_increment,
	name varchar(255) not null,
	master_id bigint,
    primary key (id)
) engine=InnoDB;