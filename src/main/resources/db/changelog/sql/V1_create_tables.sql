--liquibase formatted sql

--changeset stacy.cmd:create-company-table
CREATE TABLE IF NOT EXISTS company (
  id BIGSERIAL PRIMARY KEY NOT NULL
);
--rollback DROP TABLE company

--changeset stacy.cmd:create-address-table
CREATE TABLE IF NOT EXISTS address (
  company_id BIGSERIAL PRIMARY KEY NOT NULL,
  city VARCHAR(255) NOT NULL,
  street VARCHAR(255) NOT NULL,
  house VARCHAR(255) NOT NULL
);
--rollback DROP TABLE
--rollback vacancy

--changeset stacy.cmd:one-to-one-company-address
ALTER TABLE address ADD CONSTRAINT address_company_id_fk FOREIGN KEY (company_id) REFERENCES company(id);

--changeset stacy.cmd:create-vacancy-table
CREATE TABLE IF NOT EXISTS vacancy (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  type VARCHAR(255) NOT NULL,
  description VARCHAR NOT NULL,
  experience VARCHAR(255) NOT NULL,
  published_at_date DATE DEFAULT CURRENT_DATE,
  published_at_time TIME DEFAULT CURRENT_TIME,
  published_at_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  company_id BIGINT NOT NULL
);
--rollback DROP TABLE
--rollback vacancy

--changeset stacy.cmd:one-to-many-company-vacancy
ALTER TABLE vacancy ADD CONSTRAINT vacancy_company_id_fk FOREIGN KEY (company_id) REFERENCES company(id);