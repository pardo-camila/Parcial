package productos;

import interfaces.Vendible;

public class Laptop extends Producto implements Vendible {
    private String procesador;
    private int memoriaRAM;

    public Laptop(String nombre, String marca, double precio, int cantidadStock, String procesador, int memoriaRAM) {
        super(nombre, marca, precio, cantidadStock);
        this.procesador = procesador;
        this.memoriaRAM = memoriaRAM;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Laptop - " + nombre + ", Marca: " + marca + ", Precio: $" + precio +
                ", Stock: " + cantidadStock + ", Procesador: " + procesador +
                ", RAM: " + memoriaRAM + "GB");
    }

    @Override
    public double calcularPrecioVenta(int cantidad) {
        double total = cantidad * precio;
        if (cantidad > 5) {
            total *= 0.9; // 10% de descuento
        }
        return total;
    }
}