DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
OWNER TO webmail;

DROP TABLE IF EXISTS mail_receivers;
DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  date_registered TIMESTAMP
);

CREATE TABLE mail (
  id SERIAL PRIMARY KEY,
  subject VARCHAR(255),
  body TEXT,
  sender_id INT,
  date_sent TIMESTAMP
);

CREATE TABLE mail_receivers (
  mail_id INT NOT NULL,
  receiver_id INT NOT NULL,
  PRIMARY KEY (mail_id, receiver_id)
);

ALTER TABLE mail
    ADD CONSTRAINT FK_SENDER FOREIGN KEY (sender_id) REFERENCES account(id);

ALTER TABLE mail_receivers
    ADD CONSTRAINT FK_MAIL FOREIGN KEY (mail_id) REFERENCES mail(id);

ALTER TABLE mail_receivers
    ADD CONSTRAINT FK_RECEIVER FOREIGN KEY (receiver_id) REFERENCES account(id);

ALTER TABLE account
    ADD CONSTRAINT UNIQUE_NAME UNIQUE (username);