CREATE TABLE [dbo].[usuario] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [VARCHAR](100) NOT NULL,
	[email] [VARCHAR](100) NOT NULL,
	[senha] [VARCHAR](150) NOT NULL,
	CONSTRAINT [pk_usuario] PRIMARY KEY CLUSTERED ([id] ASC)
);

CREATE TABLE [dbo].[permissao] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [VARCHAR](50) NOT NULL,	
	CONSTRAINT [pk_permissao] PRIMARY KEY CLUSTERED ([id] ASC)
);

CREATE TABLE [dbo].[usuario_permissao] (
	[id_usuario] [INT] NOT NULL,
	[id_permissao] [INT] NOT NULL,	
	CONSTRAINT [pk_usuario_permissao] PRIMARY KEY CLUSTERED ([id_usuario], [id_permissao] ASC),
	CONSTRAINT [fk_usuario_permissao_usuario] FOREIGN KEY (id_usuario) REFERENCES usuario (id),
	CONSTRAINT [fk_usuario_permissao_permissao] FOREIGN KEY (id_permissao) REFERENCES permissao (id)
    ON DELETE CASCADE  
    ON UPDATE CASCADE
);

INSERT INTO usuario (nome, email, senha) values ('Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (nome, email, senha) values ('Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_PESSOA');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_PESSOA');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_PESSOA');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_LANCAMENTO');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_LANCAMENTO');

-- admin
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 8);

-- maria
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 8);