/**********************************************************
 * Clase libprogra.lineal.Lista: libprogra.lineal.Lista enlazada
 *****************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T> {

    private Nodo<T> cabeza;
    private  int tam;

    class Nodo<T> {
        T item;
        Nodo<T> enlace;
    }
    public Lista() {
        cabeza = null;
        tam = 0;
    }

    public int getTam() {
        return tam;
    }

    public boolean esta_vacio(){
        return cabeza == null;
    }
    public void insertar(T item){
        cabeza = insertar(cabeza, item);
    }

    private Nodo<T> insertar(Nodo<T> x, T item){
        if (x == null){
            x = new Nodo<>();
            x.item = item;
            x.enlace = null;
            tam++;
            return x;
        }

        x.enlace = insertar(x.enlace, item);
        return x;
    }

    public T get(int pos){
        if (pos > getTam()-1){
            throw new NoSuchElementException("Fuera de rango");
        }
        for (int i=0; i<pos; i++){
            cabeza = cabeza.enlace;
        }
        return cabeza.item;
    }

    public boolean pertenece(T itemBuscado) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.item.equals(itemBuscado)) {
                return true;
            }
            actual = actual.enlace;
        }
        return false;
    }

    public void mergeSort() {
        cabeza = mergeSort(cabeza);
    }

    private Nodo<T> mergeSort(Nodo<T> inicio) {
        // Caso base: lista vacía o tiene un solo elemento
        if (inicio == null || inicio.enlace == null) {
            return inicio;
        }

        Nodo<T> mitad1 = get_mitad(inicio);
        Nodo<T> mitad2 = mitad1.enlace;
        mitad1.enlace = null;
        // Caso recursivo, enviamos prmera mitad y segnda miitad
        Nodo<T> mitad1_ordenado = mergeSort(inicio);
        Nodo<T> mitad2_ordenado = mergeSort(mitad2);

        return merge(mitad1_ordenado, mitad2_ordenado);
    }

    private Nodo<T> merge(Nodo<T> lista1, Nodo<T> lista2) {
        Nodo<T> resultado = new Nodo<>();
        Nodo<T> actual = resultado;

        while (lista1 != null && lista2 != null) {
            if (((Comparable<T>) lista1.item).compareTo(lista2.item) <= 0) {
                actual.enlace = lista1;
                lista1 = lista1.enlace;
            } else {
                actual.enlace = lista2;
                lista2 = lista2.enlace;
            }
            actual = actual.enlace;
        }

        // Si queda algún elemento en alguna de las listas, lo agregamos al final del resultado
        if (lista1 != null) {
            actual.enlace = lista1;
        }
        if (lista2 != null) {
            actual.enlace = lista2;
        }

        return resultado.enlace;
    }

    private Nodo<T> get_mitad(Nodo<T> inicio) {
        Nodo<T> siguiente = inicio.enlace;
        Nodo<T> indice = inicio;

        while (siguiente != null && siguiente.enlace != null) {
            siguiente = siguiente.enlace.enlace;
            indice = indice.enlace;
        }

        return indice;
    }
    @Override
    public Iterator<T> iterator() {
        return new Lista_Iterador(cabeza);
    }

    private class Lista_Iterador implements Iterator<T>{
        private Nodo<T> actual;

        public Lista_Iterador(Nodo<T> a){
            actual = a;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException("libprogra.lineal.Lista Vacia");
            }
            T i = actual.item;
            actual = actual.enlace;
            return i;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.item.toString());
            if (actual.enlace != null) {
                sb.append(", ");
            }
            actual = actual.enlace;
        }
        sb.append("]");
        return sb.toString();
    }
}