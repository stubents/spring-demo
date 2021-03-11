CREATE SCHEMA IF NOT EXISTS demo;

CREATE TABLE demo.demo_user(
    user_id varchar NOT NULL PRIMARY KEY,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    street varchar NOT NULL,
    house_no varchar,
    zip_code varchar NOT NULL,
    city varchar,
    state varchar,
    birthday DATE
);

INSERT INTO demo.demo_user VALUES ('22558c65-374e-4de9-a236-014f17814baa', 'Monika', 'Musterfrau', 'Fananenweg', '15', '70771', 'Leinfelden', 'BW', '1970-08-25');
INSERT INTO demo.demo_user VALUES ('fa5845e4-b869-4569-b25e-5416b3104f17', 'Max', 'Mustermann', 'Mühlenstraße', '39', '10243', 'Berlin', 'BE', '1980-07-01');
