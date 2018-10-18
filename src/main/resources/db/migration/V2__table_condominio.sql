
begin;

--
-- Create table
--
CREATE SEQUENCE condominio_seq START WITH 1000;
CREATE TABLE condominio (
	condominio_id INTEGER NOT NULL DEFAULT NEXTVAL('condominio_seq'),
	PRIMARY KEY (condominio_id)
);

ALTER TABLE area_comum ADD COLUMN condominio_id INTEGER;

commit;
