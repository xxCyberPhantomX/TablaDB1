import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

                                        public class DatabaseConnection {
                                        private static Connection connection;

                                        public static Connection getConnection() {
              
                                            
                                            
                                            if (connection == null) {
                try {
                Properties props = new Properties();
                InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
                props.load(input);
                
               
                
                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");

               
                
                
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Conexión exitosa .");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
