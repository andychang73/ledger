INSERT INTO balance_history_fiat (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 100, 'USD', 'USD', 200, 100, 100, 100, '2023-10-01 00:00:00');
INSERT INTO balance_history_fiat (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 100, 'USD', 'USD', 200, 100, 50, 150, '2023-10-02 00:00:00');
INSERT INTO balance_history_fiat (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 100, 'USD', 'USD', 100, 200, -75, 75, '2023-10-03 00:00:00');

INSERT INTO balance_history_crypto (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 101, 'BTC', 'Bitcoin', 201, 101, 200, 200, '2023-11-01 00:00:00');
INSERT INTO balance_history_crypto (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 101, 'BTC', 'Bitcoin', 101, 200, -30, 170, '2023-11-02 00:00:00');
INSERT INTO balance_history_crypto (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 100, 101, 'BTC', 'Bitcoin', 201, 101, 200, 370, '2023-12-03 00:00:00');

INSERT INTO balance_history_stock (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 102, 'AAPL', 'Apple Inc.', 102, 202, -300, 700, '2023-12-01 00:00:00');
INSERT INTO balance_history_stock (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 102, 'AAPL', 'Apple Inc.', 102, 202, -150, 550, '2023-12-02 00:00:00');
INSERT INTO balance_history_stock (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 102, 'AAPL', 'Apple Inc.', 102, 202, -250, 300, '2023-12-31 00:00:00');


INSERT INTO balance_history_bond (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 103, 'GB3:GOV', 'US BOND 3 Month', 301, 102, 100, 100, '2023-12-01 00:00:00');
INSERT INTO balance_history_bond (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 103, 'GB3:GOV', 'US BOND 3 Month', 301, 102, 200, 300, '2023-12-02 00:00:00');
INSERT INTO balance_history_bond (entity_id, account_id, wallet_id, asset_code, asset_name, source_wallet_id, target_wallet_id, amount, balance, created_at) VALUES (2, 200, 103, 'GB3:GOV', 'US BOND 3 Month', 301, 102, 300, 600, '2023-12-31 00:00:00');