INSERT INTO public.entity (id, name) VALUES (1, 'User1');
INSERT INTO public.entity (id, name) VALUES (2, 'User2');

INSERT INTO public.account (entity_id, state) VALUES (1, 'OPEN');
INSERT INTO public.account (entity_id, state) VALUES (1, 'PENDING');
INSERT INTO public.account (entity_id, state) VALUES (1, 'CLOSE');
INSERT INTO public.account (entity_id, state) VALUES (1, 'FROZEN');
INSERT INTO public.account (entity_id, state) VALUES (1, 'SUSPENDED');
INSERT INTO public.account (entity_id, state) VALUES (1, 'BLOCKED');
INSERT INTO public.account (entity_id, state) VALUES (1, 'OPEN');
INSERT INTO public.account (entity_id, state) VALUES (1, 'OPEN');

INSERT INTO public.asset (type, code, name) VALUES('FIAT','CNY','CNY');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','USD','USD');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','EUR','EUR');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','JPY','JPY');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','GBP','GBP');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','HKD','HKD');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','AUD','AUT');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','TWD','TWD');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','CAD','CAD');
INSERT INTO public.asset (type, code, name) VALUES('FIAT','SGD','SGD');

INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','BTC','BitCoin');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','ETH','Ethereum');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','XRP','Ripple');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','LTC','Litecoin');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','BCH','Bitcoin Cash');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','ADA','Cardano');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','DOT','Polkadot');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','BNB','Binance Coin');
INSERT INTO public.asset (type, code, name) VALUES('CRYPTO','LINK','Chainlink');


INSERT INTO public.asset (type, code, name) VALUES('STOCK','AAPL','Apple Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','AMZN','Amazon.com Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','MSFT','Microsoft Corporation');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','GOOGL','Alphabet Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','FB','Facebook Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','TSLA','Tesla Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','BRK.A','Berkshire Hathaway Inc.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','JPM','JPMorgan Chase & Co.');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','JNJ','Johnson & Johnson');
INSERT INTO public.asset (type, code, name) VALUES('STOCK','V','Visa Inc.');

INSERT INTO public.asset (type, code, name) VALUES('BOND','GB3:GOV','US BOND 3 Month');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GB6:GOV','US BOND 6 Month');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GB12:GOV','US BOND 12 Month');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GT2:GOV','US BOND 2 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GT5:GOV','US BOND 5 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GT10:GOV','US BOND 10 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GT30:GOV','US BOND 30 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GTII5:GOV','Treasury Inflation Protected Securities 5 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GTII10:GOV','Treasury Inflation Protected Securities 10 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GTII20:GOV','Treasury Inflation Protected Securities 20 Year');
INSERT INTO public.asset (type, code, name) VALUES('BOND','GTII30:GOV','Treasury Inflation Protected Securities 30 Year');

