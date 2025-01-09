CREATE OR REPLACE FUNCTION usun_schronisko()
    RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM fragmenty_szlaku
    WHERE punkt1_id = OLD.id OR punkt2_id = OLD.id;

    DELETE FROM punkty WHERE id = OLD.id;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION usun_szczyt()
    RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM fragmenty_szlaku
    WHERE punkt1_id = OLD.id OR punkt2_id = OLD.id;

    DELETE FROM punkty WHERE id = OLD.id;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER po_usunieciu_schroniska
    AFTER DELETE ON schroniska
    FOR EACH ROW
EXECUTE FUNCTION usun_schronisko();

CREATE TRIGGER po_usunieciu_szczytu
    AFTER DELETE ON szczyty
    FOR EACH ROW
EXECUTE FUNCTION usun_szczyt();
