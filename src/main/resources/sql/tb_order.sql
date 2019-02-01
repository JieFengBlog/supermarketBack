-- auto-generated definition
create table tb_order
(
  id              int(10) auto_increment
    primary key,
  order_number    varchar(255)      not null comment '"订单编号"',
  order_price     double            not null,
  order_provide   varchar(255)      null,
  user_id         int(10)           null comment '订单的消费者',
  order_status    int(10) default 0 null comment '0 未结账 1 已结账',
  order_type      int(4)            not null comment '0 进货订单 1 出货订单',
  create_time     datetime          null,
  settlement_time datetime          null comment '订单结算时间',
  constraint tb_order_order_number_uindex
    unique (order_number)
);
