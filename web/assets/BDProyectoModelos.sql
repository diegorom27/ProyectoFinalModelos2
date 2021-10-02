/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 20-feb.-2021 06:15:41 p. m. 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS Hechizo CASCADE
;

DROP TABLE IF EXISTS Personaje CASCADE
;

DROP TABLE IF EXISTS Personaje_Hechizo CASCADE
;

/* Create Tables */

CREATE TABLE Hechizo
(
	n_nombre varchar(50) NOT NULL,
	i_tipo varchar(50) NOT NULL,
	q_gastoMana integer NOT NULL,
	q_sacrificio integer NOT NULL,
	q_curacion integer NOT NULL,
	q_efectoMultiplicador numeric(4,2) NOT NULL,
	q_efecto integer NOT NULL,
	n_foto varchar(50) NOT NULL
)
;

CREATE TABLE Personaje
(
	n_nombrePersonaje varchar(50) NOT NULL,
	q_vida integer NOT NULL,
	q_ataque integer NOT NULL,
	q_mana integer NOT NULL,
	n_foto varchar(50) NOT NULL,
	n_estilo varchar(50) NOT NULL
)
;

CREATE TABLE Personaje_Hechizo
(
	k_idPersonaje integer NOT NULL,
	k_idHechizo integer NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

--ALTER TABLE Hechizo ADD CONSTRAINT PK_Hechizo
--	PRIMARY KEY (k_idHechizo)
--;
ALTER TABLE Hechizo ADD COLUMN k_idHechizo SERIAL PRIMARY KEY;

--ALTER TABLE Personaje ADD CONSTRAINT PK_Personaje
--	PRIMARY KEY (k_idPersonaje)
--;
ALTER TABLE Personaje ADD COLUMN k_idPersonaje SERIAL PRIMARY KEY;

ALTER TABLE Personaje_Hechizo ADD CONSTRAINT PK_Personaje_Hechizo
	PRIMARY KEY (k_idPersonaje,k_idHechizo)
;

CREATE INDEX IXFK_Personaje_Hechizo_Hechizo ON Personaje_Hechizo (k_idHechizo ASC)
;

CREATE INDEX IXFK_Personaje_Hechizo_Personaje ON Personaje_Hechizo (k_idPersonaje ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE Personaje_Hechizo ADD CONSTRAINT FK_Personaje_Hechizo_Hechizo
	FOREIGN KEY (k_idHechizo) REFERENCES Hechizo (k_idHechizo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Personaje_Hechizo ADD CONSTRAINT FK_Personaje_Hechizo_Personaje
	FOREIGN KEY (k_idPersonaje) REFERENCES Personaje (k_idPersonaje) ON DELETE No Action ON UPDATE No Action
;
