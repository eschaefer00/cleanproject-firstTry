CREATE TABLE usersx (
    id          uuid          not null,
    mail_address       varchar(255)    not null,
    name    varchar(255),
    password    varchar(255),
    points int,
    time_registered date not null,
    constraint pk_users primary key (id)
);


-- CREATE TABLE category (
--     id          uuid          not null,
--     description       varchar(255)    not null,
--     title    varchar(255)    not null,
--     author    varchar    not null,
--     year_of_publication date not null,
--     constraint pk_book primary key (id)
-- );


-- create table category (id uuid not null, description varchar(255), title varchar(255), user_id uuid not null, primary key (id))
-- create table todo (id uuid not null, category_aggregate_id uuid not null, deadline date, description varchar(255) not null, points int4, priority int4 not null, status int4, title varchar(255) not null, primary key (id))
-- create table users (id uuid not null, mail_address varchar(255), name varchar(255), password varchar(255), points int4, time_registered date, primary key (id))
-- alter table if exists category add constraint FK7ffrpnxaflomhdh0qfk2jcndo foreign key (user_id) references users
-- alter table if exists todo add constraint FKlcfm3mng43g9x9x7osuinpwdl foreign key (category_aggregate_id) references category