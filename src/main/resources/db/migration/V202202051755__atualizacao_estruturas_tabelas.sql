ALTER TABLE Address
    ADD isMain BOOLEAN;

ALTER TABLE Address
    ADD userApp_id BIGINT;

ALTER TABLE Address
    ALTER COLUMN isMain SET NOT NULL;

ALTER TABLE Phone
    ADD userApp_id BIGINT;

ALTER TABLE Treatment
    ADD COLUMN patient_id BIGINT;

ALTER TABLE Treatment
    ADD CONSTRAINT FK_TREATMENT_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES Patient (id);

ALTER TABLE Address
    ADD CONSTRAINT FK_ADDRESS_ON_USERAPP FOREIGN KEY (userApp_id) REFERENCES user_app (id);

ALTER TABLE Phone
    ADD CONSTRAINT FK_PHONE_ON_USERAPP FOREIGN KEY (userApp_id) REFERENCES user_app (id);

ALTER TABLE phone
    DROP CONSTRAINT fk3o48ec26lujl3kf01hwqplhn2;

ALTER TABLE address
    DROP CONSTRAINT fk7156ty2o5atyuy9f6kuup9dna;

ALTER TABLE address
    DROP COLUMN is_main;

ALTER TABLE address
    DROP COLUMN user_id;

ALTER TABLE treatment
    DROP COLUMN observation;

ALTER TABLE phone
    DROP COLUMN user_id;

ALTER TABLE Phone
    ALTER COLUMN is_main SET NOT NULL;

ALTER TABLE Disease
    ALTER COLUMN observation TYPE VARCHAR(255) USING (observation::VARCHAR(255));

ALTER TABLE Patient
    DROP COLUMN responsible_id;

ALTER TABLE Patient
    ADD responsible_id BIGINT;

ALTER TABLE Patient
    ADD CONSTRAINT FK_PATIENT_ON_RESPONSIBLE FOREIGN KEY (responsible_id) REFERENCES user_app (id);

ALTER TABLE Disease
    ALTER COLUMN symptoms TYPE VARCHAR(255) USING (symptoms::VARCHAR(255));
