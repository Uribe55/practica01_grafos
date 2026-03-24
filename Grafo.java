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

    public String ZonasVecinas(int zona){
        StringBuilder vecinos = new StringBuilder();
        for (Integer i : enlaces[zona]) {
            vecinos.append(Zonas(i)).append(" (").append(i).append("), ");
        }
        if(vecinos.length() > 0) {
            vecinos.setLength(vecinos.length() - 2); // Eliminar la última coma y espacio
        }
        else {
            vecinos.append("No hay zonas vecinas");
        }
        return vecinos.toString();
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
    public String recorridoCompletoDFS(int inicio) {
        boolean[] visitado = new boolean[zonas];
        Pila<Integer> pila = new Pila<>();
        Lista<Integer> ordenVisita = new Lista<>();
        pila.empilar(inicio);
        
        while (!pila.esta_vacio()) {
            int actual = pila.desempilar();
            if (!visitado[actual]) {
                visitado[actual] = true;
                ordenVisita.insertar(actual);
                Lista<Integer> vecinosNoVisitados = new Lista<>();
                for (Integer vecino : enlaces[actual]) {
                    if (!visitado[vecino]) {
                        vecinosNoVisitados.insertar(vecino);
                    }
                }
                
                for (int i = vecinosNoVisitados.getTam() - 1; i >= 0; i--) {
                    pila.empilar(vecinosNoVisitados.get(i));
                }
            }
        }
        boolean todasVisitadas = true;
        for (int i = 0; i < zonas; i++) {
            if (!visitado[i]) {
                todasVisitadas = false;
                break;
            }
        }
        StringBuilder recorrido = new StringBuilder();
        recorrido.append(" MEJOR RUTA DE REPARTO desde ").append(Zonas(inicio)).append(":\n");
        recorrido.append("\n");
        recorrido.append("Orden de visita de las zonas:\n\n");
        
        for (int i = 0; i < ordenVisita.getTam(); i++) {
            int zona = ordenVisita.get(i);
            recorrido.append("  ").append(i + 1).append(". ");
            recorrido.append(Zonas(zona)).append(" (").append(zona).append(")");
            if (i < ordenVisita.getTam() - 1) {
                recorrido.append(" ->");
            }
            recorrido.append("\n");
        }
        
        recorrido.append("\n=================================\n");
        if (!todasVisitadas) {
            recorrido.append("\n  ADVERTENCIA: El grafo NO es completamente conexo\n");
            recorrido.append("   No se pudieron visitar todas las zonas.\n\n");
            recorrido.append("Zonas NO visitadas:\n");
            for (int i = 0; i < zonas; i++) {
                if (!visitado[i]) {
                    recorrido.append("  • ").append(Zonas(i)).append(" (").append(i).append(")\n");
                }
            }
            recorrido.append("\n Sugerencia: Agregar nuevas conexiones para conectar ");
            recorrido.append("estas zonas aisladas.");
        } else {
            recorrido.append("\n ÉXITO: Se visitaron TODAS las ").append(zonas);
            recorrido.append(" zonas sin repetir.\n");
            recorrido.append(" Total de paradas: ").append(ordenVisita.getTam()).append("\n");
        }
        return recorrido.toString();
    }
}
