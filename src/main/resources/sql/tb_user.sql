-- 用户表
create table tb_user
(
  id            int(4) auto_increment
    primary key,
  name          varchar(255) not null,
  phone         varchar(255) null,
  email         varchar(255) null,
  address       varchar(255) null,
  user_status   int(2)       null comment '0 已被删除 1 正常',
  register_time datetime     null
);

