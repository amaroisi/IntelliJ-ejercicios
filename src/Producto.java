public class Producto {
    public String nombre;
    public String codigo;
    public double precio;
    public int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void venderUnidades(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a vender debe ser mayor a cero.");
            return;
        }
        if (cantidad > stock) {
            System.out.println("Error: stock insuficiente para vender " + cantidad
                    + " unidades de " + nombre + ".");
            return;
        }
        stock -= cantidad;
        System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre
                + ". Stock restante: " + stock);
    }

    public void reponerStock(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a reponer debe ser mayor a cero.");
            return;
        }
        stock += cantidad;
        System.out.println("Reposición registrada: +" + cantidad + " unidades. Stock actual: " + stock);
    }

    // El parámetro "precio" sombrea al atributo "precio"; this.precio lo desambigua.
    public void actualizarPrecio(double precio) {
        double precioAnterior = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de " + nombre + ": $" + precioAnterior
                + " -> $" + this.precio);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje <= 0 || porcentaje > 100) {
            System.out.println("Error: el porcentaje de descuento debe estar entre 0 y 100.");
            return;
        }
        double precioAnterior = this.precio;
        this.precio = this.precio - (this.precio * porcentaje / 100);
        System.out.println("Descuento del " + porcentaje + "% aplicado a " + nombre
                + ": $" + precioAnterior + " -> $" + this.precio);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código:  " + codigo);
        System.out.println("Nombre:  " + nombre);
        System.out.println("Precio:  $" + precio);
        System.out.println("Stock:   " + stock);
        System.out.println("==========================");
    }
}
