public class FoodExpressTest {
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
        
    }
}
