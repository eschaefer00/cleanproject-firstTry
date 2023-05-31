CREATE TABLE users (
    id              uuid          not null,
    mail_address    varchar(255)  not null,
    name            varchar(255),
    password        varchar(255),
    points          int,
    date_registered date          not null,
    constraint pk_users primary key (id)
);


CREATE TABLE category (
     id             uuid        not null,
     description    varchar(255),
     title          varchar(255),
     user_id        uuid        not null,
     constraint pk_category primary key (id)
);


CREATE TABLE todo (
    id uuid not null,
    category_aggregate_id uuid not null,
    deadline date, description varchar(255) not null,
    points int4, priority int4 not null,
    status int4, title varchar(255) not null,
    constraint pk_todo primary key (id)
);

CREATE TABLE scope (
    id uuid not null,
    title varchar(255),
    startDate date not null,
    endDate date not null,
    todoAmount int not null,
    constraint pk_scope primary key (id)
    );


alter table if exists category add constraint FK7ffrpnxaflomhdh0qfk2jcndo foreign key (user_id) references users;

alter table if exists todo add constraint FKlcfm3mng43g9x9x7osuinpwdl foreign key (category_aggregate_id) references category;