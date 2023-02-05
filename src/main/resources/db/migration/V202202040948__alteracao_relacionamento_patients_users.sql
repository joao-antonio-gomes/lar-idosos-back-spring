drop table users_patients;

alter table patient add column responsible_id int;
alter table patient add constraint fk_patient_user foreign key (responsible_id) references user_app(id);
