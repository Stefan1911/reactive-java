DROP TABLE IF EXISTS quote;

CREATE TABLE quote (
    id SERIAL PRIMARY KEY,
    company TEXT,
    ticker TEXT,
    stock_exchange TEXT,
    quote_price FLOAT,
    previous_close FLOAT,
    daily_change FLOAT,
    daily_change_percent FLOAT,
    open FLOAT,
    bid FLOAT,
    ask FLOAT,
    volume FLOAT
);

ALTER SEQUENCE quote_id_seq
RESTART WITH 1;

DROP TABLE IF EXISTS option;

CREATE TABLE option (
    id SERIAL PRIMARY KEY,
	call_option_price FLOAT,
	current_stock_price FLOAT,
	trike_price FLOAT,
    risk_free_interest_rate FLOAT,
 	time_to_maturity FLOAT,
	evaluated_price FLOAT
);

ALTER SEQUENCE option_id_seq
RESTART WITH 1;