import java.awt.Button;
import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class VisualizarImagenesEspecimen {
    public void verImagenes() {
        
        JFrame frame = new JFrame("Ver imagenes / nombre cientifico");
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        
        //nombres columnas 
        model.addColumn("Imágen");
        model.addColumn("Nombre Científico"); 
        
        //modificar altura tablas
        table.setModel(model);
        table.setRowHeight(150); 
        
        //propiedades para visualizar la informacion
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel) {
                    JLabel label = (JLabel) value;
                    if (label.getIcon() instanceof ImageIcon) {
                        ImageIcon icon = (ImageIcon) label.getIcon();
                        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
                        label.setIcon(new ImageIcon(img));
                    }
                    return label;
                }
                return new JLabel(value != null ? value.toString() : "");
            }
        });
        
        //inicializar conexion
        Connection connection = null;
        
        
        try {
            connection = ConexionBD.getConnection();

            // Consulta para obtener las URLs y los nombres
            String sql = "SELECT i.url, e.scientificName " +
                         "FROM IMAGENES i " +
                         "JOIN especimen_imagenes ei ON i.id_foto = ei.id_foto " +
                         "JOIN Especimen e ON ei.id_especimen = e.catalogNumber";
            
            //guardar y ejecutar consulta 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterary agregar resultados de la consulta al modelo
            while (resultSet.next()) {
                String urlImagen = resultSet.getString("url");
                String scientificName = resultSet.getString("scientificName");

                JLabel label = new JLabel();
                try {
                    //obtener imagen
                    URL imageUrl = new URL(urlImagen); 
                    label.setIcon(new ImageIcon(imageUrl)); 
                } catch (MalformedURLException e) {
                    label.setText("URL error");
                } catch (Exception e) {
                    label.setText("Error al cargar imagen"); // Mensaje para otros errores
                }
                //ir agregando la imagen y nombre 
                model.addRow(new Object[]{label, scientificName}); 
            }

            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        //agregar al jframe
        
        
        frame.add(new JScrollPane(table));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        /*if(!frame.isActive()){
            Menu newFrame = new Menu();
            newFrame.setVisible(true);
        }*/
        //Menu newFrame = new Menu();
        
    }
}
