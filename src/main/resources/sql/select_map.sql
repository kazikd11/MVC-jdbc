SELECT
    tp.trail_id,
    tp.point1_id,
    tp.point2_id,
    tp.travel_time,
    tp.color
FROM trail_points tp
ORDER BY tp.trail_id, tp.point1_id;
