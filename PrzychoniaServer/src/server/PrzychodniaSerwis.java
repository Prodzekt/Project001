package server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.security.*;

import wspolne.IPrzychodniaSerwis;
import Baza.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class PrzychodniaSerwis implements IPrzychodniaSerwis{
	public static void main(String[] args)
	{
	 boolean err = false;
     int registryPort = 8000;
     
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
	public String login(String login, String haslo)  throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println(login+haslo);
		return null;
	}
    private String description;

    PrzychodniaSerwis(String desc){
          description = desc;
    }
    
    @Override
	public String MySQLQuerry(String MySql) throws RemoteException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
         Session sess = sf.openSession();
         if(!sess.isConnected()) 
        	return "takiego!";
         sess.createQuery(MySql);
         sess.close();
		return "Zrobione!";
	}
    
	@Override
	public String getDesc() throws RemoteException {
		// TODO Auto-generated method stub
		return description;
	}

		
}
