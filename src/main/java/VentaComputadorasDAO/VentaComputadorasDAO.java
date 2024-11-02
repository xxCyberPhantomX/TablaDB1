import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

                        public class VentaComputadorasDAO {

                      public void insertarComputadora(String nombre, String marca, double precio, int cantidad) {
                           String query = "INSERT INTO computadoras_venta (nombre, marca, precio, cantidad) VALUES (?, ?, ?, ?)";
                          try (Connection conn = DatabaseConnection.getConnection();
                          PreparedStatement stmt = conn.prepareStatement(query)) {

           
                              
                              
                              stmt.setString(1, nombre);
            stmt.setString(2, marca);
            stmt.setDouble(3, precio);
            stmt.setInt(4, cantidad);
            stmt.executeUpdate();
            System.out.println("Computadora insertada .");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

                                     // Actualiza la maquina///
                public void actualizarComputadora(int id, String nombre, String marca, double precio, int cantidad) {
                  String query = "UPDATE computadoras_venta SET nombre = ?, marca = ?, precio = ?, cantidad = ? WHERE id = ?";
                try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, marca);
            stmt.setDouble(3, precio);
            stmt.setInt(4, cantidad);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Computadora actualizada .");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una computadora
    public void eliminarComputadora(int id) {
        String query = "DELETE FROM computadoras_venta WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Computadora eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar todas las computadoras
    public void consultarComputadoras() {
        String query = "SELECT * FROM computadoras_venta";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Marca: " + marca + 
                                   ", Precio: " + precio + ", Cantidad: " + cantidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
