CREATE OR REPLACE FUNCTION dodaj_schronisko() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO punkty DEFAULT VALUES;
    NEW.id := currval('punkty_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION dodaj_szczyt() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO punkty DEFAULT VALUES;
    NEW.id := currval('punkty_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--

CREATE TRIGGER przed_insert_schronisko
    BEFORE INSERT ON schroniska
    FOR EACH ROW
EXECUTE FUNCTION dodaj_schronisko();

CREATE TRIGGER przed_insert_szczyt
    BEFORE INSERT ON szczyty
    FOR EACH ROW
EXECUTE FUNCTION dodaj_szczyt();
