INSERT INTO public.user_app (id, birth_date, cpf, email, marital_status, name, password, gender)
VALUES (1, '1991-09-27', '09355872925', 'email@email.com', 'SOLTEIRO', 'Responsável', null, 'MASCULINO');

INSERT INTO public.user_app (id, birth_date, cpf, email, marital_status, name, password, gender)
VALUES (2, '1987-05-13', '09355872924', 'email2@email.com', 'SOLTEIRO', 'Outro Responsável', null, 'MASCULINO');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
