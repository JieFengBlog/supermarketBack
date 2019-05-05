-- 管理员账户表
create table tb_validation
(
  id       int(10) auto_increment
    primary key,
  username varchar(255) null,
  password varchar(255) null,
  constraint tb_validation_username_uindex
    unique (username)
);