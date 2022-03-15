-- auto-generated definition
create table ocorrencia
(
    id            bigint auto_increment
        primary key,
    data_registro datetime(6) not null,
    descricao     varchar(20) not null,
    entrega_id    bigint      not null,
    constraint FKj41wa4v81bo2xkg4xgc3knae
        foreign key (entrega_id) references entrega (id)
);

