
package clientecalculadorarmi;


import Interfaces.iCalculadora;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanruiade
 */
public class ClienteCalculadoraRMI {

    
    public static void main(String[] args) {
        
        System.out.println("Localizando el registro de objetos remotos...");
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 5000);
            
            System.out.println("Obteniendo el stub del objeto remoto");
            iCalculadora calc = (iCalculadora) registro.lookup("Calculadora");
            
            if(calc != null){
                System.out.println("Realizando operaciones con el objeto remoto...");
                System.out.println("2+2 = " + calc.suma(2, 2));
                System.out.println("2-2 = " + calc.resta(2, 2));
                System.out.println("2*2 = " + calc.multiplicacion(2, 2));
                System.out.println("2/2 = " + calc.division(2, 2));
            }
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ClienteCalculadoraRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
