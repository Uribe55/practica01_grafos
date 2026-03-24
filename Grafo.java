import java.util.Arrays;

public class Grafo {
private int vertices;
    private int arcos;
    private Lista<Integer>[] enlaces;

    public Grafo(int v){
        vertices = v;
        arcos = 0;
        enlaces = new Lista[v];

        for(int i = 0; i < v; i++){
            enlaces[i] = new Lista<>();
        }
    }

    public int getVertices() {
        return vertices;
    }
    
    public void conectar(int v, int w){
        arcos++;
        enlaces[v].insertar(w);
        enlaces[w].insertar(v);
    }

    public Iterable<Integer> getConexiones(int n){
        return enlaces[n];
    }

    public boolean conectado(int v, int w){
        Pila<Integer> frontera = new Pila<>();
        frontera.empilar(v);
        Lista<Integer> vistados = new Lista<>();
        Integer nodo;
        while (!frontera.esta_vacio()) {
            nodo = frontera.desempilar();
            if (nodo == w){
                return true;
            }
            vistados.insertar(nodo);
            for (Integer i : enlaces[nodo]) {
                if(!vistados.pertenece(i))
                frontera.empilar(i);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices " + arcos + " enalces " + "\n");
        for(int i = 0; i < vertices; i++){
            s.append(i + " : ");
            for (int j : enlaces[i]) {
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
