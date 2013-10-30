CREATE  TABLE "main"."clientes" 
("id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ,
 "nome" TEXT, "endereco" TEXT,
 "bairro" TEXT, "cidade" TEXT,
 "estado" VARCHAR, "cpf" INTEGER UNIQUE ,
 "cep" INTEGER, "tel" INTEGER,
 "sexo" CHAR DEFAULT F,
 "data_cadastro"  DEFAULT CURRENT_TIMESTAMP)