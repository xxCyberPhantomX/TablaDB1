import java.util.Scanner;

                    public class TablaBD {
                     public static void main(String[] args) {
                    VentaComputadorasDAO dao = new VentaComputadorasDAO();
                    Scanner scanner = new Scanner(System.in);

                    while (true) {
                        
                        
                        
                        
                        
            System.out.println("Seleccione una opción:");
        
            System.out.println("1. Insertar nueva computadora");
            System.out.println("2. Actualizar computadora");
         
            System.out.println("3. Eliminar computadora");
          
            System.out.println("4. Consultar computadoras");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

                        switch (opcion) {
                case 1:
                               System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    dao.insertarComputadora(nombre, marca, precio, cantidad);
                    break;

                        case 2:
                    System.out.print("ID de la computadora a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva marca: ");
                    String nuevaMarca = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    dao.actualizarComputadora(idActualizar, nuevoNombre, nuevaMarca, nuevoPrecio, nuevaCantidad);
                    break;

                case 3:
                    System.out.print("ID de la computadora a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    dao.eliminarComputadora(idEliminar);
                    break;

                case 4:
                    dao.consultarComputadoras();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
