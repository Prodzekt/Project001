package wspolne;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.DaneOsobowe;
import model.Lekarz;
import model.Platnosc;
import model.Saldo;
import model.Uzytkownik;
import model.Wizyta;

import org.hibernate.Query;

public interface IPrzychodniaSerwis extends Remote 
{
	boolean login(String login, String haslo) throws RemoteException;
	List<Integer> wizyty(String name, int czyLekarz) throws RemoteException;
	List MySQLQuerry(String MySql) throws RemoteException;
	String getDesc() throws RemoteException;
	void rejestracja() throws RemoteException;
	void update() throws RemoteException;
	DaneOsobowe daneOsobowe(int i) throws RemoteException;
	Platnosc platnosc(int i) throws RemoteException;
	Uzytkownik uzytkownik(String login) throws RemoteException;
	Saldo saldo(int d) throws RemoteException;
	Lekarz lekarz(int i) throws RemoteException;
	Wizyta wizyta(int i) throws RemoteException;
	
	boolean updateDaneOsobowe() throws RemoteException;
	boolean updatePlatnosc() throws RemoteException;
	boolean updateUzytkownik() throws RemoteException;
	boolean updateSaldo() throws RemoteException;
	boolean updateLekarz() throws RemoteException;
	boolean updateWizyta()throws RemoteException;

}
