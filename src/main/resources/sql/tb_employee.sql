-- 员工表
create table tb_employee
(
  id         int(10) auto_increment
    primary key,
  name       varchar(255) null,
  gender     int(1)       null,
  number     varchar(255) null,
  phone      varchar(255) null,
  address    varchar(255) null,
  start_time datetime     null,
  role       varchar(255) null
);