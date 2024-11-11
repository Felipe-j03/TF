INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (1, 'StreamFlix', 40.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (2, 'FitLife', 15.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (3, 'Easy Food', 10.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (4, 'EducaVerso', 50.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (5, 'YouTube', 20.0);

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

INSERT INTO assinatura (codigo, aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES (1, 1, 10, '2023-05-10', '2024-05-10');
INSERT INTO assinatura (codigo, aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES (2, 2, 30, '2024-06-23', '2025-01-23');
INSERT INTO assinatura (codigo, aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES (3, 3, 90, '2024-08-30', '2024-09-30');
INSERT INTO assinatura (codigo, aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES (4, 4, 100, '2024-03-02', '2025-03-02');
INSERT INTO assinatura (codigo, aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES (5, 5, 20, '2024-10-15', '2025-01-15');


INSERT INTO pagamento (codigo, assinatura_codigo, valor_pago, data_pagamento, promocao) VALUES (1, 2, 40.0, '2023-05-10', 'PAGUE_30_GANHE_45');
INSERT INTO pagamento (codigo, assinatura_codigo, valor_pago, data_pagamento, promocao) VALUES (2, 4, 15.0, '2024-06-23', NULL);
INSERT INTO pagamento (codigo, assinatura_codigo, valor_pago, data_pagamento, promocao) VALUES (3, 5, 40.0, '2024-08-30', NULL);
INSERT INTO pagamento (codigo, assinatura_codigo, valor_pago, data_pagamento, promocao) VALUES (4, 3, 50.0, '2024-03-02', NULL);
INSERT INTO pagamento (codigo, assinatura_codigo, valor_pago, data_pagamento, promocao) VALUES (5, 1, 10.0, '2024-10-15', 'ANUAL_40_OFF');













