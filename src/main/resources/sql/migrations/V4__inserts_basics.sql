INSERT INTO shelters (name, phone_number, internal_phone_number, email, owner, status)
VALUES
    ('Schronisko Górskie 1', '123-456-789', '555-123-456', 'contact@schronisko1.pl', 'Jan Kowalski', TRUE),
    ('Schronisko Górskie 2', '987-654-321', '555-987-654', 'contact@schronisko2.pl', 'Anna Nowak', FALSE),
    ('Schronisko Górskie 3', '111-222-333', '555-111-222', 'contact@schronisko3.pl', 'Piotr Zawisza', TRUE);

INSERT INTO peaks (name, height)
VALUES
    ('Wielka Góra', 1500),
    ('Maly Szczyt', 1200),
    ('Szare Wzniesienie', 800);

INSERT INTO trail_points (point1_id, point2_id, trail_id, travel_time, color)
VALUES
    (1, 2, 1, 20, 'red'),
    (2, 3, 1, 15, 'blue'),
    (3, 4, 1, 25, 'green'),
    (1, 3, 1, 50, 'yellow'),
    (2, 1, 1, 30, 'red'),
    (3, 2, 1, 15, 'blue'),
    (4, 3, 1, 25, 'green'),
    (3, 1, 1, 50, 'yellow');
