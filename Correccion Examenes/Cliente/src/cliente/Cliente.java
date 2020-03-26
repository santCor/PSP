
package cliente;

import Interfaces.iCorreccion;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanruiade
 */
public class Cliente {

    public static void main(String[] args) {
        
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Escribe las respuestas del examen: ");
        String respuestas = stdIn.nextLine();
        
        try {
            Registry registro = LocateRegistry.getRegistry(5555);
            iCorreccion servidor = (iCorreccion)registro.lookup("Servidor");
            
            if(servidor != null){
                System.out.println("Nota: " + servidor.corregir(respuestas));
                System.out.println("Media: " + servidor.getMedia());
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
