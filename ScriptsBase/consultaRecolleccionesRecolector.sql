CREATE OR REPLACE PROCEDURE infoRecolecciones(
    id_trabajador INT
)

LANGUAGE plpgsql
AS $$
DECLARE
	recoleccion RECORD;
	recoleccion_cursor CURSOR FOR
	
    SELECT 
        e.ID_Evento_Recoleccion,
        e.event_date,
        e.ID_Ubicacion,
        e.ID_RECOLECTOR
    FROM 
        Evento_de_Coleccion e
	

	WHERE e.ID_RECOLECTOR = id_trabajador;

    trabajador RECORD;
    rol RECORD;
    ubicacion RECORD;
    persona RECORD;
	especimen RECORD;

BEGIN
    OPEN recoleccion_cursor;
    LOOP
        FETCH recoleccion_cursor INTO recoleccion;
        EXIT WHEN NOT FOUND;

        -- Obtener información del trabajador
        SELECT t.ID_TRABAJADOR, t.ID_PERSONA, t.role INTO trabajador
        FROM TRABAJADOR t
        WHERE t.ID_TRABAJADOR = recoleccion.ID_RECOLECTOR;

        -- Obtener el rol del trabajador
        SELECT r.ID_Rol, r.nombre INTO rol
        FROM Rol r
        WHERE r.ID_Rol = trabajador.role;

        -- Obtener la ubicación del recoleccion
        SELECT u.ID_Ubicacion, decimalLatitude, decimalLongitude , locality , habitat , notas , pais INTO ubicacion
        FROM Ubicacion u
        WHERE u.ID_Ubicacion = recoleccion.ID_Ubicacion;

        -- Obtener información de la persona asociada al trabajador
        SELECT p.ID_Persona, p.nombre INTO persona
        FROM Persona p
        WHERE p.ID_Persona = trabajador.ID_PERSONA;

		-- Obtener información del especimen asociado al evento de recolección
		SELECT s.catalogNumber, s.scientificName, s.lifeStage, s.sex, s.individualCount, s.estado INTO especimen
        FROM Especimen s
        WHERE s.ID_Evento_Recoleccion = recoleccion.ID_Evento_Recoleccion;

        -- Mostrar los resultados con RAISE NOTICE
        RAISE NOTICE 'Evento ID: %, Fecha: %, Ubicacion: %, Recolector: %, Rol: %, Persona: %, Especimen Catalog Number: %, Scientific Name: %, Life Stage: %, Sex: %, Individual Count: %, Estado: %',
            recoleccion.ID_Evento_Recoleccion,
            recoleccion.event_date,
            ubicacion.locality,
            persona.nombre,
            rol.nombre,
            persona.nombre,
			especimen.catalogNumber,
            especimen.scientificName,
            especimen.lifeStage,
            especimen.sex,
            especimen.individualCount,
            especimen.estado;
    END LOOP;
    CLOSE recoleccion_cursor;
END;
$$;

CALL infoRecolecciones(1);