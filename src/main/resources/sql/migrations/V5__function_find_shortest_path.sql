CREATE OR REPLACE FUNCTION znajdz_najkrotsza_droge(start_point INT, end_point INT)
    RETURNS TABLE (punkt_id INT, calkowity_czas INT) AS $$
DECLARE
    current_id INT := start_point;
    t_time INT := 0;
    odwiedzone_punkty INT[] := ARRAY[start_point];
BEGIN
    RETURN QUERY SELECT current_id, t_time;

    LOOP
        SELECT tp.punkt2_id, t_time + tp.czas
        INTO current_id, t_time
        FROM fragmenty_szlaku tp
        WHERE tp.punkt1_id = current_id AND tp.punkt2_id NOT IN (SELECT UNNEST(odwiedzone_punkty))
        ORDER BY tp.czas ASC
        LIMIT 1;

        IF current_id = end_point THEN
            RETURN QUERY SELECT current_id, t_time;
            EXIT;
        END IF;

        IF NOT FOUND THEN
            RAISE EXCEPTION 'Brak drogi';
        END IF;

        odwiedzone_punkty := ARRAY_APPEND(odwiedzone_punkty, current_id);
        RETURN QUERY SELECT current_id, t_time;
    END LOOP;
END;
$$ LANGUAGE plpgsql;
