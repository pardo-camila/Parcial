import productos.Laptop;
import productos.Celular;
import cliente.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 3
Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        // Crear productos disponibles en inventario
        Laptop laptop1 = new Laptop("MacBook Pro", "Apple", 2000.0, 10, "M1", 16);
        Celular celular1 = new Celular("Galaxy S21", "Samsung", 800.0, 15, 4000, 64);

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar nuevo cliente y realizar compra");
            System.out.println("2. Mostrar resumen de compra de un cliente");
            System.out.println("3. Mostrar resumen de compra de todos los clientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Agregar nuevo cliente y realizar compra
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el correo del cliente: ");
                    String correoCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nombreCliente, correoCliente);
                    clientes.add(cliente);

                    int opcionCompra;
                    do {
                        System.out.println("\n--- Menú de Compra para " + nombreCliente + " ---");
                        System.out.println("1. Comprar Laptop");
                        System.out.println("2. Comprar Celular");
                        System.out.println("3. Finalizar compra de este cliente");
                        System.out.print("Seleccione una opción: ");
                        opcionCompra = scanner.nextInt();

                        switch (opcionCompra) {
                            case 1:
                                // Comprar Laptop
                                System.out.print("Ingrese la cantidad de laptops que desea comprar: ");
                                int cantidadLaptop = scanner.nextInt();
                                cliente.comprarProducto(laptop1, cantidadLaptop);
                                break;

                            case 2:
                                // Comprar Celular
                                System.out.print("Ingrese la cantidad de celulares que desea comprar: ");
                                int cantidadCelular = scanner.nextInt();
                                cliente.comprarProducto(celular1, cantidadCelular);
                                break;

                            case 3:
                                System.out.println("Compra finalizada para el cliente " + nombreCliente + ".");
                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, intente nuevamente.");
                                break;
                        }
                    } while (opcionCompra != 3);
                    break;

                case 2:
                    // Mostrar resumen de compra de un cliente específico
                    System.out.print("Ingrese el nombre del cliente para ver el resumen de compra: ");
                    String nombreBusqueda = scanner.nextLine();
                    Cliente clienteEncontrado = null;
                    for (Cliente c : clientes) {
                        if (c.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                            clienteEncontrado = c;
                            break;
                        }
                    }
                    if (clienteEncontrado != null) {
                        clienteEncontrado.mostrarCompra();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    // Mostrar resumen de compra de todos los clientes
                    System.out.println("\n--- Resumen de Compra de Todos los Clientes ---");
                    for (Cliente c : clientes) {
                        System.out.println("\nCliente: " + c.getNombre());
                        c.mostrarCompra();
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("Gracias por utilizar el sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 4);

        // Mostrar inventario actualizado antes de salir
        System.out.println("\nInventario actualizado:");
        laptop1.mostrarDetalles();
        celular1.mostrarDetalles();

        scanner.close();
    }
}