package generics;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CarritoIterator<T> implements Iterator<T> {

    int indice = 0;
    List<T> lista;

    public CarritoIterator(List<T> lista){
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return indice < lista.size();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("NO hay elementos");
        }
        T t = lista.get(indice);
        indice++;
        return t;
    }

    public boolean tieneParaAtras() {
        return indice >= 0;
    }
    public T deparaAtras(){

        if(!tieneParaAtras()){
            throw new NoSuchElementException("NO hay elementos");
        }
        T t = lista.get(indice);
        indice--;
        return t;
    }

    public boolean hasNextSalto() {
        if((indice + 2 < lista.size())){
            return true;
        }else return  false;
    }

    public T saltarNext() {

        if(!(indice + 2 < lista.size())){
            throw new NoSuchElementException("NO hay elementos");
        }

        T t = lista.get(indice);
        indice += 2;
        return t;

    }

    public boolean hasPosicion(int pos) {
        return pos >= 0 && pos < lista.size();
    }

    public T irA(int pos) {
        if (!hasPosicion(pos)) {
            throw new NoSuchElementException("No existe la posición " + pos);
        }
        T elemento = lista.get(pos);
        indice = pos + 1;
        return elemento;
    }

    private int indiceAtras;
    private boolean atrasIniciado = false;

    private void iniciarAtras() {
        if (!atrasIniciado) {
            int ultimo = lista.size() - 1;
            indiceAtras = (ultimo % 2 == 0) ? ultimo : ultimo - 1;
            atrasIniciado = true;
        }
    }

    public boolean hasParesAtras() {
        iniciarAtras();
        return indiceAtras >= 0;
    }

    public T paresHaciaAtras() {
        iniciarAtras();
        if (!hasParesAtras()) {
            throw new NoSuchElementException("No hay más elementos pares hacia atrás");
        }
        T elemento = lista.get(indiceAtras);
        indiceAtras -= 2;
        return elemento;
    }
}