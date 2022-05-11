drop table if exists customers;

create table customers
(
    id         BIGINT  primary key,
    first_name varchar(255) not null,
    last_name   varchar(255) not null
);