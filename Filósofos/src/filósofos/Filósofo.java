package filósofos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filósofo extends Thread{
    private final Mesa mesa;
    private final int id;
    
    public Filósofo(int id, Mesa mesa){
        this.id = id;
        this.mesa = mesa;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep((long) (Math.random() * 5000));
                mesa.Comer(id);
                Thread.sleep((long) (Math.random() * 5000));
                mesa.DejarDeComer(id);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filósofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
