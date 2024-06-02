<<<<<<< Updated upstream
use BdNetuno;

INSERT INTO FUNCIONARIO (COD_FUNCIONARIO, NOME_FUNCIONARIO, CPF_FUNCIONARIO, SENHA_FUNCIONARIO, EMAIL_FUNCIONARIO, TELEFONE_FUNCIONARIO) VALUES 
(1, 'João Silva', '12345678901', 'senha123', 'joao.silva@example.com', '11987654321'),
(2, 'Maria Santos', '23456789012', 'senha123', 'maria.santos@example.com', '21987654321'),
(3, 'Pedro Costa', '34567890123', 'senha123', 'pedro.costa@example.com', '31987654321'),
(4, 'Ana Oliveira', '45678901234', 'senha123', 'ana.oliveira@example.com', '41987654321'),
(5, 'Lucas Pereira', '56789012345', 'senha123', 'lucas.pereira@example.com', '51987654321'),
(6, 'Beatriz Souza', '67890123456', 'senha123', 'beatriz.souza@example.com', '61987654321'),
(7, 'Carlos Lima', '78901234567', 'senha123', 'carlos.lima@example.com', '71987654321'),
(8, 'Fernanda Alves', '89012345678', 'senha123', 'fernanda.alves@example.com', '81987654321'),
(9, 'Paulo Mendes', '90123456789', 'senha123', 'paulo.mendes@example.com', '91987654321'),
(10, 'Juliana Rodrigues', '01234567890', 'senha123', 'juliana.rodrigues@example.com', '10198765432'),
(11, 'Ricardo Cardoso', '11234567890', 'senha123', 'ricardo.cardoso@example.com', '11198765432'),
(12, 'Aline Araújo', '12234567890', 'senha123', 'aline.araujo@example.com', '12198765432'),
(13, 'Renato Gonçalves', '13234567890', 'senha123', 'renato.goncalves@example.com', '13198765432'),
(14, 'Camila Martins', '14234567890', 'senha123', 'camila.martins@example.com', '14198765432'),
(15, 'Fábio Almeida', '15234567890', 'senha123', 'fabio.almeida@example.com', '15198765432'),
(16, 'Patrícia Freitas', '16234567890', 'senha123', 'patricia.freitas@example.com', '16198765432'),
(17, 'André Silva', '17234567890', 'senha123', 'andre.silva@example.com', '17198765432'),
(18, 'Tatiana Campos', '18234567890', 'senha123', 'tatiana.campos@example.com', '18198765432'),
(19, 'Leonardo Barbosa', '19234567890', 'senha123', 'leonardo.barbosa@example.com', '19198765432'),
(20, 'Daniela Ribeiro', '20234567890', 'senha123', 'daniela.ribeiro@example.com', '20198765432');

INSERT INTO ENDERECO (COD_ENDERECO, CEP_ENDERECO, NUMERO_ENDERECO, CIDADE_ENDERECO, BAIRRO_ENDERECO, RUA_ENDERECO, COMPLEMENTO_ENDERECO) VALUES 
(1, '01001000', 123, 'São Paulo', 'Centro', 'Rua A', 'Apto 1'),
(2, '02002000', 456, 'Rio de Janeiro', 'Copacabana', 'Rua B', 'Apto 2'),
(3, '03003000', 789, 'Belo Horizonte', 'Savassi', 'Rua C', 'Casa 3'),
(4, '04004000', 101, 'Curitiba', 'Batel', 'Rua D', 'Apto 4'),
(5, '05005000', 202, 'Porto Alegre', 'Moinhos', 'Rua E', 'Apto 5'),
(6, '06006000', 303, 'Florianópolis', 'Centro', 'Rua F', 'Casa 6'),
(7, '07007000', 404, 'Salvador', 'Barra', 'Rua G', 'Apto 7'),
(8, '08008000', 505, 'Fortaleza', 'Aldeota', 'Rua H', 'Apto 8'),
(9, '09009000', 606, 'Manaus', 'Centro', 'Rua I', 'Apto 9'),
(10, '10010010', 707, 'Recife', 'Boa Viagem', 'Rua J', 'Apto 10'),
(11, '11011010', 808, 'Natal', 'Ponta Negra', 'Rua K', 'Casa 11'),
(12, '12012010', 909, 'Maceió', 'Pajuçara', 'Rua L', 'Apto 12'),
(13, '13013010', 101, 'João Pessoa', 'Tambaú', 'Rua M', 'Casa 13'),
(14, '14014010', 202, 'Teresina', 'Centro', 'Rua N', 'Apto 14'),
(15, '15015010', 303, 'Aracaju', 'Atalaia', 'Rua O', 'Casa 15'),
(16, '16016010', 404, 'São Luís', 'Centro', 'Rua P', 'Apto 16'),
(17, '17017010', 505, 'Belém', 'Nazaré', 'Rua Q', 'Casa 17'),
(18, '18018010', 606, 'Cuiabá', 'Centro', 'Rua R', 'Apto 18'),
(19, '19019010', 707, 'Campo Grande', 'Centro', 'Rua S', 'Casa 19'),
(20, '20020020', 808, 'Goiânia', 'Setor Bueno', 'Rua T', 'Apto 20');

