package cliente;

import interfaces.Vendible;
import productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String correo;
    private List<Producto> productosComprados;
    private List<Integer> cantidadesCompradas;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.productosComprados = new ArrayList<>();
        this.cantidadesCompradas = new ArrayList<>();
    }

    public void comprarProducto(Producto producto, int cantidad) {
        if (cantidad <= producto.getCantidadStock()) {
            productosComprados.add(producto);
            cantidadesCompradas.add(cantidad);
            producto.reducirStock(cantidad);
        } else {
            System.out.println("No hay suficiente stock para " + producto.getNombre());
        }
    }

    public void mostrarCompra() {
        double total = 0;
        System.out.println("Resumen de compras para " + nombre + ":");
        for (int i = 0; i < productosComprados.size(); i++) {
            Producto producto = productosComprados.get(i);
            int cantidad = cantidadesCompradas.get(i);
            double precioVenta = ((Vendible) producto).calcularPrecioVenta(cantidad);
            total += precioVenta;
            producto.mostrarDetalles();
            System.out.println("Cantidad: " + cantidad + ", Costo Total: $" + precioVenta);
        }
        System.out.println("Costo total de la compra: $" + total);
    }

    public String getNombre() {
        return nombre;
    }
}
