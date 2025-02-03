CREATE OR REPLACE PROCEDURE asignar_trabajador_institucion(
    p_trabajador_id INT,
    p_instituto_id INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO TRABAJADOR_INSTITUCION (ID_TRABAJADOR, ID_INSTITUCION)
    VALUES (p_trabajador_id, p_instituto_id);
END;
$$;
CALL asignar_trabajador_institucion(5,1);