INSERT INTO schroniska (nazwa, telefon, wewnetrzny_telefon, email, wlasciciel, status)
VALUES
    ('Schronisko Górskie 1', '123-456-789', '555-123-456', 'contact@schronisko1.pl', 'Jan Kowalski', TRUE),
    ('Schronisko Górskie 2', '987-654-321', '555-987-654', 'contact@schronisko2.pl', 'Anna Nowak', FALSE),
    ('Schronisko Górskie 3', '111-222-333', '555-111-222', 'contact@schronisko3.pl', 'Piotr Zawisza', TRUE);

INSERT INTO szczyty (nazwa, wysokosc)
VALUES
    ('Wielka Góra', 1500),
    ('Maly Szczyt', 1200),
    ('Szare Wzniesienie', 800);

INSERT INTO fragmenty_szlaku (punkt1_id, punkt2_id, szlak_id, czas, kolor)
VALUES
    (1, 2, 1, 20, 'czerwony'),
    (2, 3, 1, 20, 'czerwony'),
    (2, 3, 1, 20, 'czerwony'),
    (2, 3, 2, 15, 'niebieski'),
    (3, 4, 3, 25, 'zielony'),
    (1, 3, 4, 50, 'zolty'),
    (2, 1, 1, 30, 'czerwony'),
    (3, 2, 2, 15, 'niebieski'),
    (4, 3, 3, 25, 'zielony'),
    (3, 1, 4, 50, 'zolty');
