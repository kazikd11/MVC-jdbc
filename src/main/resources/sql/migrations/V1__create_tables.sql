
CREATE TABLE points (
    id SERIAL PRIMARY KEY
);

CREATE TABLE peaks (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    height INT,
    CONSTRAINT fk_point FOREIGN KEY (id) REFERENCES points(id) ON DELETE CASCADE
);

CREATE TABLE shelters (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(20),
    internal_phone_number VARCHAR(20),
    email VARCHAR(255),
    owner VARCHAR(255),
    status BOOLEAN,
    CONSTRAINT fk_point FOREIGN KEY (id) REFERENCES points(id) ON DELETE CASCADE
);


CREATE TABLE trail_points (
    point1_id INT,
    point2_id INT,
    trail_id INT,
    travel_time INT,
    color VARCHAR(255),
    CONSTRAINT fk_point1 FOREIGN KEY (point1_id) REFERENCES points(id),
    CONSTRAINT fk_point2 FOREIGN KEY (point2_id) REFERENCES points(id)
);
