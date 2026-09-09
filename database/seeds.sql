USE foodshare_db;

-- Inserindo Usuários Base
INSERT INTO usuarios (id_usuario, nome, endereco, telefone, email, tipo_usuario) VALUES
(1, 'Supermercado Central Ltda', 'Av. Brasil, 1500 - Centro', '(44) 3030-1010', 'contato@central.com', 'DOADOR'),
(2, 'Padaria e Confeitaria Pão Dourado', 'Rua das Flores, 320 - Zona 05', '(44) 3222-4545', 'doacoes@paodourado.com', 'DOADOR'),
(3, 'Associação Lar dos Amigos', 'Rua Esperança, 88 - Vila Nova', '(44) 9988-1122', 'coleta@lardosamigos.org', 'INSTITUICAO');

-- Inserindo Doadores
INSERT INTO doadores (id_doador, id_usuario, cnpj, nome_fantasia) VALUES
(1, 1, '12.345.678/0001-90', 'Supermercado Central'),
(2, 2, '98.765.432/0001-10', 'Padaria Pão Dourado');

-- Inserindo Instituições (ONGs)
INSERT INTO instituicoes (id_instituicao, id_usuario, cnpj, responsavel, capacidade_diaria) VALUES
(1, 3, '45.678.901/0001-23', 'Irmã Maria da Conceição', 250);

-- Inserindo Doações Iniciais para Teste
INSERT INTO doacoes (id_doacao, id_doador, descricao, categoria, quantidade, validade, status) VALUES
(1, 1, 'Caixas de Maçã Gala e Pera (Hortifrúti)', 'Perecível', 45.50, '2026-03-25', 'DISPONIVEL'),
(2, 1, 'Fardos de Arroz Branco 5kg', 'Não Perecível', 20.00, '2026-11-30', 'DISPONIVEL'),
(3, 2, 'Pães Franceses e Brioches do Dia', 'Perecível', 12.00, '2026-03-20', 'EM_TRANSITO');
