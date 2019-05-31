-- noinspection SqlResolveForFile

DROP SCHEMA IF EXISTS task CASCADE;

CREATE SCHEMA task;

CREATE TABLE task.departments
(
    id   INTEGER UNIQUE,
    name VARCHAR(50),

    CONSTRAINT departments_pkey PRIMARY KEY (id)
);

CREATE TABLE task.degrees
(
    id    INTEGER UNIQUE,
    title VARCHAR(50) UNIQUE,

    CONSTRAINT degrees_pkey PRIMARY KEY (id)
);

CREATE TABLE task.lectors
(
    id                 SERIAL,
    first_name         VARCHAR(50),
    last_name          VARCHAR(50),
    degree_id          INTEGER,
    salary             DECIMAL,
    head_of_department BOOLEAN,

    CONSTRAINT lectors_degree PRIMARY KEY (id),
    CONSTRAINT lectors_degree_fkey FOREIGN KEY (degree_id) REFERENCES task.degrees (id),
);

CREATE TABLE task.lectors_departments
(
    lector_id     INTEGER REFERENCES task.lectors (id),
    department_id INTEGER REFERENCES task.departments (id),

    CONSTRAINT lectors_departments_pkey PRIMARY KEY (lector_id, department_id)
);
