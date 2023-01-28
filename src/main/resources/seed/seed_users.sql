INSERT INTO public.user_app (id, birth_date, cpf, email, marital_status, name, password, gender)
VALUES (1, '1991-09-27', '09355872925', 'email@email.com', 'SOLTEIRO', 'Responsável', null, 'MASCULINO');

INSERT INTO public.users_roles (user_id, role_id)
VALUES (1, 2);

