-- Inserir Clientes
INSERT INTO CLIENTE (id, nome, email) VALUES (1, 'João Silva', 'joao@email.com');
INSERT INTO CLIENTE (id, nome, email) VALUES (2, 'Maria Souza', 'maria@email.com');
INSERT INTO CLIENTE (id, nome, email) VALUES (3, 'Pedro Oliveira', 'pedro@email.com');

-- Inserir Produtos
INSERT INTO PRODUTO (id, nome, preco) VALUES (1, 'Tênis Corrida', 299.99);
INSERT INTO PRODUTO (id, nome, preco) VALUES (2, 'Camiseta Esportiva', 79.90);
INSERT INTO PRODUTO (id, nome, preco) VALUES (3, 'Calça Legging', 159.90);

-- Inserir Pedidos
INSERT INTO PEDIDO (id, descricao, valor_total, cliente_id) VALUES (1, 'Pedido João', 379.89, 1);
INSERT INTO PEDIDO (id, descricao, valor_total, cliente_id) VALUES (2, 'Pedido Maria', 459.89, 2);

-- Inserir Relações de Produtos nos Pedidos
INSERT INTO PEDIDO_PRODUTOS (pedido_id, produtos_id) VALUES (1, 1);
INSERT INTO PEDIDO_PRODUTOS (pedido_id, produtos_id) VALUES (1, 2);
INSERT INTO PEDIDO_PRODUTOS (pedido_id, produtos_id) VALUES (2, 2);
INSERT INTO PEDIDO_PRODUTOS (pedido_id, produtos_id) VALUES (2, 3);