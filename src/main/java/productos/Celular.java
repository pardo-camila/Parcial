package productos;

import interfaces.Vendible;

public class Celular extends Producto implements Vendible {
    private int capacidadBateria;
    private int camaraResolucion;

    public Celular(String nombre, String marca, double precio, int cantidadStock, int capacidadBateria, int camaraResolucion) {
        super(nombre, marca, precio, cantidadStock);
        this.capacidadBateria = capacidadBateria;
        this.camaraResolucion = camaraResolucion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Celular - " + nombre + ", Marca: " + marca + ", Precio: $" + precio +
                ", Stock: " + cantidadStock + ", Batería: " + capacidadBateria +
                "mAh, Resolución de Cámara: " + camaraResolucion + "MP");
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