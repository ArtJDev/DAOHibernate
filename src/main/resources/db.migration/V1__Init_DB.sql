create table persons
(
    id             bigint not null,
    age            integer,
    city_of_living varchar(255),
    name           varchar(255),
    phone_number   varchar(255),
    surname        varchar(255),
    primary key (id)
);