SELECT
    tp.szlak_id,
    tp.punkt1_id,
    tp.punkt2_id,
    tp.czas,
    tp.kolor
FROM fragmenty_szlaku tp
ORDER BY tp.szlak_id, tp.punkt1_id;
