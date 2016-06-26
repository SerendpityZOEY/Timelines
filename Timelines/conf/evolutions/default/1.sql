# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table post (
  user_id                   integer,
  content                   varchar(255),
  author                    varchar(255),
  text                      varchar(255))
;

create table task (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  done                      tinyint(1) default 0,
  constraint pk_task primary key (id))
;

create table user (
  id                        integer auto_increment not null,
  name                      varchar(100),
  constraint pk_user primary key (id))
;

alter table post add constraint fk_post_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_post_user_1 on post (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table post;

drop table task;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

