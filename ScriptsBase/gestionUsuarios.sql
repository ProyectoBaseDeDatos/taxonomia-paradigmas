--procedimiento para crear un usuario
CREATE OR REPLACE PROCEDURE crear_usuario(
	--parametros necesarios
    p_id_persona INT,
    p_contraseña VARCHAR,
    p_email VARCHAR,
    p_id_rol INT
)
LANGUAGE plpgsql
AS $$
BEGIN
-- insertar en las tablas correspondientes
    INSERT INTO usuario (id_persona, id_usuario, contraseña, email)
    VALUES (p_id_persona, gen_random_uuid(), p_contraseña, p_email);
    
    INSERT INTO TRABAJADOR (ID_PERSONA, id_role) 
    VALUES (p_id_persona, p_id_rol);
END;
$$;

-- procedimiento para actualizar un usuario
CREATE OR REPLACE PROCEDURE actualizar_usuario(
    p_id_persona INT, 
    p_nombre VARCHAR,
    p_contraseña VARCHAR,
    p_email VARCHAR,
    p_id_rol INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Actualizar el nombre 
    UPDATE Persona
    SET 
        nombre = p_nombre 
    WHERE ID_Persona = p_id_persona;  

    -- Actualizar la contraseña si se proporciona
    IF p_contraseña IS NOT NULL AND LENGTH(p_contraseña) >= 8 THEN
    UPDATE usuario
    SET 
        contraseña = p_contraseña
    WHERE id_persona = p_id_persona;
END IF;


    -- Actualizar el email si se proporciona
    IF p_email IS NOT NULL THEN
        UPDATE usuario
        SET 
            email = p_email
        WHERE id_persona = p_id_persona;
    END IF;

    -- Actualizar rol del trabajador
    UPDATE TRABAJADOR
    SET id_role = p_id_rol 
    WHERE ID_PERSONA = p_id_persona;
	
END;
$$;




--procedimiento para consultar un usuario
CREATE OR REPLACE PROCEDURE consultar_usuario(
    p_id_usuario UUID
)
LANGUAGE plpgsql
AS $$
DECLARE
    rec RECORD;  
    cur CURSOR FOR 
        SELECT 
            u.id_usuario,
            p.nombre,
            u.id_persona,
            u.email,
            r.nombre AS rol_nombre
        FROM usuario u
        JOIN Persona p ON u.id_persona = p.ID_Persona 
        JOIN TRABAJADOR t ON p.ID_Persona = t.ID_PERSONA
        JOIN Rol r ON t.id_role = r.ID_Rol 
        WHERE u.id_usuario = p_id_usuario;
BEGIN
    OPEN cur;  
    LOOP
        FETCH cur INTO rec;  
        EXIT WHEN NOT FOUND;  
        RAISE NOTICE 'ID Usuario: %, Nombre: %, ID Persona: %, Email: %, Rol: %',
                     rec.id_usuario, rec.nombre, rec.id_persona, rec.email, rec.rol_nombre;
    END LOOP;
    CLOSE cur;  
END;
$$
;

--consultar todos los usuarios
CREATE OR REPLACE PROCEDURE consultar_todos_usuarios()
LANGUAGE plpgsql
AS $$
DECLARE
    rec RECORD;  
    cur CURSOR FOR 
        SELECT 
            usuario.id_usuario,
            Persona.nombre,
            Persona.ID_Persona,
            usuario.email,
            Rol.nombre AS nombre_rol,
            Rol.ID_Rol AS id_rol  
        FROM usuario
        JOIN Persona ON usuario.id_persona = Persona.ID_Persona 
        JOIN TRABAJADOR ON Persona.ID_Persona = TRABAJADOR.ID_PERSONA 
        JOIN Rol ON TRABAJADOR.id_role = Rol.ID_Rol;
BEGIN
    OPEN cur;  
    LOOP
        FETCH cur INTO rec;  
        EXIT WHEN NOT FOUND;  
        RAISE NOTICE 'ID Usuario: %, Nombre: %, ID Persona: %, Email: %, Rol: %, ID Rol: %',
                     rec.id_usuario, rec.nombre, rec.ID_Persona, rec.email, rec.nombre_rol, rec.id_rol;  -- Agregado ID Rol
    END LOOP;
    CLOSE cur;  
END;
$$;






--procedimiento para eliminar usuario
CREATE OR REPLACE PROCEDURE eliminar_usuario(
    p_id_persona INTEGER  
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Eliminar de la tabla TRABAJADOR 
    DELETE FROM TRABAJADOR
    WHERE ID_PERSONA = p_id_persona;

    DELETE FROM usuario
    WHERE id_persona = p_id_persona;
END;
$$;


DROP FUNCTION IF EXISTS consultar_todos_usuarios_return;
CREATE OR REPLACE FUNCTION consultar_todos_usuarios_return()
--informacion necesaria para actualizar el usuario
RETURNS TABLE (
    id_usuario UUID,
    nombre TEXT,
    id_persona INTEGER,
    email TEXT,
    nombre_rol TEXT,
    id_rol INT  
) AS $$
BEGIN
	--regresar los datos en una tabla 	
    RETURN QUERY
        SELECT 
            usuario.id_usuario,
            Persona.nombre,
            Persona.ID_Persona,
            usuario.email,
            Rol.nombre AS nombre_rol,
            Rol.ID_Rol AS id_rol  
        FROM usuario
        JOIN Persona ON usuario.id_persona = Persona.ID_Persona 
        JOIN TRABAJADOR ON Persona.ID_Persona = TRABAJADOR.ID_PERSONA 
        JOIN Rol ON TRABAJADOR.id_role = Rol.ID_Rol;
END;
$$
 LANGUAGE plpgsql;


 --Obtener roles y personas
DROP IF EXISTS FUNCTION obtener_roles();
CREATE OR REPLACE FUNCTION obtener_roles()
RETURNS TABLE (
    ID_Rol INTEGER,
    nombre_rol TEXT
) AS $$
BEGIN
    RETURN QUERY
    SELECT Rol.ID_Rol, Rol.nombre
    FROM Rol;
END;
$$ LANGUAGE plpgsql;


--personas
CREATE OR REPLACE FUNCTION obtener_personas()
RETURNS TABLE (
    ID_Persona INTEGER,
    nombre_persona TEXT
) AS $$
BEGIN
    RETURN QUERY
    SELECT Persona.ID_Persona, Persona.nombre
    FROM Persona;
END;
$$ LANGUAGE plpgsql;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
--login
DROP FUNCTION IF EXISTS iniciar_sesion;
-- recibe correo y contraseña como parametros
CREATE OR REPLACE FUNCTION iniciar_sesion(
    comprobar_email TEXT,
    comprobar_contrasenia TEXT
) RETURNS TABLE(mensaje TEXT, id_usuario INTEGER) AS $$ -- regresa el mensaje dependiendo el inicio de sesion 
                                                        --y el id si lo encontro
DECLARE
    v_id_usuario INTEGER;
    v_id_role INTEGER;
BEGIN
	--buscar el email y contraseña en la base
    SELECT u.ID_Persona, t.id_role INTO v_id_usuario, v_id_role
    FROM usuario u
    JOIN Persona p ON u.id_Persona = p.ID_Persona
    JOIN TRABAJADOR t ON p.ID_PersonA = t.ID_PERSONA
    WHERE u.email = comprobar_email 
      AND u.contraseña = comprobar_contrasenia;
	
    IF v_id_usuario IS NOT NULL THEN
		--si encontro y coincide con el rol correspondiente
        IF v_id_role = 3 THEN
            RETURN QUERY SELECT 'LOGIN_OK', v_id_usuario; --regresar inicio de sesion correcto
        ELSE
            RETURN QUERY SELECT 'NO_PRIVILEGIO', NULL::INTEGER; -- regresar esto si no coincide con el rol correspondiente
        END IF;
    ELSE
        RETURN QUERY SELECT 'NO_LOGIN', NULL::INTEGER; --si no se encontro nada
    END IF;
END;
$$
 LANGUAGE plpgsql;


DROP FUNCTION IF EXISTS Obtener_metodosPreparacion();
CREATE OR REPLACE FUNCTION Obtener_metodosPreparacion()
RETURNS
TABLE(
    id_preparacion INTEGER,
    descripcion_metodo TEXT
) AS $$
BEGIN

    RETURN QUERY
        SELECT ID_preparacion as id_preparacion, descripcion_metodo
        FROM metodoDePrepacion;

END;$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_personas_sin_rol()
RETURNS TABLE (id_persona INTEGER, nombre TEXT) AS $$
BEGIN
    RETURN QUERY
    SELECT p.ID_Persona, p.nombre
    FROM Persona p
    LEFT JOIN TRABAJADOR t ON p.ID_Persona = t.ID_PERSONA
    WHERE t.ID_PERSONA IS NULL;
END;
$$ LANGUAGE plpgsql;



 
--CALL crear_usuario(1, 'miContraseñaSegura123', 'usuario1@example.com', 2);

--CALL actualizar_usuario('a8bf3fa8-3a86-46a2-b401-134004f35c03', 'nuevaContraseña456', 'nuevoEmail@example.com', 3);

--CALL consultar_usuario('1e6015c7-2ec4-4b97-a0c1-d0746ac1a569');

--CALL consultar_todos_usuarios();

--CALL eliminar_usuario('a8bf3fa8-3a86-46a2-b401-134004f35c03');
--SELECT * FROM usuario;

