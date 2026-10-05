package generics;

//Un e-commerce necesita un carrito de compras generico donde, -se pueda agregar productos
// - obtener el producto de mayor precio
// - Calcular el precio total



public class EcommerceT1 {

    public static void main(String[] args) {
            Carrito<Vendible> carrito = new Carrito<Vendible>("C2");
            carrito.agregar(new Mouse("Mouse", 234, 1));
            carrito.agregar(new Laptop("Pera", 4456, 2));
            carrito.agregar(new Mouse("Mouse gamer", 300, 3));
            carrito.agregar(new Laptop("Laptop gamer", 5000, 1));
            carrito.agregar(new Mouse("Mouse barato", 50, 5));

            System.out.println("--- Recorrido normal ---");
            CarritoIterator<Vendible> it1 = carrito.iterator();
            while (it1.hasNext()) {
                Vendible v = it1.next();
                System.out.println(v);
            }

            System.out.println("--- Salto de 2 en 2 ---");
            CarritoIterator<Vendible> it2 = carrito.iterator();
            while (it2.hasNextSalto()) {
                Vendible v = it2.saltarNext();
                System.out.println(v);
            }

            System.out.println("--- Ir a una posición ---");
            CarritoIterator<Vendible> it3 = carrito.iterator();
            if (it3.hasPosicion(3)) {
                Vendible v = it3.irA(3);
                System.out.println("Posición 3: " + v);
            }
            while (it3.hasNext()) {
                System.out.println("Siguiente: " + it3.next());
            }

            // Posición que no existe
            System.out.println("--- Posición inválida ---");
            CarritoIterator<Vendible> it4 = carrito.iterator();
            System.out.println("¿Existe la posición 10? " + it4.hasPosicion(10));

            System.out.println("--- Pares hacia atrás ---");
            CarritoIterator<Vendible> it5 = carrito.iterator();
            while (it5.hasParesAtras()) {
                Vendible v = it5.paresHaciaAtras();
                System.out.println(v);
            }

            // Extras del carrito
            System.out.println("--- Carrito ---");
            System.out.println("Más caro: " + carrito.obtenerMasCaro());
            System.out.println("Total: " + carrito.calcularTotal());

    }
}


