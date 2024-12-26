CREATE OR REPLACE FUNCTION add_shelter() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO points DEFAULT VALUES;
    NEW.id := currval('points_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION add_peak() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO points DEFAULT VALUES;
    NEW.id := currval('points_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--

CREATE TRIGGER before_insert_shelter
    BEFORE INSERT ON shelters
    FOR EACH ROW
EXECUTE FUNCTION add_shelter();

CREATE TRIGGER before_insert_peak
    BEFORE INSERT ON peaks
    FOR EACH ROW
EXECUTE FUNCTION add_peak();
