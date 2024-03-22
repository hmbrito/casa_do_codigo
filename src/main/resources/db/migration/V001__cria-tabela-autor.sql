CREATE TABLE
    autor
(
    id            SERIAL,
    nome          VARCHAR(60)  NOT NULL,
    email         VARCHAR(60)  NOT NULL,
    descricao     VARCHAR(400) NOT NULL,
    data_registro TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);