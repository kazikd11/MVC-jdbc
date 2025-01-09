
CREATE TABLE punkty (
    id SERIAL PRIMARY KEY
);

CREATE TABLE szczyty (
    id INT PRIMARY KEY,
    nazwa VARCHAR(255),
    wysokosc INT,
    CONSTRAINT fk_punkt FOREIGN KEY (id) REFERENCES punkty(id) ON DELETE CASCADE
);

CREATE TABLE schroniska (
    id INT PRIMARY KEY,
    nazwa VARCHAR(255),
    telefon VARCHAR(20),
    wewnetrzny_telefon VARCHAR(20),
    email VARCHAR(255),
    wlasciciel VARCHAR(255),
    status BOOLEAN,
    CONSTRAINT fk_punkt FOREIGN KEY (id) REFERENCES punkty(id) ON DELETE CASCADE
);


CREATE TABLE fragmenty_szlaku (
    punkt1_id INT,
    punkt2_id INT,
    szlak_id INT,
    czas INT,
    kolor VARCHAR(255),
    CONSTRAINT fk_punkt1 FOREIGN KEY (punkt1_id) REFERENCES punkty(id),
    CONSTRAINT fk_punkt2 FOREIGN KEY (punkt2_id) REFERENCES punkty(id)
);
