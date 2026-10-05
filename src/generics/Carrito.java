package generics;

import java.util.*;

public class Carrito <T extends Vendible> implements Iterable<T> {
    private List<T> t;
    private String nombre;

    public Carrito(String nombre){
        this.nombre = nombre;
        this.t = new ArrayList<>();
    }
    public Collection<T> getListProductos(){
        return Collections.unmodifiableCollection(t);
    }

    public void agregar(T item) {
        t.add(item);
    }

    public T obtenerMasCaro() {
        if (t.isEmpty()) {
            return null;
        }
        T masCaro = t.get(0);
        for (T item : t) {
            if (item.getPrecio() > masCaro.getPrecio()) {
                masCaro = item;
            }
        }
        return masCaro;
    }

    public double calcularTotal() {
        double total = 0;
        for (T item : t) {
            total += item.getPrecio() * item.getCantidad();
        }
        return total;
    }

    @Override
    public CarritoIterator<T> iterator(){
        return new CarritoIterator<>(t);
    }

}
