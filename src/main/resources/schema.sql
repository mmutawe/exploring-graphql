drop table if exists customers;

create table customers
(
    id         BIGINT auto_increment primary key,
    first_name varchar(255) not null,
    last_name   varchar(255) not null
);