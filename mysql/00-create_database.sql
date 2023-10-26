BEGIN;

CREATE TABLE IF NOT EXISTS profissao(
    id integer NOT NULL PRIMARY KEY,
    descricao varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS candidato(
    id integer NOT NULL PRIMARY KEY,
    nome varchar(255) NOT NULL,
    contacto varchar(255) NOT NULL,
    idade integer NOT NULL,
    morada varchar(255),
    profissao_id integer references profissao(id)
);

-- Insert profissoes
INSERT INTO profissao (id, descricao) VALUES (1, 'ESTUDANTE');
INSERT INTO profissao (id, descricao) VALUES (2, 'DESEMPREGADO');
INSERT INTO profissao (id, descricao) VALUES (3, 'TRABALHADOR_OUTREM');
INSERT INTO profissao (id, descricao) VALUES (4, 'TRABALHADOR_PROPRIA');
INSERT INTO profissao (id, descricao) VALUES (5, 'OUTRO');

COMMIT;

