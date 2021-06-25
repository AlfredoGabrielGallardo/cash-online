CREATE TABLE db_cash_online.loans (
    id INT NOT NULL AUTO_INCREMENT UNIQUE,
    total DECIMAL (19,2) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(user_id));