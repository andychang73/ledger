DROP TABLE IF EXISTS public.movement;
CREATE TABLE IF NOT EXISTS public.movement(
	id INT8 PRIMARY KEY,
	entity_id INT8 NOT NULL,
	source_account_id INT8 NOT NULL,
	target_account_id INT8 NOT NULL,
	source_wallet_id INT8 NOT NULL,
	target_wallet_id INT8 NOT NULL,
	amount DECIMAL(21,4) NOT NULL,
	state VARCHAR(32) NOT NULL,
	remark VARCHAR(32),
	created_at TIMESTAMP NOT NULL,
	modified_at TIMESTAMP NOT NULL
);