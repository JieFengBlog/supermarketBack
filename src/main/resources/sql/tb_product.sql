-- 商品表
create table tb_product
(
  id             int(10) auto_increment
    primary key,
  name           varchar(255)                      not null,
  product_desc   varchar(255) default '此商品还没有添加描述' null,
  price          double                            not null,
  category_id    int(10)                           not null,
  stock          int(10)      default 0            null,
  provide        varchar(255)                      not null,
  status         int(1)       default 0            null comment '0 下架  1 上架',
  create_time    datetime                          null,
  last_edit_time datetime                          null,
  unit           varchar(255)                      null,
  constraint tb_product_name_uindex
    unique (name)
);