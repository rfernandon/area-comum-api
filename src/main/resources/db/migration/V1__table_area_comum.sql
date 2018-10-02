
begin;

--
-- Create table
--
CREATE SEQUENCE area_omum_seq START WITH 1000;
CREATE TABLE area_comum (
	area_comum_id INTEGER NOT NULL DEFAULT NEXTVAL('area_omum_seq'),
	codigo VARCHAR(20) UNIQUE NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	capacidade INTEGER,
	valor_diaria NUMERIC(11,4),
	dh_cadastro TIMESTAMP NOT NULL,
	hora_abertura TIME NOT NULL,
	hora_encerramento TIME NOT NULL,
	situacao VARCHAR NOT NULL,
	PRIMARY KEY (area_comum_id)
);

commit;
