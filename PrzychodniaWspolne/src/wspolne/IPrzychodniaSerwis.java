package wspolne;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPrzychodniaSerwis extends Remote {
	String login(String login, String haslo) throws RemoteException;
	String getDesc() throws RemoteException;

}
