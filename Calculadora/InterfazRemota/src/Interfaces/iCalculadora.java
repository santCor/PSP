
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author sanruiade
 */
public interface iCalculadora extends Remote{
    
    public int suma(int a, int b) throws RemoteException;
    
    public int resta(int a, int b) throws RemoteException;
    
    public int multiplicacion(int a, int b) throws RemoteException;
    
    public int division(int a, int b) throws RemoteException;
}
