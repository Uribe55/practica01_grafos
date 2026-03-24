import java.io.*;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner lector = new Scanner(new File("practica01_grafos/conexinoes_delivery.txt"));
        Grafo grafo = new Grafo(lector.nextInt());

        while (lector.hasNext()) {
            grafo.conectar(lector.nextInt(), lector.nextInt());
        }

        System.out.println(grafo);
        System.out.println(grafo.zonasConectadas(3, 2));
        lector.close();
    }
}
