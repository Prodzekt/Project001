package wspolne;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.DaneOsobowe;
import model.Lekarz;
import model.Platnosc;
import model.Saldo;
import model.Uzytkownik;

import org.hibernate.Query;

public interface IPrzychodniaSerwis extends Remote {
	boolean login(String login, String haslo) throws RemoteException;
	List MySQLQuerry(String MySql) throws RemoteException;
	String getDesc() throws RemoteException;
	boolean rejestracja(Uzytkownik uzyt, DaneOsobowe dane, Platnosc plac);
	DaneOsobowe daneOsobowe(int i);
	Platnosc platnosc(int i);
	Uzytkownik uzytkownik(String login);
	Saldo saldo(int i);
	Lekarz lekarz(int i);
	
	void updateDaneOsobowe(DaneOsobowe dane);
	void updatePlatnosc(Platnosc plac);
	void updateUzytkownik(Uzytkownik uzyt);
	void updateSaldo(Saldo saldo);
	void updateLekarz(Lekarz lekarz);

}
