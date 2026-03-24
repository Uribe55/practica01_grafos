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

    public void busquedaAmplitud(int zonaInicial, int zonaFinal, Grafo grafo){
        Cola<Integer> cola = new Cola<>();
        cola.encolar(zonaInicial);
        Lista<Integer> visitados = new Lista<>();

        while (!cola.esta_vacio()) {
            int nodo = cola.desencolar();
            for (int vecino : grafo.listarZonasVecinas(nodo)) {
                
            }
        }
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
