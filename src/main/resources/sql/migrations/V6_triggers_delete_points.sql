CREATE OR REPLACE FUNCTION delete_shelter()
    RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM trail_points
    WHERE point1_id = OLD.id OR point2_id = OLD.id;

    DELETE FROM points WHERE id = OLD.id;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_peak()
    RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM trail_points
    WHERE point1_id = OLD.id OR point2_id = OLD.id;

    DELETE FROM points WHERE id = OLD.id;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_shelter_delete
    AFTER DELETE ON shelters
    FOR EACH ROW
EXECUTE FUNCTION delete_shelter();

CREATE TRIGGER after_peak_delete
    AFTER DELETE ON peaks
    FOR EACH ROW
EXECUTE FUNCTION delete_peak();
