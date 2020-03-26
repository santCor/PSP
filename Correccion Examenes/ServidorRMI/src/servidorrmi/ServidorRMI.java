
package servidorrmi;

import Interfaces.iCorreccion;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanruiade
 */
public class ServidorRMI implements iCorreccion{

    private static final String SOLUCION = "abcdabcdaa";
    private double sumatorio = 0;
    private double media = 0;
    private double contador = 0;
    
    @Override
    public double corregir(String examen) throws RemoteException {
        double nota = 0;
        
        for (int i = 0; i < SOLUCION.length(); i++) {
            if(examen.charAt(i) == SOLUCION.charAt(i)){
                nota ++;
            } else if (examen.charAt(i) != SOLUCION.charAt(i) && examen.charAt(i) != '0'){
                    nota -= 0.25;
            }
        }
        
        if(nota < 0){
            nota = 0;
        }
        
        synchronized (this){
            contador++;
            sumatorio += nota;
            media = sumatorio/contador;
        }
        
        return nota;
    }

    @Override
    public double getMedia()  throws RemoteException{
        return media;
    }
    
    public static void main(String[] args) {
        Registry registro = null;
        
        try {
            registro = LocateRegistry.createRegistry(5555);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ServidorRMI servidor = new ServidorRMI();
        
        try {
            registro.rebind("Servidor", (iCorreccion) UnicastRemoteObject.exportObject(servidor, 0));
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
