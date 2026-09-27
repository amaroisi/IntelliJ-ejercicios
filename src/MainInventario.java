public class MainInventario {
    public static void main(String[] args) {

        // 1. Instanciamos tres objetos independientes con new
        Producto productoUno = new Producto("P-001", "Teclado mecánico", 45000.0, 12);
        Producto productoDos = new Producto("P-002", "Mouse inalámbrico", 18000.0, 30);
        Producto productoTres = new Producto("P-003", "Monitor 24\"", 210000.0, 5);

        // Mostramos la ficha inicial de productoUno
        productoUno.mostrarFicha();

        // Caso válido: venta dentro del stock disponible
        productoUno.venderUnidades(3);

        // Caso de error: la cantidad supera el stock disponible
        productoUno.venderUnidades(50);

        // Reposición de stock
        productoUno.reponerStock(20);

        // Actualización de precio (sombreamiento resuelto con this.precio)
        productoUno.actualizarPrecio(39900.0);

        System.out.println();

        // 2. Verificamos que cada objeto tiene su propio estado en el Heap:
        // operar sobre productoUno no afecta a productoDos ni a productoTres.
        productoDos.venderUnidades(10);
        productoDos.reponerStock(5);
        productoTres.actualizarPrecio(195000.0);
        productoTres.venderUnidades(2);

        System.out.println();
        System.out.println("--- Estado independiente de cada objeto ---");
        productoUno.mostrarFicha();
        productoDos.mostrarFicha();
        productoTres.mostrarFicha();

        // 3. Alias vs. objeto nuevo
        Producto copia = productoUno;
        copia.stock = 29;
        // copia y productoUno son la MISMA referencia: apuntan al mismo objeto en el Heap.
        System.out.println("Stock de productoUno tras modificar copia: " + productoUno.stock
                + " (mismo objeto en el Heap)");

        // Para contrastar: un objeto nuevo con new NO comparte memoria con productoUno
        Producto nuevoIndependiente = new Producto(productoUno.codigo, productoUno.nombre,
                productoUno.precio, productoUno.stock);
        nuevoIndependiente.stock = 0;
        System.out.println("Stock de productoUno tras modificar un objeto NUEVO: " + productoUno.stock
                + " (no se afecta, son objetos distintos en el Heap)");

        System.out.println();

        // Desafío de extensión: aplicarDescuento
        productoDos.aplicarDescuento(15);
        productoDos.aplicarDescuento(150); // caso de error: fuera de rango

        System.out.println();

        // Desafío de extensión: arreglo de productos recorrido con for
        Producto[] inventario = { productoUno, productoDos, productoTres };
        System.out.println("--- Recorriendo el inventario con un arreglo ---");
        for (int i = 0; i < inventario.length; i++) {
            inventario[i].mostrarFicha();
        }
    }
}

