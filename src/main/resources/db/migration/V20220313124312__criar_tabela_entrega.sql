-- auto-generated definition
create table entrega
(
    id                       bigint auto_increment
        primary key,
    data_finalizacao         datetime(6)   not null,
    data_pedido              datetime(6)  not  null,
    destinatario_bairro      varchar(60)  not null,
    destinatario_complemento varchar(100)  not null,
    destinatario_logradouro  varchar(60)  not null,
    destinatario_nome        varchar(60)  not null,
    destinatario_numero      varchar(20)  not null,
    estatus_entrega          varchar(20)  not null,
    taxa                     decimal(19, 2) not null,
    cliente_id               bigint       not  null,
    constraint FKslojpgj1q1lwu7eytoe8q81mv
        foreign key (cliente_id) references cliente (id)
);
