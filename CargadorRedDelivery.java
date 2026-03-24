import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CargadorRedDelivery {
    public static void main(String[] args) throws FileNotFoundException {
        Grafo grafo = new Grafo(6);
        Scanner sc = new Scanner(new File("conexiones.txt"));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int zona1 = Integer.parseInt(line[0]);
            int zona2 = Integer.parseInt(line[1]);
            grafo.conectar(zona1, zona2);
        }
        System.out.println("=== RED DE DELIVERY FOODEXPRESS ===\n");
        System.out.println(grafo.toString());

    }
}
