CREATE OR REPLACE PROCEDURE eliminar_especimen_por_estado(estado_especimen TEXT)
LANGUAGE plpgsql
AS $$
DECLARE
    nombre_eliminado TEXT;
BEGIN
    -- Cambiar la restricción de clave foránea para usar ON DELETE CASCADE
    ALTER TABLE TAXONOMIA
    DROP CONSTRAINT IF EXISTS taxonomia_id_especimen_fkey;

    ALTER TABLE TAXONOMIA
    ADD CONSTRAINT taxonomia_id_especimen_fkey
    FOREIGN KEY (ID_especimen) REFERENCES Especimen(catalogNumber)
    ON DELETE CASCADE;

    -- Eliminar los registros en Especimen con el estado indicado
    DELETE FROM Especimen
    WHERE estado = estado_especimen
    RETURNING scientificName INTO nombre_eliminado;

    IF nombre_eliminado IS NULL THEN
        RAISE NOTICE 'No se encontró ningún especimen con el estado: %', estado_especimen;
    END IF;
END;
$$;


CALL eliminar_especimen_por_estado('necesita_revision');
