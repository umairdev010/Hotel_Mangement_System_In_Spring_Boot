-- creating table of hotels
CREATE TABLE IF NOT EXISTS hotels(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- creating table of rooms
CREATE TABLE IF NOT EXISTS rooms(
    id SERIAL PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(10) CHECK(type IN ('SINGLE','DOUBLE','SUITE')) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    hotel_id INT NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

--create table for bookings
-- CREATE TABLE IF NOT EXISTS bookings(
--     id SERIAL PRIMARY KEY,
--     room_id INT NOT NULL,
--     customer_id INT NOT NULL,
--     check_in_date DATE NOT NULL,
--     check_out_date DATE NOT NULL,
--     price DECIMAL(10,2) NOT NULL,
--     status VARCHAR(10) CHECK(status IN ('PENDING','CONFIRMED')),
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (room_id) REFERENCES rooms(id)
--     ON DELETE CASCADE,
--     FOREIGN KEY (customer_id) REFERENCES customers(id)
--     ON DELETE CASCADE
-- );
