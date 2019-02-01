-- auto-generated definition
create table tb_user
(
  id            int(4) auto_increment
    primary key,
  username      varchar(255) not null,
  password      varchar(255) not null,
  phone         varchar(255) null,
  email         varchar(255) null,
  address       varchar(255) null,
  role          int(2)       not null comment '0 普通用户  1 管理员',
  user_status   int(2)       null comment '0 封禁 1 正常',
  register_time datetime     null,
  constraint tb_user_phone_uindex
    unique (phone),
  constraint tb_user_username_uindex
    unique (username)
);
