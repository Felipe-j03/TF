INSERT INTO aplicativo (codigo, nome, custoMensal) VALUES (1, 'StreamFlix', 40.0);
INSERT INTO aplicativo (codigo, nome, custoMensal) VALUES (2, 'FitLife', 15.0);
INSERT INTO aplicativo (codigo, nome, custoMensal) VALUES (3, 'Easy Food', 10.0);
INSERT INTO aplicativo (codigo, nome, custoMensal) VALUES (4, 'EducaVerso', 50.0);
INSERT INTO aplicativo (codigo, nome, custoMensal) VALUES (5, 'YouTube', 20.0);

INSERT INTO cliente (codigo, nome, email) VALUES (10, 'Ricardo', 'ricardo@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (20, 'Jonas', 'jonas@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (30, 'Luisa', 'luisa@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (40, 'Heleno', 'heleno@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (50, 'Vilmara', 'vilmara@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (60, 'Luciano', 'luciano@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (70, 'Maria', 'maria@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (80, 'Rafael', 'rafael@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (90, 'Roberta', 'roberta@email.com');
INSERT INTO cliente (codigo, nome, email) VALUES (100, 'Larissa', 'larissa@email.com');

INSERT INTO assinatura (codigo, aplicativo, cliente, inicioVigencia, fimVigencia) VALUES (1, 'StreamFlix', 'Ricardo', '10-05-2023', '10-05-2024');
INSERT INTO assinatura (codigo, aplicativo, cliente, inicioVigencia, fimVigencia) VALUES (2, 'FitLife', 'Roberta', '23-06-2024', '23-01-2025');
INSERT INTO assinatura (codigo, aplicativo, cliente, inicioVigencia, fimVigencia) VALUES (3, 'StreamFlix', 'Vilmara', '30-08-2024', '30-09-2024');
INSERT INTO assinatura (codigo, aplicativo, cliente, inicioVigencia, fimVigencia) VALUES (4, 'EducaVerso', 'Larissa', '02-03-2024', '02-03-2025');
INSERT INTO assinatura (codigo, aplicativo, cliente, inicioVigencia, fimVigencia) VALUES (5, 'Easy Food', 'Rafael', '15-10-2024', '15-01-2025');

INSERT INTO pagamento (codigo, assinatura, valorPago, dataPagamento, promocao) VALUES (1, 1, 40.0, '10-05-2023', 'PAGUE_30_GANHE_45');
INSERT INTO pagamento (codigo, assinatura, valorPago, dataPagamento, promocao) VALUES (2, 2, 15.0, '23-06-2024', NULL);
INSERT INTO pagamento (codigo, assinatura, valorPago, dataPagamento, promocao) VALUES (3, 3, 40.0, '30-08-2024', NULL);
INSERT INTO pagamento (codigo, assinatura, valorPago, dataPagamento, promocao) VALUES (4, 4, 50.0, '02-03-2024', NULL);
INSERT INTO pagamento (codigo, assinatura, valorPago, dataPagamento, promocao) VALUES (5, 5, 10.0, '15-10-2024' NULL);

INSERT INTO usuario (usuario, senha) VALUES ('admin','1234');











