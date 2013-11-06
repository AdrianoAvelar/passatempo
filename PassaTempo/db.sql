CREATE  TABLE "main"."clientes" 
("id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ,
 "nome" TEXT, "endereco" TEXT,
 "bairro" TEXT, "cidade" TEXT,
 "estado" VARCHAR, "cpf" INTEGER UNIQUE ,
 "cep" INTEGER, "tel" INTEGER,
 "sexo" CHAR DEFAULT F,
 "data_cadastro"  DEFAULT CURRENT_TIMESTAMP)
 
 CREATE  TABLE "main"."filmes" 
 ( "id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ,
 "titulo_original" VARCHAR,
 "titulo_traduzido" VARCHAR,
 "duracao" INTEGER,
 "ano" INTEGER,
 "idioma" INTEGER,
 "genero" VARCHAR,
 "classificacao" VARCHAR, 
 "imagem" VARCHAR, 
UNIQUE ("titulo_original", "titulo_traduzido", "ano")  ON CONFLICT FAIL
 );




