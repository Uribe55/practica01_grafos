import java.util.Arrays;

public class Grafo {
    private int zonas;
    private int rutasDierectas;
    private Lista<Integer>[] enlaces;

    public Grafo(int zonas){
        this.zonas = zonas;
        rutasDierectas = 0;
        enlaces = new Lista[zonas];

        for(int i = 0; i < zonas; i++){
            enlaces[i] = new Lista<>();
        }
    }

    public int getzonas() {
        return zonas;
    }
    
    public void conectar(int zona1, int zona2){
        rutasDierectas++;
        enlaces[zona1].insertar(zona2);
        enlaces[zona2].insertar(zona1);
    }

    public Iterable<Integer> listarZonasVecinas(int zona){
        return enlaces[zona];
    }

    public boolean Conectadas(int zona1, int zona2){
        Pila<Integer> frontera = new Pila<>();
        frontera.empilar(zona1);
        Lista<Integer> vistados = new Lista<>();
        Integer nodo;
        while (!frontera.esta_vacio()) {
            nodo = frontera.desempilar();
            if (nodo == zona2){
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
     public boolean zonasConectadas(int zona1, int zona2){
        for (Integer i : enlaces[zona1]) {
            if(i == zona2){
                return true;
            }
        }
        return false;
    }
    public String Zonas(int num){
        switch (num) {
            case 0:
                return "El Prado";
            case 1:
                return "Cala Cala";
            case 2:
                return "América Oeste";
            case 3:
                return "Recoleta";
            case 4:
                return "Qeru Qeru";
            case 5:
                return "Aeropuerto";
            default:
                return "Zona no encontrada";
        }
    }

    public String busquedaAmplitud(int inicio, int destino) {
    if (inicio == destino) {
        return Zonas(inicio);
    }
    Cola<Integer> cola = new Cola<>();
    int[] anterior = new int[zonas];
    boolean[] visitado = new boolean[zonas];
    for (int i = 0; i < zonas; i++) {
        anterior[i] = -1;
    }
    visitado[inicio] = true;
    cola.encolar(inicio);
    while (!cola.esta_vacio()) {
        int actual = cola.desencolar();
        for (Integer vecino : enlaces[actual]) {
            if (!visitado[vecino]) {
                visitado[vecino] = true;
                anterior[vecino] = actual; 
                if (vecino == destino) {
                    return reconstruirCamino(anterior, inicio, destino);
                }
                cola.encolar(vecino);
            }
        }
    }
    return "No hay ruta disponible entre " + Zonas(inicio) + " y " + Zonas(destino);
}

private String reconstruirCamino(int[] anterior, int inicio, int destino) {
    Pila<Integer> pila = new Pila<>();
    int actual = destino;
    while (actual != -1) {
        pila.empilar(actual);
        actual = anterior[actual];
    }
    StringBuilder camino = new StringBuilder();
    boolean primero = true;
    while (!pila.esta_vacio()) {
        if (!primero) {
            camino.append(" -> ");
        }
        int zona = pila.desempilar();
        camino.append(Zonas(zona)).append(" (").append(zona).append(")");
        primero = false;
    }
    return camino.toString();
}
    

@Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(zonas + " zonas " + rutasDierectas + " enlaces " + "\n");
        for(int i = 0; i < zonas; i++){
            s.append(Zonas(i) + " (" + i + ") : ");
            for (int j : enlaces[i]) {
                s.append(Zonas(j) + " (" + j + "), ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
