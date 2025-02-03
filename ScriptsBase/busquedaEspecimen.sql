--informacioni de especimen dado el nombre
CREATE OR REPLACE PROCEDURE infoEspecimen(
    p_nombreEspecimen TEXT
)
LANGUAGE plpgsql
AS $$
DECLARE
    especimen RECORD;
    especimen_cursor CURSOR FOR
        SELECT 
            e.catalogNumber, 
            e.scientificName, 
            e.lifeStage, 
            e.sex, 
            e.individualCount,
            t.taxonID,  
            t.ID_especimen,  
            t.Tipo,  
            t.scientificName AS taxonomia_scientificName,  
            k.name_kingdom AS kingdom,  
            p.name_phylum AS phylum,     
            c.name_class AS class,      
            o.name_order AS order,       
            f.name_family AS family,     
            g.genus AS genus        
        FROM Especimen e
        JOIN TAXONOMIA t ON e.catalogNumber = t.ID_especimen 
        LEFT JOIN kingdom k ON t.kingdom = k.ID_kingdom  
        LEFT JOIN phylum p ON t.phylum = p.id_phylum     
        LEFT JOIN class c ON t.class = c.id_class         
        LEFT JOIN "Order" o ON t."order" = o.id_order     
        LEFT JOIN family f ON t.family = f.id_family       
        LEFT JOIN Genus g ON t.genus = g.id_genus         
        WHERE e.scientificName = p_nombreEspecimen;

BEGIN
    OPEN especimen_cursor;
    LOOP
        FETCH especimen_cursor INTO especimen;
        EXIT WHEN NOT FOUND;

        RAISE NOTICE 'Catalog Number: %, Scientific Name: %, Life Stage: %, Sex: %, Individual Count: %, Taxon ID: %, ID Especimen: %, Tipo: %, Scientific Name (Taxonomia): %, Kingdom: %, Phylum: %, Class: %, Order: %, Family: %, Genus: %',
            especimen.catalogNumber,
            especimen.scientificName,
            especimen.lifeStage,
            especimen.sex,
            especimen.individualCount,
            especimen.taxonID,
            especimen.ID_especimen,
            especimen.Tipo,
            especimen.taxonomia_scientificName,
            especimen.kingdom,
            especimen.phylum,
            especimen.class,
            especimen.order,
            especimen.family,
            especimen.genus;
    END LOOP;
    CLOSE especimen_cursor;
END;
$$
;

--CALL infoEspecimen('Carabus auratus');

--informacion especimen
DROP FUNCTION IF EXISTS obtenerInfoEspecimen;
CREATE OR REPLACE FUNCTION obtenerInfoEspecimen()
RETURNS TABLE (
	--parametros que regresara
    catalogNumber TEXT,
    scientificName TEXT,
    lifeStage TEXT,
    sex TEXT,
    individualCount INTEGER,
    ID_Evento_Recoleccion INTEGER,
    estado_evento TEXT,  
    ID_metodo INTEGER,
    descripcion_metodo TEXT,
    localidad TEXT  
) AS $$
BEGIN
    RETURN QUERY
	--seleccionar la informacion para que el usuario pueda editar un especimen
    SELECT 
        e.catalogNumber::TEXT, 
        e.scientificName::TEXT, 
        e.lifeStage::TEXT, 
        e.sex::TEXT, 
        e.individualCount::INTEGER,
        e.ID_Evento_Recoleccion,
        ev.estado_del_evento AS estado_evento,  
        e.ID_metodo,
        m.descripcion_metodo AS descripcion_metodo,
        u.locality AS localidad 
    FROM Especimen e
    LEFT JOIN Evento_de_Coleccion ev ON e.ID_Evento_Recoleccion = ev.ID_Evento_Recoleccion
    LEFT JOIN metodoDePrepacion m ON e.ID_metodo = m.ID_preparacion
    LEFT JOIN Ubicacion u ON ev.ID_Ubicacion = u.ID_Ubicacion;
END;
$$
 LANGUAGE plpgsql;


--actualizar especimen
CREATE OR REPLACE PROCEDURE actualizar_especimen(
    p_catalogNumber INTEGER, 
    p_scientificName TEXT,
    p_lifeStage TEXT,
    p_sex TEXT,
    p_individualCount INTEGER,
    p_estado TEXT,
    p_ID_Evento_Recoleccion INTEGER,
    p_ID_metodo INTEGER
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Actualizar los detalles
    UPDATE Especimen
    SET 
        scientificName = p_scientificName,
        lifeStage = p_lifeStage,
        sex = p_sex,
        individualCount = p_individualCount,
        estado = p_estado,
        ID_Evento_Recoleccion = p_ID_Evento_Recoleccion,
        ID_metodo = p_ID_metodo
    WHERE catalogNumber = p_catalogNumber;  
END;
$$
;

--eliminar especimen
CREATE OR REPLACE PROCEDURE eliminar_especimen(
    p_catalogNumber INTEGER
)
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM Especimen
    WHERE catalogNumber = p_catalogNumber;
END;
$$
;

-- crear especimen
CREATE OR REPLACE PROCEDURE crear_especimen(
    p_scientificName TEXT,
    p_lifeStage TEXT DEFAULT NULL,
    p_sex TEXT DEFAULT NULL,
    p_individualCount INTEGER DEFAULT 1,
    p_estado TEXT DEFAULT 'pendiente_identificacion',
    p_ID_Evento_Recoleccion INTEGER DEFAULT NULL,
    p_ID_metodo INTEGER DEFAULT NULL
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Especimen (
        scientificName,
        lifeStage,
        sex,
        individualCount,
        estado,
        ID_Evento_Recoleccion,
        ID_metodo
    ) VALUES (
        p_scientificName,
        p_lifeStage,
        p_sex,
        p_individualCount,
        p_estado,
        p_ID_Evento_Recoleccion,
        p_ID_metodo
    );
END;
$$;

--recuperar informacion para crear especimen
DROP FUNCTION IF EXISTS consultar_info_especimen;
CREATE OR REPLACE FUNCTION consultar_info_especimen()
RETURNS TABLE (
    id_evento INTEGER,
    estado_evento TEXT,
    localidad TEXT 
) AS $$
BEGIN
    RETURN QUERY
        SELECT 
            ev.ID_Evento_Recoleccion AS id_evento,
            ev.estado_del_evento AS estado_evento,
            u.locality AS localidad 
        FROM 
            Evento_de_Coleccion ev
        LEFT JOIN 
            Ubicacion u ON ev.ID_Ubicacion = u.ID_Ubicacion;  
END;
$$
 LANGUAGE plpgsql;


--procedimiento para obtener informacion para agregar un especimen	
DROP FUNCTION IF EXISTS obtener_id_evento_ubicacion;

CREATE FUNCTION obtener_id_evento_ubicacion()
--valores que regresa para mostrar
RETURNS TABLE(
	id_evento INTEGER,
	estado_evento TEXT,
	localidad TEXT
) AS $$

BEGIN 
	RETURN QUERY
	SELECT 
		id_evento,
		estado_evento,
		localidad
	FROM
		Evento_de_Coleccion
	LEFT JOIN 
		Ubicacion ON Evento_de_Coleccion.ID_Ubicacion = Ubicacion.ID_Ubicacion;
END;
$$
LANGUAGE plpgsql;








