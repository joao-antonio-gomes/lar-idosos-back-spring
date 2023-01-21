create table client
(
    id             bigserial
        primary key,
    birth_date     date,
    cpf            varchar(255),
    email          varchar(255),
    marital_status varchar(255),
    name           varchar(255),
    password       varchar(255),
    gender            varchar(255)
);

create table treatment
(
    id         bigserial
        primary key,
    begin_date date,
    end_date   date
);

create table disease
(
    id          bigserial
        primary key,
    name        varchar(255),
    observation varchar(255),
    symptoms    varchar(255)
);

create table medicine
(
    id             bigserial
        primary key,
    concentration  integer,
    description    varchar(255),
    name           varchar(255),
    stock_quantity integer,
    type           varchar(255)
);

create table patient
(
    id             bigserial
        primary key,
    birth_date     date,
    cpf            varchar(255),
    marital_status varchar(255),
    name           varchar(255),
    gender            varchar(255)
);

create table privilege
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table role
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table address
(
    id            bigserial
        primary key,
    address       varchar(255),
    city          varchar(255),
    complement    varchar(255),
    is_main       boolean not null,
    neightborhood varchar(255),
    number        varchar(255),
    observation   varchar(255),
    state         varchar(255),
    client_id     bigint
        constraint fk7156ty2o5atyuy9f6kuup9dna
            references client
);

create table allergy
(
    id          bigserial
        primary key,
    name        varchar(255),
    observation varchar(255),
    patient_id  bigint
        constraint fkg2ytn0t43rqrd6ag29e9hiowq
            references patient
);

create table clients_patients
(
    client_id  bigint not null
        constraint fkl5yya5fsu94rf4wfpknm2uv8c
            references client,
    patient_id bigint not null
        constraint fkh4sctbprvhm9skfvxj03hnofn
            references patient
);

create table phone
(
    id         bigserial
        primary key,
    ddd        varchar(255),
    is_main    boolean,
    number     varchar(255),
    phone_type varchar(255),
    client_id  bigint
        constraint fk3o48ec26lujl3kf01hwqplhn2
            references client
);

create table clients_roles
(
    client_id bigint not null
        constraint fk3ius7lc7bbc7gpnb0vu06f33i
            references client,
    role_id   bigint not null
        constraint fkkfcfwda19us7p99v56k2e5fkm
            references role
);

create table roles_privileges
(
    role_id      bigint not null
        constraint fk9h2vewsqh8luhfq71xokh4who
            references role,
    privilege_id bigint not null
        constraint fk5yjwxw2gvfyu76j3rgqwo685u
            references privilege
);

create table treatment_medicine
(
    id               bigserial
        primary key,
    begin_date       date,
    begin_hour       time,
    dosage           integer,
    end_date         date,
    minutes_interval integer,
    medicine_id      bigint
        constraint fk4fwhe02xrcfgrus7e07ayxdce
            references medicine,
    treatment_id     bigint
        constraint fkjv6if18ujlp75b2rsxo4v5f09
            references treatment
);

create table medicine_application
(
    id                    bigserial
        primary key,
    date                  date,
    hour                  time,
    is_applied            boolean not null,
    observation           varchar(255),
    treatment_medicine_id bigint
        constraint fkjaqtj27spndi0l687i59ybkyc
            references treatment_medicine
);

create table treatments_diseases
(
    treatment_id bigint not null
        constraint fkjt92q9yy1drlrpkc45jm069rd
            references treatment,
    disease_id   bigint not null
        constraint fkjvsx7ti9cr2oaeumos7pmceww
            references disease
);

