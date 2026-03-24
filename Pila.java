import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<T> implements Iterable<T>{
    private Nodo<T> primero;
    private int tam;
    class Nodo<T> {
        T item;
        Nodo<T> enlace;
    }
    public Pila() {
        primero = null;
        tam = 0;
    }

    public boolean esta_vacio(){
        return primero == null;
    }

    public void empilar(T item){
        Nodo<T> antiguo = primero;
        primero = new Nodo<>();
        primero.item = item;
        primero.enlace = antiguo;
        tam++;
    }

    public T desempilar(){
        if (esta_vacio()){
            throw new NoSuchElementException("libprogra.lineal.Pila vacia");
        }
        T resul = primero.item;
        primero = primero.enlace;
        tam--;
        return resul;
    }

    @Override
    public Iterator<T> iterator() {
        return new Lista_Iterador(primero);
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
                throw new NoSuchElementException("No hay elementos");
            }
            T i = actual.item;
            actual = actual.enlace;
            return i;
        }
    }
}