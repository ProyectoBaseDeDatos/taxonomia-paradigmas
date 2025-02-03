import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JOptionPane; // Importa JOptionPane

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reporte {

    //obtener datos de los usuarios
    public static ResultSet obtenerDatosUsuarios(Connection conn) {
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM consultar_todos_usuarios_return()";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println("Error al obtener los datos de usuarios: " + e.getMessage());
        }
        return rs;
    }

    // obtener datos de los especímenes
    public static ResultSet obtenerDatosEspecimen(Connection conn) {
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM obtenerInfoEspecimen()";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println("Error al obtener los datos de especímenes: " + e.getMessage());
        }
        return rs;
    }

    // Método para generar el PDF con dos tablas
    public static void generarPDF() throws SQLException {
        Connection conn = ConexionBD.getConnection(); 
        if (conn == null) {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
            return;
        }

        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));
            documento.open();
            documento.add(new Paragraph("Reporte de Usuarios y Especímenes"));

            // Define una fuente con un tamaño 
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

            // Tabla para los usuarios
            PdfPTable tablaUsuarios = new PdfPTable(6); 
            tablaUsuarios.setWidthPercentage(100); 
            tablaUsuarios.setWidths(new float[]{1, 2, 1, 2, 1, 1}); 

            // Agrega encabezados 
            tablaUsuarios.addCell(new Paragraph("ID Usuario", font));
            tablaUsuarios.addCell(new Paragraph("Nombre", font));
            tablaUsuarios.addCell(new Paragraph("ID Persona", font));
            tablaUsuarios.addCell(new Paragraph("Email", font));
            tablaUsuarios.addCell(new Paragraph("Rol", font));
            tablaUsuarios.addCell(new Paragraph("ID Rol", font));

            ResultSet rsUsuarios = obtenerDatosUsuarios(conn);
            while (rsUsuarios != null && rsUsuarios.next()) {
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("id_usuario"), font));
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("nombre"), font));
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("id_persona"), font));
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("email"), font));
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("nombre_rol"), font));
                tablaUsuarios.addCell(new Paragraph(rsUsuarios.getString("id_rol"), font));
            }

            documento.add(tablaUsuarios);

            // Agregar un salto de linea
            documento.add(new Paragraph("\n"));

            // Tabla para los especímenes
            PdfPTable tablaEspecimen = new PdfPTable(10); // Número de columnas
            tablaEspecimen.setWidthPercentage(100); 
            
            // Ajusta los anchos de las columnas
            tablaEspecimen.setWidths(new float[]{1, 2, 1, 1, 1, 1, 1, 0.5f, 2, 1}); 

            // Agrega encabezados
            tablaEspecimen.addCell(new Paragraph("catalogNumber", font));
            tablaEspecimen.addCell(new Paragraph("scientificName", font));
            tablaEspecimen.addCell(new Paragraph("lifeStage", font));
            tablaEspecimen.addCell(new Paragraph("sex", font));
            tablaEspecimen.addCell(new Paragraph("individualCount", font));
            tablaEspecimen.addCell(new Paragraph("ID_Evento", font));
            tablaEspecimen.addCell(new Paragraph("EstadoEvento", font));
            tablaEspecimen.addCell(new Paragraph("ID Metodo", font)); 
            tablaEspecimen.addCell(new Paragraph("descriptionMethod", font));
            tablaEspecimen.addCell(new Paragraph("locality", font));

            ResultSet rsEspecimen = obtenerDatosEspecimen(conn);
            while (rsEspecimen != null && rsEspecimen.next()) {
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("catalogNumber"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("scientificName"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("lifeStage"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("sex"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("individualCount"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("ID_Evento_Recoleccion"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("estado_evento"), font));                
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("ID_metodo"), font)); 
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("descripcion_metodo"), font));
                tablaEspecimen.addCell(new Paragraph(rsEspecimen.getString("localidad"), font));
            }

            documento.add(tablaEspecimen);

             // Muestra un JOptionPane indicando que el reporte se creo
             JOptionPane.showMessageDialog(null, "El reporte se generó con éxito.", "Reporte Generado", JOptionPane.INFORMATION_MESSAGE);
             
        } catch (DocumentException | java.io.IOException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close(); 
                documento.close(); 
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
