-- noinspection SqlResolveForFile

DROP SCHEMA IF EXISTS task CASCADE;

CREATE SCHEMA task;

CREATE TABLE task.department
(
    id   INTEGER UNIQUE,
    name VARCHAR(50),

    CONSTRAINT department_pkey PRIMARY KEY (id)
);

CREATE TABLE task.degree
(
    id    INTEGER UNIQUE,
    title VARCHAR(50) UNIQUE,

    CONSTRAINT degree_pkey PRIMARY KEY (id)
);

CREATE TABLE task.lector
(
    id                 SERIAL,
    first_name         VARCHAR(50),
    last_name          VARCHAR(50),
    degree_id          INTEGER,
    salary             DECIMAL,
    head_of_department BOOLEAN,

    CONSTRAINT lector_degree PRIMARY KEY (id),
    CONSTRAINT lector_degree_fkey FOREIGN KEY (degree_id) REFERENCES task.degree (id),
);

CREATE TABLE task.lector_department
(
    lector_id     INTEGER REFERENCES task.lector (id),
    department_id INTEGER REFERENCES task.department (id),

    CONSTRAINT lector_department_pkey PRIMARY KEY (lector_id, department_id)
);
