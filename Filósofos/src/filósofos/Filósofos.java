package filósofos;

import java.util.Scanner;

public class Filósofos {

    public static void main(String[] args) {
        Scanner stdio = new Scanner(System.in);
        
        System.out.print("Número de filósofos para la simulación: ");
        int núm_filósofos = stdio.nextInt();
        
        Mesa mesa = new Mesa(núm_filósofos);
        
        for (int i = 0; i < núm_filósofos; i++) {
            new Filósofo(i, mesa).start();
        }
    }
    
}
