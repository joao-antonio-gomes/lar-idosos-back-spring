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

create table role
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table user_app
(
    id             bigserial
        primary key,
    birth_date     date,
    cpf            varchar(255),
    email          varchar(255),
    gender         varchar(255),
    marital_status varchar(255),
    name           varchar(255),
    password       varchar(255)
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
    user_app_id   bigint
        constraint fkg6fj34gmtnxpxv5rm48rou0j4
            references user_app
);

create table patient
(
    id             bigserial
        primary key,
    birth_date     date,
    cpf            varchar(255),
    gender         varchar(255),
    marital_status varchar(255),
    name           varchar(255),
    responsible_id bigint
        constraint fke2e26iw3is4yxua1pttx70yt8
            references user_app
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

create table phone
(
    id          bigserial
        primary key,
    ddd         varchar(255),
    is_main     boolean,
    number      varchar(255),
    phone_type  varchar(255),
    user_app_id bigint
        constraint fkm2oly3xdnjc4ljysyao3osy96
            references user_app
);

create table treatment
(
    id         bigserial
        primary key,
    begin_date date,
    end_date   date,
    status     varchar(255),
    disease_id bigint
        constraint fk7ksbg53yrtxj8byaax4ri79e5
            references disease,
    patient_id bigint
        constraint fkjpqauh9f08891a82no3i8aq7o
            references patient
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
    is_applied            boolean,
    observation           varchar(255),
    treatment_medicine_id bigint
        constraint fkjaqtj27spndi0l687i59ybkyc
            references treatment_medicine
);

create table users_roles
(
    user_id bigint not null
        constraint fk50gpsre6oxwwqf394f8wov1yf
            references user_app,
    role_id bigint not null
        constraint fkt4v0rrweyk393bdgt107vdx0x
            references role
);

