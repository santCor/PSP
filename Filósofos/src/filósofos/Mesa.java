package filósofos;

public class Mesa {
    private final int núm_filósofos;
    private final boolean[] palillos;
    private int comiendo = 0;
    
    public Mesa(int núm_filósofos){
        this.núm_filósofos = núm_filósofos;
        palillos = new boolean[núm_filósofos];
        
        for (int i = 0; i < palillos.length; i++) {
            palillos[i] = true;
        }
    }
    
    public synchronized void Comer(int id) throws InterruptedException{
        int anterior;
        if (id == 0)
            anterior = núm_filósofos - 1;
        else
            anterior = id - 1;
        
        while (!palillos[id] ||
               !palillos[anterior] ||
               comiendo == núm_filósofos - 1)
            wait();
        
        palillos[id] = false;
        palillos[anterior] = false;
        comiendo++;
        System.out.println("Filósofo " + id + " comiendo");
    }
    
    public synchronized void DejarDeComer(int id){
        int anterior;
        if (id == 0)
            anterior = núm_filósofos - 1;
        else
            anterior = id - 1;
        
        palillos[id] = true;
        palillos[anterior] = true;
        comiendo--;
        
        notifyAll();
    }
    
}
