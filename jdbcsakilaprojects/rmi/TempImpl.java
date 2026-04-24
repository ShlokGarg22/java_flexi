import java.rmi.*;
import java.rmi.server.*;

public class TempImpl extends UnicastRemoteObject implements TempInterface {

    public TempImpl() throws RemoteException {
        super();
    }

    public double convert(double c) throws RemoteException {
        return (c * 9/5) + 32;
    }
}