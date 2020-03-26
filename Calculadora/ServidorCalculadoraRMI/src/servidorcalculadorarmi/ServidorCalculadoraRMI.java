
package servidorcalculadorarmi;

import Interfaces.iCalculadora;
import java.rmi.AlreadyBoundException;
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
public class ServidorCalculadoraRMI implements iCalculadora{

    
    public static void main(String[] args) {
        System.out.println("Creando registro de objetos remotos");
        Registry registro;
        
        try {
            registro = LocateRegistry.createRegistry(5000);
            
            System.out.println("Creando el objeto servidor e inscribiéndolo en el registro");
            ServidorCalculadoraRMI calculadora = new ServidorCalculadoraRMI();
            
            registro.bind("Calculadora", UnicastRemoteObject.exportObject(calculadora, 0));
            
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(ServidorCalculadoraRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: sumando " + a + " y " + b);
        return a + b;
    }

    @Override
    public int resta(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: restando " + a + " y " + b);
        return a - b;
    }

    @Override
    public int multiplicacion(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: multiplicando " + a + " y " + b);
        return a * b;
    }

    @Override
    public int division(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: dividiendo " + a + " y " + b);
        return a / b;
    }
    
}
