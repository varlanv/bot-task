INSERT INTO task.department (id, name)
VALUES (1,'History'),
       (2,'Art'),
       (3,'Chemistry'),
       (4,'Technology'),
       (5,'Biology');

INSERT INTO task.degree (id, title)
VALUES (1,'assistant'),
       (2,'associate professor'),
       (3,'professor');

INSERT INTO task.lector (first_name, last_name, degree_id, salary, head_of_department)
VALUES ('Richard', 'Stallman', 2, 12500, false),
       ('Doug', 'Lea', 3, 14300, true),
       ('Richard', 'Dawkings', 3, 10000, true),
       ('William', 'Hamilton', 2, 9000, false),
       ('Ian', 'Morris', 1, 8000, false),
       ('Nora', 'Boyce', 1, 9000, false),
       ('Paul', 'Edwards', 2, 11000, false),
       ('Martin', 'Kemp', 3, 12000, true),
       ('Susan', 'King', 3, 13000, true),
       ('Gregory', 'Weiss', 1, 10000, false);

INSERT INTO task.lector_department (lector_id, department_id)
VALUES (1, 4),
       (2, 4),
       (3, 5),
       (4, 2),
       (5, 1),
       (6, 3),
       (7, 2),
       (8, 2),
       (9, 3),
       (10, 3);
