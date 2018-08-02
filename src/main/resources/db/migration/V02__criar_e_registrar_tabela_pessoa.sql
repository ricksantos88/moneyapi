CREATE TABLE pessoa (
	codigo      BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome   	    VARCHAR(50) NOT NULL,
    ativo  	    BOOLEAN,
    logradouro  VARCHAR(50),
    numero      VARCHAR(50),
    complemento VARCHAR(50),
    bairro      VARCHAR(50),
    cep         VARCHAR(50),
    cidade      VARCHAR(50),
    estado      VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Wendel Santos', true, 'TV WE16', '72', 'Proximo ao Formosa', 'CN2', '67130440' , 'Ananindeua' ,'Pará');

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Larisse Castro', true, 'TV WE16', '72', 'Proximo ao Formosa', 'CN2', '67130440' , 'Ananindeua' ,'Pará');

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Messias Neto', true, 'TV WE16', '72', 'Proximo ao Formosa', 'CN2', '67130440' , 'Ananindeua' ,'Pará');

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Marcelo Santos', true, 'Rua das Begonias', '1623', 'Proximo ao Ciferal', 'brasilia-outeiro', '66845-400' , 'Belém' ,'Pará');

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Yasmin Lopes', true, 'Rua das Begonias', '1623', 'Proximo ao Ciferal', 'brasilia-outeiro', '66845-400' , 'Belém' ,'Pará');

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ('Manoel Bernadino', true, 'Rua das Begonias', '1623', 'Proximo ao Ciferal', 'brasilia-outeiro', '66845-400' , 'Belém' ,'Pará');