-- 每份订单中的商品详情表
create table tb_order_detail
(
  id                int(10) auto_increment
    primary key,
  product_id        int(10)                          null,
  order_id          int(10)                          not null,
  product_name      varchar(255)                     not null,
  product_desc      varchar(255) default '此商品暂时没有描述' null,
  product_price     double                           null,
  product_amount    int(10)                          null,
  amount_of_money   double                           null comment '小计金额',
  is_product_exists int(4)                           null,
  constraint tb_order_detail_tb_order_id_fk
    foreign key (order_id) references tb_order (id)
);


