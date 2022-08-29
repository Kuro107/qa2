CREATE TABLE "airline" .country (
                                    country_code VARCHAR UNIQUE NOT NULL PRIMARY KEY,
                                    "name" varchar NOT NULL

);

CREATE TABLE "airline".airport (

                                   airport_code VARCHAR UNIQUE NOT NULL PRIMARY KEY ,
                                   country_code VARCHAR NOT NULL REFERENCES "airline".country(country_code),
                                   city varchar NOT NULL
);


CREATE TABLE "airline".clients (
                                   id SERIAL NOT NULL PRIMARY KEY ,
                                   identify int NOT NULL,
                                   passport_series varchar(55) NOT NULL,
                                   full_name varchar NOT NULL,
                                   gender varchar(40) NOT NULL,
                                   country varchar NOT NULL REFERENCES airline.country(country_code)

);

CREATE TABLE "airline".flight (
                                  flight_num VARCHAR NOT NULL UNIQUE PRIMARY KEY ,
                                  airplane_model varchar(50) NOT NULL,
                                  departure_time information_schema."time_stamp" NOT NULL,
                                  departure_from VARCHAR NOT NULL REFERENCES "airline".airport(airport_code),
                                  where_arriving VARCHAR NOT NULL REFERENCES "airline".airport(airport_code),
                                  flight_time timestamp NOT NULL,
                                  places int NOT NULL

);


CREATE TABLE "airline".tickets (
                                   id SERIAL NOT NULL PRIMARY KEY ,
                                   client_id int NOT NULL REFERENCES "airline".clients(id),
                                   flight_code VARCHAR NOT NULL REFERENCES "airline".flight(flight_num),
                                   ticket_take timestamp NOT NULL,
                                   ticket_num int NOT NULL
);