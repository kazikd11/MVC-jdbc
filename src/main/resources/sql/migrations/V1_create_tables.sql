
CREATE TABLE points (
    id SERIAL PRIMARY KEY
);

CREATE TABLE peaks (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    height INT,
    CONSTRAINT fk_point FOREIGN KEY (id) REFERENCES points(id) ON DELETE CASCADE
)

CREATE TABLE shelters (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(20),
    internal_phone_number VARCHAR(20),
    email VARCHAR(255),
    owner VARCHAR(255),
    status BOOL,
    CONSTRAINT fk_point FOREIGN KEY (id) REFERENCES points(id) ON DELETE CASCADE
);

CREATE TABLE trails (
    id SERIAL PRIMARY KEY,
    color VARCHAR(255)
);

CREATE TABLE trail_points (
    trail_id INT,
    point_id INT,
    PRIMARY KEY (trail_id, point_id),
    CONSTRAINT fk_trail FOREIGN KEY (trail_id) REFERENCES trails(id),
    CONSTRAINT fk_point FOREIGN KEY (point_id) REFERENCES points(id)
);
