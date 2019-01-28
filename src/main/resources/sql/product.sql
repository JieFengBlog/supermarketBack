create table tb_product
(
  id           int(4) auto_increment
    primary key,
  product_name varchar(255)      null,
  product_num  int(10) default 0 null,
  constraint tb_product_product_name_uindex
    unique (product_name)
);