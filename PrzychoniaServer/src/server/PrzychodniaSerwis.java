package server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.security.*;
import java.util.List;

import wspolne.Configuration;
import wspolne.IPrzychodniaSerwis;
import Baza.HibernateUtil;

import model.DaneOsobowe;
import model.Lekarz;
import model.Platnosc;
import model.Saldo;
import model.Uzytkownik;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PrzychodniaSerwis implements IPrzychodniaSerwis
{
	private String description;
	
	public static void main(String[] args)
	{
		
	 boolean err = false;
	 Configuration conf = null;
	 conf.setRmiPort(8000);
	 int registryPort = conf.getRmiPort();
     
     try
     {
            IPrzychodniaSerwis server = new PrzychodniaSerwis("Wysylka z servera");
            LocateRegistry.createRegistry(registryPort);
            UnicastRemoteObject.exportObject(server,0);
            Naming.rebind("//localhost:"+registryPort+"/dServer", server);
     }
     catch(java.rmi.UnknownHostException uhe){
            System.out.println("[error] podana nazwa hosta nie jest \n identyfikatorem tego komputera\n"+uhe+"\n");
            err = true;
     }
     catch(AccessControlException ace){
            System.out.println("[error] nie masz uprawnien aby uruchomic serwer\n na tym porcie dla podanej nazwy hosta\n"+ace+"\n");
            err = true;
     }
     catch(RemoteException re){
            System.out.println("[error] nie uda³o siê zarejestrowaæ \n zdalnego obiektu serwera\n"+re+"\n");
            err = true;
     }
     catch(MalformedURLException mURLe){
            System.out.println("[error] wewnêtrzny b³¹d" + mURLe+"\n");
            err = true;
     }
     catch(Exception ee){
            System.out.println("[error] cccc"+ee.getMessage()+"\n");
            err = true;
     }
     if(!err)
            System.out.println("\n[OK] Dzia³amy! \n");
}
	@Override
	public boolean login(String login, String haslo)  throws RemoteException{
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
		Query query = session.createQuery("SELECT ID FROM uzytkownik WHERE NAZWA = :nazwa AND HASLO = :haslo");
		query.setParameter("nazwa", login);
		query.setParameter("haslo", haslo);
		List list = query.list();
		session.close();
		if(!list.isEmpty())
			return true;
		return false;
	}
    

    PrzychodniaSerwis(String desc){
          description = desc;
    }
    
    @Override
	public List MySQLQuerry(String MySql) throws RemoteException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
         Session sess = sf.openSession();
         if(!sess.isConnected()) 
        	return null;
         Query query = sess.createQuery(MySql);
         List list = query.list();
         sess.close();
		return list;
	}
    
	@Override
	public String getDesc() throws RemoteException {
		// TODO Auto-generated method stub
		return description;
	}
	@Override
	public boolean rejestracja(Uzytkownik uzyt, DaneOsobowe dane, Platnosc plac) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        if(!session.isConnected())
        	return false;
        
        session.save(uzyt);
        session.save(dane);
		session.save(plac);
		
		session.close();
		return true;
	}
	@Override
	public DaneOsobowe daneOsobowe(int i) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
       
        DaneOsobowe dane = new DaneOsobowe();
        session.load(dane, i);
		
		session.close();
		return dane;
		// TODO Auto-generated method stub
	}
	@Override
	public Platnosc platnosc(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
       
        Platnosc dane = new Platnosc();
        session.load(dane, i);
		
		session.close();
		return dane;
	}
	@Override
	public Uzytkownik uzytkownik(String login) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
       
        Uzytkownik dane = new Uzytkownik();
        session.load(dane, login);
		
		session.close();
		return dane;
	}
	@Override
	public Saldo saldo(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
       
        Saldo dane = new Saldo();
        session.load(dane, i);
		
		session.close();
		return dane;
	}
	@Override
	public Lekarz lekarz(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
       
        Lekarz dane = new Lekarz();
        session.load(dane, i);
		
		session.close();
		return dane;
	}
	@Override
	public void updateDaneOsobowe(DaneOsobowe dane) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.saveOrUpdate(dane);	
		session.close();
	}
	@Override
	public void updatePlatnosc(Platnosc plac) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.saveOrUpdate(plac);	
		session.close();
	}
	@Override
	public void updateUzytkownik(Uzytkownik uzyt) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.saveOrUpdate(uzyt);	
		session.close();
	}
	@Override
	public void updateSaldo(Saldo saldo) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.saveOrUpdate(saldo);	
		session.close();
	}
	@Override
	public void updateLekarz(Lekarz lekarz) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.saveOrUpdate(lekarz);	
		session.close();
	}

		
}
