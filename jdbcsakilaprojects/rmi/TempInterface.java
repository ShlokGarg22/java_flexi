import java.rmi.*;

public interface TempInterface extends Remote {
    double convert(double c) throws RemoteException;
}