-- Inserts para a tabela CLIENTE
INSERT INTO CLIENTE (COD_CLIENTE, CPF_CLIENTE, NOME_CLIENTE, EMAIL_CLIENTE, TELEFONE_CLIENTE) VALUES 
(1, '12312312312', 'Carlos Silva', 'carlos.silva@example.com', '99123456789'),
(2, '23423423423', 'Maria Costa', 'maria.costa@example.com', '99223456789'),
(3, '34534534534', 'João Santos', 'joao.santos@example.com', '99323456789'),
(4, '45645645645', 'Ana Souza', 'ana.souza@example.com', '99423456789'),
(5, '56756756756', 'Pedro Oliveira', 'pedro.oliveira@example.com', '99523456789'),
(6, '67867867867', 'Beatriz Lima', 'beatriz.lima@example.com', '99623456789'),
(7, '78978978978', 'Lucas Alves', 'lucas.alves@example.com', '99723456789'),
(8, '89089089089', 'Fernanda Pereira', 'fernanda.pereira@example.com', '99823456789'),
(9, '90190190190', 'Paulo Ribeiro', 'paulo.ribeiro@example.com', '99923456789'),
(10, '01201201201', 'Juliana Rocha', 'juliana.rocha@example.com', '90023456789'),
(11, '11211211211', 'Ricardo Cardoso', 'ricardo.cardoso@example.com', '90123456789'),
(12, '12212212212', 'Aline Araújo', 'aline.araujo@example.com', '90223456789'),
(13, '13213213213', 'Renato Gonçalves', 'renato.goncalves@example.com', '90323456789'),
(14, '14214214214', 'Camila Martins', 'camila.martins@example.com', '90423456789'),
(15, '15215215215', 'Fábio Almeida', 'fabio.almeida@example.com', '90523456789'),
(16, '16216216216', 'Patrícia Freitas', 'patricia.freitas@example.com', '90623456789'),
(17, '17217217217', 'André Silva', 'andre.silva@example.com', '90723456789'),
(18, '18218218218', 'Tatiana Campos', 'tatiana.campos@example.com', '90823456789'),
(19, '19219219219', 'Leonardo Barbosa', 'leonardo.barbosa@example.com', '90923456789'),
(20, '20220220220', 'Daniela Ribeiro', 'daniela.ribeiro@example.com', '91023456789');

