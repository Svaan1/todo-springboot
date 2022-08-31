CREATE TABLE todo
(
    id serial NOT NULL,
    description text NOT NULL,
    is_complete boolean NOT NULL,
    PRIMARY KEY (id)
);
