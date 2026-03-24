//package ProgramaAvan;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cola<T> implements Iterable<T> {
    private T item;
    private Nodo<T> ultimo;
    private Nodo<T> primero;
    private int tam;

    class Nodo<T> {
        T item;
        Nodo<T> enlace;
    }

    public Cola() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public int getTam() {
        return tam;
    }

    public boolean esta_vacio(){
        return primero == null;
    }

    public void encolar(T i){
        Nodo<T> ultimo_anterior = ultimo;
        ultimo = new Nodo<T>();
        ultimo.item = i;
        ultimo.enlace = null;

        if (esta_vacio()){
            primero = ultimo;
        }
        else{
            ultimo_anterior.enlace = ultimo;
        }
        tam++;
    }

    public T desencolar(){
        if (esta_vacio()){
            throw new NoSuchElementException("libprogra.lineal.Cola vacia");
        }
        T result = primero.item;
        primero = primero.enlace;
        tam--;
        if (esta_vacio()){
            ultimo = null;
        }
        return result;
    }
    @Override
    public Iterator<T> iterator() {
        return new Lista_Iterador(primero);
    }

    private class Lista_Iterador implements Iterator<T>{
        private Nodo<T> actual;
        public Lista_Iterador(Nodo<T> i){
            this.actual = i;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException("No hay elementos");
            }
            T d = actual.item;
            actual = actual.enlace;
            return d;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = primero;
        actual = primero;
        while (actual != null) {
            sb.append("(").append(actual.item).append(")");
            if (actual.enlace != null) {
                sb.append(", ");
            }
            actual = actual.enlace;
        }
        sb.append("]");
        return sb.toString();
    }
}