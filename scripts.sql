CREATE TABLE country (
                                    country_code VARCHAR UNIQUE NOT NULL PRIMARY KEY,
                                    "name" varchar NOT NULL

);

CREATE TABLE airport (

                                   airport_code VARCHAR UNIQUE NOT NULL PRIMARY KEY ,
                                   country_code VARCHAR NOT NULL REFERENCES country(country_code) ON DELETE CASCADE ,
                                   city varchar NOT NULL
);


CREATE TABLE clients (
                                   id SERIAL NOT NULL PRIMARY KEY ,
                                   identify int NOT NULL UNIQUE ,
                                   passport_series varchar(55) NOT NULL,
                                   full_name varchar NOT NULL,
                                   gender varchar(40) NOT NULL,
                                   country varchar NOT NULL REFERENCES country(country_code) ON DELETE CASCADE

);

CREATE TABLE flight (
                                  flight_num VARCHAR NOT NULL UNIQUE PRIMARY KEY ,
                                  airplane_model varchar(50) NOT NULL,
                                  departure_time information_schema."time_stamp" NOT NULL,
                                  departure_from VARCHAR NOT NULL REFERENCES airport(airport_code) ON DELETE CASCADE ,
                                  where_arriving VARCHAR NOT NULL REFERENCES airport(airport_code) ON DELETE CASCADE ,
                                  flight_time timestamp NOT NULL,
                                  places int NOT NULL

);


CREATE TABLE tickets (
                                   id SERIAL NOT NULL PRIMARY KEY ,
                                   client_id int NOT NULL REFERENCES clients(id) ON DELETE CASCADE ,
                                   flight_code VARCHAR NOT NULL REFERENCES flight(flight_num) On DELETE CASCADE ,
                                   ticket_take timestamp NOT NULL,
                                   ticket_num int NOT NULL
);