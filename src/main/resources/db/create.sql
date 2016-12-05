DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
OWNER TO webmail;

DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  date_registered DATE
);

CREATE TABLE mail (
  id SERIAL PRIMARY KEY,
  subject VARCHAR(255),
  body VARCHAR(255),
  sender_id INT,
  receiver_id INT,
  date_sent DATE
);

ALTER TABLE mail
    ADD CONSTRAINT FK_SENDER FOREIGN KEY (sender_id) REFERENCES account(id);

ALTER TABLE mail
    ADD CONSTRAINT FK_RECEIVER FOREIGN KEY (receiver_id) REFERENCES account(id);

ALTER TABLE account
    ADD CONSTRAINT UNIQUE_NAME UNIQUE (username);