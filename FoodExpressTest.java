
public class FoodExpressTest 
{
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        grafo.conectar(0, 1);
        grafo.conectar(0, 2);
        grafo.conectar(1, 3);
        grafo.conectar(2, 3);
        grafo.conectar(3, 4);
        grafo.conectar(4, 5);
        System.out.println("=== RED DE DELIVERY FOODEXPRESS ===\n");
        System.out.println(grafo.toString());
        System.out.println(grafo.Zonas(0) + " esta conectada a " + grafo.Zonas(1) + " : " + grafo.zonasConectadas(0, 1));
        System.out.println(grafo.Zonas(0) + " esta conectada a " + grafo.Zonas(5) + " : " + grafo.zonasConectadas(0, 5));
        
        System.out.println("Vecinos de " + grafo.Zonas(0) + ": " + grafo.ZonasVecinas(0));
        System.out.println("Vecinos de " + grafo.Zonas(3) + ": " + grafo.ZonasVecinas(3));
        System.out.println("Vecinos de " + grafo.Zonas(5) + ": " + grafo.ZonasVecinas(5));

        System.out.println("Ruta mas corta de " + grafo.Zonas(0) + " a " + grafo.Zonas(5) + ": " + grafo.busquedaAmplitud(0, 5));
        System.out.println("Ruta mas corta de " + grafo.Zonas(0) + " a " + grafo.Zonas(2) + ": " + grafo.busquedaAmplitud(0, 2));

        System.out.println(grafo.recorridoCompletoDFS(2));
    }
}