INSERT INTO HIDROMETRO (COD_HIDROMETRO, NUM_CHIP, NUMFAB_HIDROMETRO, MODELO) VALUES 
(1, 'CHIP001', 'FAB001', 'MOD1'),
(2, 'CHIP002', 'FAB002', 'MOD2'),
(3, 'CHIP003', 'FAB003', 'MOD3'),
(4, 'CHIP004', 'FAB004', 'MOD4'),
(5, 'CHIP005', 'FAB005', 'MOD5'),
(6, 'CHIP006', 'FAB006', 'MOD6'),
(7, 'CHIP007', 'FAB007', 'MOD7'),
(8, 'CHIP008', 'FAB008', 'MOD8'),
(9, 'CHIP009', 'FAB009', 'MOD9'),
(10, 'CHIP010', 'FAB010', 'MOD10'),
(11, 'CHIP011', 'FAB011', 'MOD11'),
(12, 'CHIP012', 'FAB012', 'MOD12'),
(13, 'CHIP013', 'FAB013', 'MOD13'),
(14, 'CHIP014', 'FAB014', 'MOD14'),
(15, 'CHIP015', 'FAB015', 'MOD15'),
(16, 'CHIP016', 'FAB016', 'MOD16'),
(17, 'CHIP017', 'FAB017', 'MOD17'),
(18, 'CHIP018', 'FAB018', 'MOD18'),
(19, 'CHIP019', 'FAB019', 'MOD19'),
(20, 'CHIP020', 'FAB020', 'MOD20');
=======
CREATE DATABASE BdNetuno;
USE BdNetuno;

CREATE TABLE FUNCIONARIO(
COD_FUNCIONARIO INT PRIMARY KEY,
NOME_FUNCIONARIO VARCHAR (50) NOT NULL,
CPF_FUNCIONARIO VARCHAR (11) UNIQUE NOT NULL,
SENHA_FUNCIONARIO VARCHAR (50) NOT NULL,
EMAIL_FUNCIONARIO VARCHAR (120) UNIQUE NOT NULL,
TELEFONE_FUNCIONARIO VARCHAR (11) UNIQUE NOT NULL
)
 
CREATE TABLE ENDERECO(
COD_ENDERECO INT PRIMARY KEY,
CEP_ENDERECO VARCHAR (8) NOT NULL,
NUMERO_ENDERECO INT NOT NULL,
CIDADE_ENDERECO VARCHAR(30) NOT NULL,
BAIRRO_ENDERECO VARCHAR(30) NOT NULL,
RUA_ENDERECO VARCHAR(40) NOT NULL,
COMPLEMENTO_ENDERECO VARCHAR(30));

CREATE TABLE CLIENTE(
COD_CLIENTE INT PRIMARY KEY,
CPF_CLIENTE VARCHAR(11) UNIQUE NOT NULL,
NOME_CLIENTE VARCHAR(25) NOT NULL,
EMAIL_CLIENTE VARCHAR(40) UNIQUE NOT NULL,
TELEFONE_CLIENTE VARCHAR(11) NOT NULL);
 
CREATE TABLE HIDROMETRO(
COD_HIDROMETRO INT PRIMARY KEY, 
NUM_CHIP VARCHAR(10) UNIQUE NOT NULL,
NUMFAB_HIDROMETRO VARCHAR(6) UNIQUE NOT NULL,
MODELO VARCHAR(8) NOT NULL
);

CREATE TABLE LEITURA(
COD_LEITURA INT PRIMARY KEY, 
COD_HIDROMETRO INT NOT NULL REFERENCES HIDROMETRO,
DATA_LEITURA DATETIME NOT NULL,
LEITURA_ANTERIOR DECIMAL(5,2) NOT NULL,
LEITURA_ATUAL DECIMAL(5,2) NOT NULL,
CONSUMO DECIMAL(5,2) NOT NULL,
MEDIA_CONSUMO DECIMAL(5,2) NOT NULL);

CREATE TABLE ENDERECO_CLIENTE(
COD_ENDERECO_CLIENTE INT PRIMARY KEY,
COD_CLIENTE INT NOT NULL REFERENCES CLIENTE,
COD_ENDERECO INT NOT NULL REFERENCES ENDERECO,
DATA_INICIO DATETIME NOT NULL,
DATA_TERMINO DATETIME NOT NULL
);

CREATE TABLE GERENCIAR(
COD_GERENCIA INT PRIMARY KEY,
COD_FUNCIONARIO INT NOT NULL REFERENCES FUNCIONARIO,
COD_HIDROMETRO INT NOT NULL REFERENCES HIDROMETRO,
DATA_INICIO DATETIME NOT NULL,
DATA_TERMINO DATETIME NOT NULL
);
>>>>>>> Stashed changes
