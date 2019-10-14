--liquibase formatted sql

--changeset stacy.cmd:insert-into-company-table
INSERT INTO company (id) VALUES (1);

--changeset stacy.cmd:insert-into-address-table
INSERT INTO address (city, street, house) VALUES ('Краснодар', 'Красноармейская', '106');

--changeset stacy.cmd:insert-into-vacancy-table
INSERT INTO vacancy
    (type, description, experience, company_id)
VALUES
    ('BACKEND_DEVELOPER', 'Необходим опытный java-разработчик на полную ставку', '2 года', 1);