# Add users
INSERT INTO db_cash_online.users(email, first_name, last_name) VALUES("user1@gmail.com", "firstname1", "lastname1");
INSERT INTO db_cash_online.users(email, first_name, last_name) VALUES("user2@gmail.com", "firstname2", "lastname2");
INSERT INTO db_cash_online.users(email, first_name, last_name) VALUES("user3@gmail.com", "firstname3", "lastname3");

# Add loans
INSERT INTO db_cash_online.loans(total, user_id) VALUES(10000, 1);
INSERT INTO db_cash_online.loans(total, user_id) VALUES(10000, 2);
INSERT INTO db_cash_online.loans(total, user_id) VALUES(25000, 2);
INSERT INTO db_cash_online.loans(total, user_id) VALUES(10000, 3);
INSERT INTO db_cash_online.loans(total, user_id) VALUES(25000, 3);
INSERT INTO db_cash_online.loans(total, user_id) VALUES(100000, 3);
