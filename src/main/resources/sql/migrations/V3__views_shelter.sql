CREATE OR REPLACE VIEW widok_schronisk_klienta AS
SELECT id,
       nazwa,
       status,
       email,
       telefon
FROM schroniska;

CREATE OR REPLACE VIEW widok_schronisk_admina AS
SELECT *
FROM schroniska;
