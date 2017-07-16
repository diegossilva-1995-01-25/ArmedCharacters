CREATE DATABASE armedcharacters;
USE armedcharacters;


CREATE TABLE fabricante (
  id INTEGER UNSIGNED  NOT NULL  ,
  nome VARCHAR(255)  NOT NULL  ,
  origem VARCHAR(255)  NULL  ,
  anoFundacao INTEGER UNSIGNED  NULL  ,
  fundador VARCHAR(255)  NULL    ,
PRIMARY KEY(id));



CREATE TABLE obra (
  id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  titulo VARCHAR(255)  NOT NULL  ,
  ano INTEGER UNSIGNED  NULL  ,
  genero VARCHAR(255)  NULL    ,
PRIMARY KEY(id));



CREATE TABLE calibre (
  id INTEGER UNSIGNED  NOT NULL  ,
  nome VARCHAR(255)  NOT NULL  ,
  tipoMunicao VARCHAR(255)  NULL  ,
  diametroProjetil DOUBLE  NULL  ,
  comprimento DOUBLE  NULL    ,
PRIMARY KEY(id));



CREATE TABLE serie (
  id INTEGER UNSIGNED  NOT NULL  ,
  titulo VARCHAR(255)  NOT NULL  ,
  ano INTEGER UNSIGNED  NULL  ,
  genero VARCHAR(255)  NULL  ,
  distribuidora VARCHAR(255)  NULL  ,
  franquia VARCHAR(255)  NULL  ,
  numEpisodios INTEGER UNSIGNED  NULL  ,
  numTemporadas INTEGER UNSIGNED  NULL  ,
  tipoSerie VARCHAR(255)  NULL    ,
PRIMARY KEY(id)  ,
INDEX Serie_FKIndex1(id),
  FOREIGN KEY(id)
    REFERENCES obra(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE obraEscrita (
  id INTEGER UNSIGNED  NOT NULL  ,
  titulo VARCHAR(255)  NOT NULL  ,
  ano INTEGER UNSIGNED  NULL  ,
  genero VARCHAR(255)  NULL  ,
  tituloTraduzido VARCHAR(255)  NULL  ,
  autor VARCHAR(255)  NULL  ,
  tipoObraEscrita VARCHAR(255)  NULL  ,
  editora VARCHAR(255)  NULL    ,
PRIMARY KEY(id)  ,
INDEX obraEscrita_FKIndex1(id),
  FOREIGN KEY(id)
    REFERENCES obra(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE personagem (
  id INTEGER UNSIGNED  NOT NULL  ,
  nome VARCHAR(255)  NOT NULL  ,
  dataNasc DATE  NULL  ,
  origem VARCHAR(255)  NULL  ,
  corOlhos VARCHAR(255)  NULL  ,
  corCabelo VARCHAR(255)  NULL  ,
  raca VARCHAR(255)  NULL  ,
  etnia VARCHAR(255)  NULL  ,
  tipoPersonagem VARCHAR(255)  NULL  ,
  biotipo VARCHAR(255)  NULL  ,
  obra INTEGER UNSIGNED  NOT NULL    ,
PRIMARY KEY(id)  ,
INDEX personagem_FKIndex1(obra),
  FOREIGN KEY(obra)
    REFERENCES obra(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE filme (
  id INTEGER UNSIGNED  NOT NULL  ,
  titulo VARCHAR(255)  NOT NULL  ,
  ano INTEGER UNSIGNED  NULL  ,
  genero VARCHAR(255)  NULL  ,
  distribuidora VARCHAR(255)  NULL  ,
  franquia VARCHAR(255)  NULL  ,
  tituloDublado VARCHAR(255)  NULL  ,
  diretor VARCHAR(255)  NULL    ,
PRIMARY KEY(id)  ,
INDEX Filme_FKIndex1(id),
  FOREIGN KEY(id)
    REFERENCES obra(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE game (
  id INTEGER UNSIGNED  NOT NULL  ,
  titulo VARCHAR(255)  NOT NULL  ,
  ano INTEGER UNSIGNED  NULL  ,
  genero VARCHAR(255)  NULL  ,
  distribuidora VARCHAR(255)  NULL  ,
  franquia VARCHAR(255)  NULL  ,
  plataformas VARCHAR(255)  NULL  ,
  criador VARCHAR(255)  NULL  ,
  desenvolvedoras VARCHAR(255)  NULL    ,
PRIMARY KEY(id)  ,
INDEX Game_FKIndex1(id),
  FOREIGN KEY(id)
    REFERENCES obra(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE arma (
  id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  modelo VARCHAR(255)  NOT NULL  ,
  nomeNaObra VARCHAR(255)  NULL  ,
  peso DOUBLE  NULL  ,
  comprimento DOUBLE  NULL  ,
  alcance INTEGER UNSIGNED  NULL  ,
  equipamentos VARCHAR(255)  NULL  ,
  capacidade INTEGER UNSIGNED  NULL  ,
  personagem INTEGER UNSIGNED  NOT NULL  ,
  calibre INTEGER UNSIGNED  NOT NULL  ,
  fabricante INTEGER UNSIGNED  NOT NULL    ,
PRIMARY KEY(id)  ,
INDEX arma_FKIndex1(calibre)  ,
INDEX arma_FKIndex2(fabricante)  ,
INDEX arma_FKIndex3(personagem),
  FOREIGN KEY(calibre)
    REFERENCES calibre(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(fabricante)
    REFERENCES fabricante(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(personagem)
    REFERENCES personagem(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
