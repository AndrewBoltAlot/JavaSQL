CREATE TABLE contacts(id INT AUTO_INCREMENT, name CHAR(30) NOT NULL, email CHAR(30));

INSERT INTO contacts(name, email) VALUES('Rem1', 'Rem1.collier@ucd.ie');

INSERT INTO contacts(email) VALUES('Rem1.collier@ucd.ie');

UPDATE contacts SET name = "Adnrew", email = "abolt@gmail.com" WHERE id = 1;

SELECT * FROM contacts WHERE name LIKE "Re";

DROP TABLE contacts;

DROP TABLE mapsql.tables;

DELETE FROM contacts WHERE id = 1;

SELECT * FROM contacts WHERE id <= 2;
