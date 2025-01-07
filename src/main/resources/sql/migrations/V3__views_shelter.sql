CREATE OR REPLACE VIEW client_shelters_view AS
SELECT id,
       name,
       status,
       email,
       phone_number
FROM shelters;

CREATE OR REPLACE VIEW admin_shelters_view AS
SELECT *
FROM shelters;
