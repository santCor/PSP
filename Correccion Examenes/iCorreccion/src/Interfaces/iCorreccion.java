package Interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 *
 * @author sanruiade
 */
public interface iCorreccion extends Remote{
    
    public double corregir(String examen) throws RemoteException;
    
    public double getMedia() throws RemoteException;
    
}
