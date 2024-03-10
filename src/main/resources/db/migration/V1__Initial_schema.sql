CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    pair VARCHAR(255) NOT NULL,
    timespan VARCHAR(50) NOT NULL,
    orderType VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS trades (
    trade_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    entry_time TIMESTAMP NOT NULL,
    exit_time TIMESTAMP,
    enter_price DECIMAL,
    exit_price DECIMAL,
    margin DECIMAL,
    leverage INT,
    status VARCHAR(50),
    trade_operation VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    leverage INT,
    trade_on_off BOOLEAN,
    candle_size INT,
    method VARCHAR(255)
);

ALTER TABLE trades ADD CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id);
