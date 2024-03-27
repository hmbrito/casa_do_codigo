CREATE TABLE
    autor
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(60)  NOT NULL,
    email         VARCHAR(60)  NOT NULL UNIQUE,
    descricao     VARCHAR(400) NOT NULL,
    data_registro TIMESTAMP    NOT NULL
);