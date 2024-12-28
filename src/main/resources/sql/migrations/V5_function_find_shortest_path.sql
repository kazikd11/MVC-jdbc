CREATE OR REPLACE FUNCTION find_shortest_path(start_point INT, end_point INT)
    RETURNS TABLE (point_id INT, total_time INT) AS $$
DECLARE
    current_id INT := start_point;
    t_time INT := 0;
    visited_points INT[] := ARRAY[start_point];
BEGIN
    RETURN QUERY SELECT current_id, t_time;

    LOOP
        SELECT tp.point2_id, t_time + tp.travel_time
        INTO current_id, t_time
        FROM trail_points tp
        WHERE tp.point1_id = current_id AND tp.point2_id NOT IN (SELECT UNNEST(visited_points))
        ORDER BY tp.travel_time ASC
        LIMIT 1;

        IF current_id = end_point THEN
            RETURN QUERY SELECT current_id, t_time;
            EXIT;
        END IF;

        IF NOT FOUND THEN
            RAISE EXCEPTION 'Brak drogi';
        END IF;

        visited_points := ARRAY_APPEND(visited_points, current_id);
        RETURN QUERY SELECT current_id, t_time;
    END LOOP;
END;
$$ LANGUAGE plpgsql;
