CREATE  TABLE "main"."clientes" 
("id_cliente" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ,
 "nome" TEXT, "endereco" TEXT,
 "bairro" TEXT, "cidade" TEXT,
 "estado" VARCHAR, "cpf" INTEGER UNIQUE ,
 "cep" INTEGER, "tel" INTEGER,
 "sexo" CHAR DEFAULT F,
 "data_cadastro"  DEFAULT CURRENT_TIMESTAMP)
 
 CREATE  TABLE "main"."filmes" 
 ( "id_filme" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ,
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
 
 CREATE  TABLE "main"."transacoes" 
 ("id_transacao" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ,
 "id_cliente" INTEGER NOT NULL , 
 "id_filme" , 
 "data"  NOT NULL  DEFAULT CURRENT_TIMESTAMP)
 
 #SELECT transacoes.id,clientes.id, clientes.nome,
 #filmes.id,filmes.titulo_original, transacoes.data 
 #FROM transacoes,clientes,filmes WHERE transacoes.id_cliente =clientes.id;




