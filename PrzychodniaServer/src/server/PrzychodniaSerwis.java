package server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import model.Wizyta;

import org.hibernate.*;

public class PrzychodniaSerwis implements IPrzychodniaSerwis
{
	private String description;
	
	public static void main(String[] args)
	{
		
	 boolean err = false;
	 Configuration conf = new Configuration();
	 int registryPort = conf.getRmiPort();
     
     try
     {
            IPrzychodniaSerwis server = new PrzychodniaSerwis("Wysylka z servera");
            LocateRegistry.createRegistry(registryPort);
            UnicastRemoteObject.exportObject(server,registryPort);
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
     if(!err){
            System.out.println("\n[OK] Dzia³amy! \n");
           //testRejestracja();
     }
}
	@Override
	public boolean login(String login, String haslo)  throws RemoteException{
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createSQLQuery("SELECT ID FROM uzytkownik WHERE NAZWA = :nazwa AND HASLO = :haslo");
        
        
		//Query query = session.createQuery("SELECT ID FROM uzytkownik WHERE NAZWA = :nazwa AND HASLO = :haslo");
		query.setParameter("nazwa", login);
		query.setParameter("haslo", haslo);
		//int result = query.executeUpdate();
		List list = query.list();
		session.close();
		if(!list.isEmpty())
			return true;
		return false;
	}
	
	@Override
	public List<Integer> wizyty(String name, int czyLekarz)  throws RemoteException{
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query;
        
        if(czyLekarz==0)
        {
        	query = session.createSQLQuery("SELECT ID FROM wizyta WHERE PACJENT = :name");
        }
        else
        {
        	query = session.createSQLQuery("SELECT ID FROM wizyta WHERE LEKARZ = :name");
        }
        
        
		//Query query = session.createQuery("SELECT ID FROM uzytkownik WHERE NAZWA = :nazwa AND HASLO = :haslo");
		query.setParameter("name", name);
		//int result = query.executeUpdate();
		List<Integer> list = query.list();
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
		session.close();
		return list;
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
	public void update() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Uzytkownik uzyt = null;
        DaneOsobowe dane = null;
        Platnosc plac = null;
        Saldo saldo = null;
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Uzyt.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           uzyt = (Uzytkownik) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Uzytkownik class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Dane.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           dane = (DaneOsobowe) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("DaneOsobowe class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Plac.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           plac = (Platnosc) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Platnosc class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Saldo.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           saldo = (Saldo) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Saldo class not found");
           c.printStackTrace();
        }
        
        session.update(uzyt);
        session.update(dane);
		session.update(plac);
		session.update(saldo);

		tx.commit();
		session.close();
	}
	@Override
	public void rejestracja() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Uzytkownik uzyt = null;
        DaneOsobowe dane = null;
        Platnosc plac = null;
        Saldo saldo = null;
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Uzyt.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           uzyt = (Uzytkownik) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Uzytkownik class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Dane.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           dane = (DaneOsobowe) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("DaneOsobowe class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Plac.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           plac = (Platnosc) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Platnosc class not found");
           c.printStackTrace();
        }
        
        try
        {
           FileInputStream fileIn =
                            new FileInputStream("c:/Saldo.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           saldo = (Saldo) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Saldo class not found");
           c.printStackTrace();
        }
        
        session.save(uzyt);
        session.save(dane);
		session.save(plac);
		session.save(saldo);

		tx.commit();
		session.close();
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
        Transaction tx = session.beginTransaction();
       
        Uzytkownik dane = new Uzytkownik();
        session.load(dane, login);
		tx.commit();
		session.close();
		return dane;
	}
	@Override
	public Saldo saldo(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
       
        Saldo dane = new Saldo();
        session.load(dane, i);
		tx.commit();
		session.close();
		return dane;
	}
	@Override
	public Lekarz lekarz(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Lekarz dane = new Lekarz();
        session.load(dane, i);
		tx.commit();
		session.close();
		return dane;
	}
	@Override
	public Wizyta wizyta(int i) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Wizyta dane = new Wizyta();
        session.load(dane, i);
		tx.commit();
		session.close();
		return dane;
	}
	@Override
	public boolean updateDaneOsobowe() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        DaneOsobowe dane = new DaneOsobowe();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Dane.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        dane = (DaneOsobowe) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.saveOrUpdate(dane);	
        tx.commit();
		session.close();
		return false;
	}
	@Override
	public boolean updatePlatnosc() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Platnosc plac = new Platnosc();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Plac.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        plac = (Platnosc) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.saveOrUpdate(plac);	
        tx.commit();
		session.close();
		return false;
	}
	@Override
	public boolean updateUzytkownik() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
Uzytkownik uzyt = new Uzytkownik();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Uzyt.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        uzyt = (Uzytkownik) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.saveOrUpdate(uzyt);	
        tx.commit();
		session.close();
		return false;
	}
	@Override
	public boolean updateSaldo() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
Saldo saldo = new Saldo();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Saldo.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        saldo = (Saldo) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.saveOrUpdate(saldo);	
        tx.commit();
		session.close();
		return false;
	}
	@Override
	public boolean updateLekarz() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
Lekarz lekarz = new Lekarz();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Lekarz.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        lekarz = (Lekarz) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.saveOrUpdate(lekarz);	
        tx.commit();
		session.close();
		return false;
	}
	public boolean updateWizyta() 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Wizyta wizyt = new Wizyta();
        
        FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("c:/Wizyt.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        wizyt = (Wizyta) in.readObject();
	        in.close();
	        fileIn.close();
        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.save(wizyt);	
        tx.commit();
		session.close();
		return false;
	}
	
	public static void testRejestracja()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
		Uzytkownik uzyt = new Uzytkownik();
		DaneOsobowe dane = new DaneOsobowe();
		Platnosc plac = new Platnosc();
		Saldo saldo = new Saldo();
		Wizyta wizyt = new Wizyta();
		
		plac.setKwota(1000.5);
		plac.setNazwaBanku("sdfgsdfg");
		plac.setNrKonta(1234567);
		dane.setAdres("wertew");
		dane.setImie("Dawid");
		dane.setNazwisko("Saladra");
		dane.setPesel(12345);
		dane.setTel(345678);
		dane.setWiek(23);
		saldo.setId(1234567);
		saldo.setSaldo1(3432.33);
		uzyt.setCzyLekarz(1);
		uzyt.setDane(12345);
		uzyt.setHaslo("qwe");
		uzyt.setNazwa("lekarz");
		uzyt.setPlatnosc(1234567);
		uzyt.setSaldo(1234567);
		
		wizyt.setPacjent("pacjent");
		wizyt.setLekarz("lekarz");
		wizyt.setGodzina(11);
		wizyt.setDzien(11);
		wizyt.setRok(222);
		
		session.save(uzyt);
        session.save(dane);
		session.save(plac);
		session.save(saldo);
		session.save(wizyt);
		
		tx.commit();
		session.close();
	}

		
}
