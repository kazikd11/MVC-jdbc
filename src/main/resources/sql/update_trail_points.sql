UPDATE trail_points
SET trail_id = ?, ascend_time = ?, descend_time = ?, color = ?
WHERE point1_id = ? AND point2_id = ?;
