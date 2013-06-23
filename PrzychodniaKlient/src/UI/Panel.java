package UI;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import wspolne.IPrzychodniaSerwis;
import wspolne.Configuration;
import model.DaneOsobowe;
import model.Lekarz;
import model.Platnosc;
import model.Saldo;
import model.Uzytkownik;
import model.Wizyta;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DropMode;

public class Panel extends JPanel implements java.io.Serializable{
	private JTextField textField;
	
	public String getTextField0() {
		return textField.getText();
	}
	public String getTextField1() {
		return textField_2.getText();
	}

	public void setTextField(String t) {
		this.textField.setText(t);
	}
	public void setTextField2(String t) {
		this.textField_1.setText(t);
	}
	
	
	//INICJALIZACJA @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO
	
	private Uzytkownik uzytkownik;
	private Platnosc platnosc;
	private Lekarz lekarz;
	private DaneOsobowe daneOsobowe;
	private Saldo saldo;
	private Wizyta wizyta;
	
	public Uzytkownik uzyt;
	public Platnosc plac;
	public Lekarz lek;
	public DaneOsobowe dane;
	public Saldo sald;
	public Wizyta wizyt;

	private List<Integer> list;
	private int licznik;
	private Thread watek;
	private JTextField textField_1;
	private JTextField textField_2;
	final JTextPane txtpnLogin = new JTextPane();
	final JTextPane txtpnHaslo = new JTextPane();
	
	JTextPane txtpnLogin_1 = new JTextPane();
	JTextPane txtpnHaslo_1 = new JTextPane();
	
	final JButton btnNewButton = new JButton();
	final JButton btnRejestracja = new JButton("Rejestracja");
	//rejestracja
	private JTextField rejAdres;
	private JTextField rejImie;
	private JTextField rejNazwisko;
	private JTextField rejPesel;
	private JTextField rejTel;
	private JTextField rejWiek;
	private JTextPane txtpnNazwisko;
	private JTextPane txtpnAdres_1;
	private JTextPane txtpnPesel;
	private JTextPane txtpnTelefon;
	private JTextPane txtpnWiek;
	private JTextPane txtpnAdres;
	private JButton btnRejestruj;
//zalogowany
	
	private JTextField txtz;
	private JTextField txtFieldz;
	private JTextField txtSpecjalizacja;
//dane osobowe
	
	private JTextField textField1;
	private JTextField textField_11;
	private JTextField textField_21;
	private JTextField textField_31;
	private JTextField textField_41;
	
	private JTextPane txtpnImie1;
	private JTextPane txtpnNazwisko1;
	private JTextPane txtpnAdres1;
	private JTextPane txtpnPesel1;
	private JTextPane txtpnTelefon11;
	
	
	JButton btnNewButton1 = new JButton("Zapisz Zmiany");
//platnosci
	JButton btnPlatnosciEKonto = new JButton("Zapisz Zmiany");
	
	private JTextPane txtpnNrKonta;
	private JTextPane txtpnNazwaBanku;
	private JTextPane txtpnKwota;
	private JTextField txtNrKonta;
	private JTextField txtNazwaBanku;
	private JTextField txtKwota;
	
	private JTextPane txtpnNrKonta1;
	private JTextPane txtpnNazwaBanku1;
	private JTextPane txtpnKwota1;
	private JTextField txtNrKonta1;
	private JTextField txtNazwaBanku1;
	private JTextField txtKwota1;
	
	private JTextField txtLogin;
	private JTextField txtHaslo;
	
	private JTextPane txtpnWizytaUzytkownik;
	private JTextPane txtpnWizytaLekarz;
	private JTextPane txtpnWizytaRok;
	private JTextPane txtpnWizytaMiesiac;
	private JTextPane txtpnWizytaDzien;
	private JTextPane txtpnWizytaGodzina;
	
	private JTextField txtWizytaUzytkownik;
	private JTextField txtWizytaLekarz;
	private JTextField txtWizytaRok;
	private JTextField txtWizytaMiesiac;
	private JTextField txtWizytaDzien;
	private JTextField txtWizytaGodzina;
	private JButton txtWizytaPrev;
	private JButton txtWizytaNext;
	private JButton txtWizytaRejestruj;
//rejestracja wizyty
	Configuration conf;
	
	
	
	public String wyswietl(String a)
	{
		return a;
	}
	
	/**p
	 * Create the panel.
	 */
	// KONSTRUKTOR @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO
	public Panel() 
	{
		setBackground(SystemColor.inactiveCaptionText);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		conf = new Configuration();
		watek = new Thread();
		//
		uzyt = new Uzytkownik();
		plac = new Platnosc();
		lek = new Lekarz();
		dane = new DaneOsobowe();
		sald = new Saldo();
		wizyt = new Wizyta();
		
		//
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 275, 174, 20);
		textField = new JTextField();
		textField.setBounds(195, 190, 174, 20);
		textField_2 = new JTextField();
		textField_2.setBounds(195, 220, 174, 20);
		//rejestracja
		btnRejestruj = new JButton("Rejestruj");
		btnRejestruj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		rejAdres = new JTextField();
		rejImie = new JTextField();
		rejNazwisko = new JTextField();
		rejPesel = new JTextField();
		rejTel = new JTextField();
		rejWiek = new JTextField();
		
		txtpnWiek = new JTextPane();
		txtpnWiek.setBackground(SystemColor.inactiveCaptionText);
		txtpnTelefon = new JTextPane();
		txtpnTelefon.setBackground(SystemColor.inactiveCaptionText);
		txtpnPesel = new JTextPane();
		txtpnPesel.setBackground(SystemColor.inactiveCaptionText);
		txtpnAdres_1 = new JTextPane();
		txtpnAdres_1.setBackground(SystemColor.inactiveCaptionText);
		txtpnNazwisko = new JTextPane();
		txtpnNazwisko.setBackground(SystemColor.inactiveCaptionText);
		txtpnAdres = new JTextPane();
		txtpnAdres.setBackground(SystemColor.inactiveCaptionText);
		
		txtz = new JTextField();
		txtFieldz = new JTextField();
		txtSpecjalizacja = new JTextField();
		
		final JTextPane txtpnWitaj = new JTextPane();
		final JTextPane txtpnTwojeSaldo = new JTextPane();
		final JButton btnNewButton_5 = new JButton("Twoje Dane Osobowe");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnNewButton_1 = new JButton("Zaplanowane Wizyty");
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnNewButton_2 = new JButton("Historia Wizyt");
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnNewButton_3 = new JButton("Zarejestruj Wizyte");
		
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnNewButton_4 = new JButton("Historia Platnosci");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		final JButton btnEKonto = new JButton("E-Konto");
		btnEKonto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		//dane osobowe =============================================================================================================== TODO
		
		 txtpnImie1 = new JTextPane();
		 txtpnImie1.setBackground(SystemColor.inactiveCaptionText);
		 txtpnNazwisko1 = new JTextPane();
		 txtpnNazwisko1.setBackground(SystemColor.inactiveCaptionText);
		 txtpnAdres1 = new JTextPane();
		 txtpnAdres1.setBackground(SystemColor.inactiveCaptionText);
		 txtpnPesel1 = new JTextPane();
		 txtpnPesel1.setBackground(SystemColor.inactiveCaptionText);
		 txtpnTelefon11 = new JTextPane();
		 txtpnTelefon11.setBackground(SystemColor.inactiveCaptionText);
		 
		textField1 = new JTextField();
		textField_11 = new JTextField();
		textField_21 = new JTextField();
		textField_31 = new JTextField();
		textField_41 = new JTextField();
		
		txtpnImie1.setVisible(false);
		 txtpnNazwisko1.setVisible(false);
		 txtpnAdres1.setVisible(false);
		 txtpnPesel1.setVisible(false);
		 txtpnTelefon11.setVisible(false);
		 
		textField1.setVisible(false);
		textField_11.setVisible(false);
		textField_21.setVisible(false);
		textField_31.setVisible(false);
		textField_41.setVisible(false);
		
		btnNewButton1.setVisible(false);
		
		txtpnImie1.setEditable(false);
		 txtpnNazwisko1.setEditable(false);
		 txtpnAdres1.setEditable(false);
		 txtpnPesel1.setEditable(false);
		 txtpnTelefon11.setEditable(false);
		 
		textField1.setEditable(true);
		textField_11.setEditable(true);
		textField_21.setEditable(true);
		textField_31.setEditable(true);
		textField_41.setEditable(true);
		
		
		txtpnImie1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnImie1.setText("Imie:");
		txtpnImie1.setBounds(160, 90, 60, 20);
		add(txtpnImie1);

		
		txtpnNazwisko1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnNazwisko1.setText("Nazwisko:");
		txtpnNazwisko1.setBounds(160, 120, 60, 20);
		add(txtpnNazwisko1);
		
		
		txtpnAdres1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnAdres1.setText("Adres:");
		txtpnAdres1.setBounds(160, 150, 60, 20);
		add(txtpnAdres1);
		
		
		txtpnPesel1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnPesel1.setText("Pesel:");
		txtpnPesel1.setBounds(160, 180, 60, 20);
		add(txtpnPesel1);
		
		
		txtpnTelefon11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnTelefon11.setText("Telefon:");
		txtpnTelefon11.setBounds(160, 210, 60, 20);
		add(txtpnTelefon11);
		
		
		textField1.setBounds(230, 90, 100, 20);
		add(textField1);
		textField1.setColumns(10);
		
		
		textField_11.setBounds(230, 120, 100, 20);
		add(textField_11);
		textField_11.setColumns(10);
		
		
		textField_21.setBounds(230, 150, 100, 20);
		add(textField_21);
		textField_21.setColumns(10);
		
		
		textField_31.setBounds(230, 180, 100, 20);
		add(textField_31);
		textField_31.setColumns(10);
		
		
		textField_41.setBounds(230, 210, 100, 20);
		add(textField_41);
		textField_41.setColumns(10);
		
		
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton1.setBounds(230, 241, 100, 23);
		add(btnNewButton1);
		
		//platnosc rej  =============================================================================================================== TODO
		
		txtpnNrKonta = new JTextPane();
		txtpnNrKonta.setBackground(SystemColor.inactiveCaptionText);
		txtpnNazwaBanku = new JTextPane();
		txtpnNazwaBanku.setBackground(SystemColor.inactiveCaptionText);
		txtpnKwota = new JTextPane();
		txtpnKwota.setBackground(SystemColor.inactiveCaptionText);
		
		txtNrKonta = new JTextField();
		txtNazwaBanku = new JTextField();
		txtKwota = new JTextField();
		
		txtpnNrKonta.setEditable(false);
		txtpnNrKonta.setText("Konto:");
		txtpnNrKonta.setBounds(10, 210, 50, 20);
		add(txtpnNrKonta);
		
		txtpnNazwaBanku.setEditable(false);
		txtpnNazwaBanku.setText("Bank:");
		txtpnNazwaBanku.setBounds(10, 240, 50, 20);
		add(txtpnNazwaBanku);
		
		txtpnKwota.setEditable(false);
		txtpnKwota.setText("Kwota:");
		txtpnKwota.setBounds(10, 270, 50, 20);
		add(txtpnKwota);
		
		txtNrKonta.setEditable(true);
		txtNrKonta.setBounds(70, 210, 100, 20);
		add(txtNrKonta);
		
		txtNazwaBanku.setEditable(true);
		txtNazwaBanku.setBounds(70, 240, 100, 20);
		add(txtNazwaBanku);
		
		txtKwota.setEditable(true);
		txtKwota.setBounds(70, 270, 100, 20);
		add(txtKwota);
		
		txtpnNrKonta.setVisible(false);
		txtpnNazwaBanku.setVisible(false);
		txtpnKwota.setVisible(false);
		txtNrKonta.setVisible(false);
		txtNazwaBanku.setVisible(false);
		txtKwota.setVisible(false);
		
		//platnosc EKonto  ============================================================================================================= TODO
		txtpnNrKonta1 = new JTextPane();
		txtpnNrKonta1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnNrKonta1.setBackground(SystemColor.inactiveCaptionText);
		txtpnNazwaBanku1 = new JTextPane();
		txtpnNazwaBanku1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnNazwaBanku1.setBackground(SystemColor.inactiveCaptionText);
		txtpnKwota1 = new JTextPane();
		txtpnKwota1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnKwota1.setBackground(SystemColor.inactiveCaptionText);
		
		txtNrKonta1 = new JTextField();
		txtNazwaBanku1 = new JTextField();
		txtKwota1 = new JTextField();
		
		txtpnNrKonta1.setEditable(false);
		txtpnNrKonta1.setText("Konto:");
		txtpnNrKonta1.setBounds(160, 90, 50, 20);
		add(txtpnNrKonta1);
		
		txtpnNazwaBanku1.setEditable(false);
		txtpnNazwaBanku1.setText("Bank:");
		txtpnNazwaBanku1.setBounds(160, 120, 50, 20);
		add(txtpnNazwaBanku1);
		
		txtpnKwota1.setEditable(false);
		txtpnKwota1.setText("Kwota:");
		txtpnKwota1.setBounds(160, 150, 50, 20);
		add(txtpnKwota1);
		
		txtNrKonta1.setEditable(true);
		txtNrKonta1.setBounds(230, 90, 100, 20);
		add(txtNrKonta1);
		
		txtNazwaBanku1.setEditable(true);
		txtNazwaBanku1.setBounds(230, 120, 100, 20);
		add(txtNazwaBanku1);
		
		txtKwota1.setEditable(true);
		txtKwota1.setBounds(230, 150, 100, 20);
		add(txtKwota1);
		
		
		btnPlatnosciEKonto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPlatnosciEKonto.setBounds(230, 180, 100, 20);
		add(btnPlatnosciEKonto);
		
		txtpnNrKonta1.setVisible(false);
		txtpnNazwaBanku1.setVisible(false);
		txtpnKwota1.setVisible(false);
		txtNrKonta1.setVisible(false);
		txtNazwaBanku1.setVisible(false);
		txtKwota1.setVisible(false);
		btnPlatnosciEKonto.setVisible(false);
		
		//rejestracja  ================================================================================================================= TODO
		
		txtpnLogin_1.setText("Login");
		txtpnLogin_1.setEditable(false);
		txtpnLogin_1.setBackground(SystemColor.inactiveCaptionText);
		txtpnLogin_1.setVisible(false);
		txtpnLogin_1.setBounds(179, 30, 41, 20);
		add(txtpnLogin_1);
		
	
		txtpnHaslo_1.setText("Haslo");
		txtpnHaslo_1.setEditable(false);
		txtpnHaslo_1.setVisible(false);
		txtpnHaslo_1.setBackground(SystemColor.inactiveCaptionText);
		txtpnHaslo_1.setBounds(179, 60, 41, 20);
		add(txtpnHaslo_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(230, 30, 100, 20);
		txtLogin.setVisible(false);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		txtHaslo = new JTextField();
		txtHaslo.setVisible(false);
		txtHaslo.setBounds(230, 60, 100, 20);
		add(txtHaslo);
		txtHaslo.setColumns(10);
		
		
		rejAdres.setColumns(10); 
		rejImie.setColumns(10);
		rejNazwisko.setColumns(15);
		rejPesel.setColumns(15);
		rejTel.setColumns(10);
		rejWiek.setColumns(10);
		
		rejAdres.setBounds(70, 90, 100, 20);
		rejImie.setBounds(70, 30, 100, 20);
		rejNazwisko.setBounds(70, 60, 100, 20);
		rejPesel.setBounds(70, 120, 100, 20);
		rejTel.setBounds(70, 150, 100, 20);
		rejWiek.setBounds(70, 180, 100, 20);
		
		rejAdres.setVisible(false);
		rejImie.setVisible(false);
		rejNazwisko.setVisible(false);
		rejPesel.setVisible(false);
		rejTel.setVisible(false);
		rejWiek.setVisible(false);
		
		txtpnNazwisko.setVisible(false);
		txtpnAdres_1.setVisible(false);
		txtpnPesel.setVisible(false);
		txtpnTelefon.setVisible(false);
		txtpnWiek.setVisible(false);
		txtpnAdres.setVisible(false);
		btnRejestruj.setVisible(false);
		
		txtpnNazwisko.setEditable(false);
		txtpnAdres_1.setEditable(false);
		txtpnPesel.setEditable(false);
		txtpnTelefon.setEditable(false);
		txtpnWiek.setEditable(false);
		txtpnAdres.setEditable(false);
		//wizyty ============================================================================================================================ TODO
		
		txtWizytaPrev = new JButton();
		
		txtWizytaPrev.setText("Prev");
		txtWizytaRejestruj = new JButton();
		
		txtWizytaRejestruj.setText("Rejestruj");
		txtWizytaNext = new JButton();
		
		txtWizytaNext.setText("Next");
		txtWizytaPrev.setName("Poprzedni");
		txtWizytaNext.setName("Nastepny");
		
		
		
		txtWizytaUzytkownik = new JTextField();
		txtWizytaLekarz= new JTextField();
		txtWizytaRok= new JTextField();
		txtWizytaMiesiac= new JTextField();
		txtWizytaDzien= new JTextField();
		txtWizytaGodzina= new JTextField();
		
		
		
		
		txtpnWizytaUzytkownik = new JTextPane();
		txtpnWizytaUzytkownik.setText("Uzytkownik");
		txtpnWizytaUzytkownik.setEditable(false);
		txtpnWizytaUzytkownik.setBackground(SystemColor.inactiveCaptionText);
		
		txtpnWizytaLekarz  = new JTextPane();
		txtpnWizytaLekarz.setText("Lekarz");
		txtpnWizytaLekarz.setEditable(false);
		txtpnWizytaLekarz.setBackground(SystemColor.inactiveCaptionText);
		
		txtpnWizytaRok = new JTextPane();
		txtpnWizytaRok.setText("Rok");
		txtpnWizytaRok.setEditable(false);
		txtpnWizytaRok.setBackground(SystemColor.inactiveCaptionText);
		
		txtpnWizytaMiesiac = new JTextPane();
		txtpnWizytaMiesiac.setText("Miesiac");
		txtpnWizytaMiesiac.setEditable(false);
		txtpnWizytaMiesiac.setBackground(SystemColor.inactiveCaptionText);
		
		txtpnWizytaDzien = new JTextPane();
		txtpnWizytaDzien.setText("Dzien");
		txtpnWizytaDzien.setEditable(false);
		txtpnWizytaDzien.setBackground(SystemColor.inactiveCaptionText);
		
		txtpnWizytaGodzina = new JTextPane();
		txtpnWizytaGodzina.setText("Godzina");
		txtpnWizytaGodzina.setEditable(false);
		txtpnWizytaGodzina.setBackground(SystemColor.inactiveCaptionText);
		 
		
		txtpnWizytaUzytkownik.setBounds(160, 90, 100, 20);
		txtpnWizytaLekarz.setBounds(160, 120, 100, 20);
		txtpnWizytaRok.setBounds(160, 150, 100, 20);
		txtpnWizytaMiesiac.setBounds(160, 180, 100, 20);
		txtpnWizytaDzien.setBounds(160, 210, 100, 20);
		txtpnWizytaGodzina.setBounds(160, 240, 100, 20);
		
		txtWizytaUzytkownik.setBounds(230, 90, 100, 20);
		txtWizytaLekarz.setBounds(230, 120, 100, 20);
		txtWizytaRok.setBounds(230, 150, 100, 20);
		txtWizytaMiesiac.setBounds(230, 180, 100, 20);
		txtWizytaDzien.setBounds(230, 210, 100, 20);
		txtWizytaGodzina.setBounds(230, 240, 100, 20);
		
		txtWizytaPrev.setBounds(200, 270, 60, 20);
		txtWizytaNext.setBounds(265, 270, 60, 20);
		txtWizytaRejestruj.setBounds(200, 270, 125, 20);
		
		txtWizytaUzytkownik.setVisible(false);
		txtWizytaLekarz.setVisible(false);
		txtWizytaRok.setVisible(false);
		txtWizytaMiesiac.setVisible(false);
		txtWizytaDzien.setVisible(false);
		txtWizytaGodzina.setVisible(false);
		txtpnWizytaUzytkownik.setVisible(false);
		txtpnWizytaLekarz.setVisible(false);
		txtpnWizytaRok.setVisible(false);
		txtpnWizytaMiesiac.setVisible(false);
		txtpnWizytaDzien.setVisible(false);
		txtpnWizytaGodzina.setVisible(false);
		txtWizytaPrev.setVisible(false);
		txtWizytaNext.setVisible(false);
		txtWizytaRejestruj.setVisible(false);
		
		add(txtWizytaUzytkownik);
		add(txtWizytaLekarz);
		add(txtWizytaRok);
		add(txtWizytaMiesiac);
		add(txtWizytaDzien);
		add(txtWizytaGodzina);
		add(txtpnWizytaUzytkownik);
		add(txtpnWizytaLekarz);
		add(txtpnWizytaRok);
		add(txtpnWizytaMiesiac);
		add(txtpnWizytaDzien);
		add(txtpnWizytaGodzina);
		add(txtWizytaPrev);
		add(txtWizytaNext);
		add(txtWizytaRejestruj);
		
		//zalogowany ======================================================================================================================= TODO
		txtz.setVisible(false);
		txtpnWitaj.setVisible(false);
		txtFieldz.setVisible(false);
		txtSpecjalizacja.setVisible(false);
		txtpnTwojeSaldo.setVisible(false);
		btnNewButton_1.setVisible(false);
		btnNewButton_2.setVisible(false);
		btnWyloguj.setVisible(false);
		btnNewButton_3.setVisible(false);
		btnNewButton_4.setVisible(false);
		btnNewButton_5.setVisible(false);
		btnEKonto.setVisible(false);
		
		
		
		
		textField.setColumns(10);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(195, 245, 69, 23);
		
		btnRejestracja.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRejestracja.setBounds(274, 245, 95, 23);
		
		// ACTION LISTEN'ERY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO
		// WYLOGUJ  ======================================================================================================================= TODO
		btnWyloguj.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//przelaczanie ekranow
				txtpnImie1.setVisible(false);
				 txtpnNazwisko1.setVisible(false);
				 txtpnAdres1.setVisible(false);
				 txtpnPesel1.setVisible(false);
				 txtpnTelefon11.setVisible(false);
				 
				textField1.setVisible(false);
				textField_11.setVisible(false);
				textField_21.setVisible(false);
				textField_31.setVisible(false);
				textField_41.setVisible(false);
				btnNewButton1.setVisible(false);
				
				txtpnNrKonta1.setVisible(false);
				txtpnNazwaBanku1.setVisible(false);
				txtpnKwota1.setVisible(false);
				txtNrKonta1.setVisible(false);
				txtNazwaBanku1.setVisible(false);
				txtKwota1.setVisible(false);
				btnPlatnosciEKonto.setVisible(false);
				////////////////////////////////////////////////////////////////////
				txtz.setVisible(false);
				txtpnWitaj.setVisible(false);
				txtFieldz.setVisible(false);
				txtSpecjalizacja.setVisible(false);
				txtpnTwojeSaldo.setVisible(false);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnWyloguj.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_5.setVisible(false);
				btnEKonto.setVisible(false);
				
				txtpnLogin.setVisible(true);
				txtpnHaslo.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				btnNewButton.setVisible(true);
				textField.setVisible(true);
				btnRejestracja.setVisible(true);
				txtpnLogin_1.setVisible(false);
				txtpnHaslo_1.setVisible(false);
				txtLogin.setVisible(false);
				txtHaslo.setVisible(false);
				
				txtWizytaUzytkownik.setVisible(false);
				txtWizytaLekarz.setVisible(false);
				txtWizytaRok.setVisible(false);
				txtWizytaMiesiac.setVisible(false);
				txtWizytaDzien.setVisible(false);
				txtWizytaGodzina.setVisible(false);
				txtpnWizytaUzytkownik.setVisible(false);
				txtpnWizytaLekarz.setVisible(false);
				txtpnWizytaRok.setVisible(false);
				txtpnWizytaMiesiac.setVisible(false);
				txtpnWizytaDzien.setVisible(false);
				txtpnWizytaGodzina.setVisible(false);
				txtWizytaPrev.setVisible(false);
				txtWizytaNext.setVisible(false);
				txtWizytaRejestruj.setVisible(false);
			}
		});
		//ZALOGUJ  ======================================================================================================================= TODO
		btnNewButton.setText("Zaloguj");
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String login = getTextField0();
				String haslo = getTextField1();
				//System.out.println(login);
				//System.out.println(haslo);
				
				
				
			      int registryPort = conf.getRmiPort();
				
			//connection		
					IPrzychodniaSerwis ps=null;
					 try {
						ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
					 }
					 catch (MalformedURLException e1) {
							
							e1.printStackTrace();
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							
							e1.printStackTrace();
						}
					 
						try {
							
							if(ps.login(login, haslo))
							{
								
								uzytkownik = ps.uzytkownik(login);
								daneOsobowe = ps.daneOsobowe(uzytkownik.getDane());
								platnosc = ps.platnosc(uzytkownik.getPlatnosc());
								saldo = ps.saldo(uzytkownik.getPlatnosc());
								if(uzytkownik.getCzyLekarz()==1)
									lekarz = ps.lekarz(uzytkownik.getLekarz());
								
								
								//done
								txtpnLogin.setVisible(false);
								txtpnHaslo.setVisible(false);
								textField_1.setVisible(false);
								textField_2.setVisible(false);
								btnNewButton.setVisible(false);
								textField.setVisible(false);
								btnRejestracja.setVisible(false);
								txtz.setVisible(true);
								txtpnWitaj.setVisible(true);
								txtFieldz.setVisible(true);
								txtpnTwojeSaldo.setVisible(true);
								btnNewButton_1.setVisible(true);
								btnNewButton_2.setVisible(false);
								btnWyloguj.setVisible(true);
								btnNewButton_3.setVisible(true);
								btnNewButton_4.setVisible(false);
								btnNewButton_5.setVisible(true);
								btnEKonto.setVisible(true);
								
								txtz.setText(Double.toString(saldo.getSaldo1()));
								txtFieldz.setText(daneOsobowe.getImie()+" "+daneOsobowe.getNazwisko());
								if(uzytkownik.getCzyLekarz()==1)
									{
									btnNewButton_3.setEnabled(false);
									txtSpecjalizacja.setVisible(true);
									txtFieldz.setText("dr "+daneOsobowe.getImie()+" "+daneOsobowe.getNazwisko());
									txtSpecjalizacja.setText(lekarz.getSpecjalizacja());
									}
								else{
									btnNewButton_3.setEnabled(true);
								}
								
							}
							else
							{
								textField_1.setText("Nieprawidlowe dane");
							}
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						}
					
					
				//sprawdzanie 

					
					
					
					
					
				
					
//				}
			
			
			}});
		

		//REJESTRACJA OKNO  ======================================================================================================================= TODO
		btnRejestracja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtpnLogin.setVisible(false);
				txtpnHaslo.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				btnNewButton.setVisible(false);
				textField.setVisible(false);
				btnRejestracja.setVisible(false);
				
				rejAdres.setVisible(true);
				rejImie.setVisible(true);
				rejNazwisko.setVisible(true);
				rejPesel.setVisible(true);
				rejTel.setVisible(true);
				rejWiek.setVisible(true);
				
				txtpnNazwisko.setVisible(true);
				txtpnAdres_1.setVisible(true);
				txtpnPesel.setVisible(true);
				txtpnTelefon.setVisible(true);
				txtpnWiek.setVisible(true);
				txtpnAdres.setVisible(true);
				
				btnRejestruj.setVisible(true);
				
				txtpnNrKonta.setVisible(true);
				txtpnNazwaBanku.setVisible(true);
				txtpnKwota.setVisible(true);
				txtNrKonta.setVisible(true);
				txtNazwaBanku.setVisible(true);
				txtKwota.setVisible(true);
				txtpnLogin_1.setVisible(true);
				txtpnHaslo_1.setVisible(true);
				txtLogin.setVisible(true);
				txtHaslo.setVisible(true);
			}
		});
		//REJESTRACJA BUTTON  ======================================================================================================================= TODO
		btnRejestruj.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//String think = "INSERT INTO `tabela` ( `id` , `produkt` , `cena` ) VALUES (NULL , ‘chleb’, ‘2.40′), (NULL , ‘mąka’, ‘3.55′), (NULL , ‘jajka’, ‘5.87′)";
				
				
			     
				int registryPort = conf.getRmiPort();
				
			//connection		
					IPrzychodniaSerwis ps= null;
					 try {
						ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
						
					} catch (MalformedURLException e1) {
						
						e1.printStackTrace();
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						
						e1.printStackTrace();
					}
				
				
				dane.setPesel(Integer.parseInt(rejPesel.getText()));
				dane.setImie(rejImie.getText());
				dane.setNazwisko(rejNazwisko.getText());
				dane.setAdres(rejAdres.getText());
				dane.setTel(Integer.parseInt(rejTel.getText()));
				dane.setWiek(Integer.parseInt(rejWiek.getText()));
				
				
				uzyt.setCzyLekarz(0);
				uzyt.setDane(Integer.parseInt(rejPesel.getText()));
				uzyt.setHaslo(txtHaslo.getText());
				uzyt.setNazwa(txtLogin.getText());
				uzyt.setPlatnosc(Integer.parseInt(txtNrKonta.getText()));
				uzyt.setSaldo(Integer.parseInt(txtNrKonta.getText()));
				
				
				plac.setKwota(Double.parseDouble(txtKwota.getText()));
				plac.setNazwaBanku(txtNazwaBanku.getText());
				plac.setNrKonta(Integer.parseInt(txtNrKonta.getText()));
				
				
				sald.setId(Integer.parseInt(txtNrKonta.getText()));
				sald.setSaldo1(Double.parseDouble(txtKwota.getText()));
				
				try {
					FileOutputStream serUzyt = new FileOutputStream("c:/Uzyt.ser");
					ObjectOutputStream objUzyt = new ObjectOutputStream(serUzyt);
					objUzyt.writeObject(uzyt);
					objUzyt.close();
					serUzyt.close();
					
					FileOutputStream serDane = new FileOutputStream("c:/Dane.ser");
					ObjectOutputStream objDane = new ObjectOutputStream(serDane);
					objDane.writeObject(dane);
					objDane.close();
					serDane.close();
					
					FileOutputStream serPlac = new FileOutputStream("c:/Plac.ser");
					ObjectOutputStream objPlac = new ObjectOutputStream(serPlac);
					objPlac.writeObject(plac);
					objPlac.close();
					serPlac.close();
					
					FileOutputStream serSaldo = new FileOutputStream("c:/Saldo.ser");
					ObjectOutputStream objSaldo = new ObjectOutputStream(serSaldo);
					objSaldo.writeObject(sald);
					objSaldo.close();
					serSaldo.close();
					
					ps.rejestracja();
					
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					} 
//				watek = new Thread(new ButtonZapis(0));
//				watek.start(); //start watku 
					catch (IOException e1) {
						
						e1.printStackTrace();
					}
					

				
				
				
				txtpnLogin.setVisible(true);
				txtpnHaslo.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				btnNewButton.setVisible(true);
				textField.setVisible(true);
				btnRejestracja.setVisible(true);
				
				rejAdres.setVisible(false);
				rejImie.setVisible(false);
				rejNazwisko.setVisible(false);
				rejPesel.setVisible(false);
				rejTel.setVisible(false);
				rejWiek.setVisible(false);
				
				txtpnNazwisko.setVisible(false);
				txtpnAdres_1.setVisible(false);
				txtpnPesel.setVisible(false);
				txtpnTelefon.setVisible(false);
				txtpnWiek.setVisible(false);
				txtpnAdres.setVisible(false);
				
				txtpnNrKonta.setVisible(false);
				txtpnNazwaBanku.setVisible(false);
				txtpnKwota.setVisible(false);
				txtNrKonta.setVisible(false);
				txtNazwaBanku.setVisible(false);
				txtKwota.setVisible(false);
				txtpnLogin_1.setVisible(false);
				txtpnHaslo_1.setVisible(false);
				txtLogin.setVisible(false);
				txtHaslo.setVisible(false);
				
				btnRejestruj.setVisible(false);
			}
		});
		//EDYCJA DANYCH OSOBOWYCH OKNO  ======================================================================================================================= TODO
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//przelaczanie na aktywna strone
				txtpnNrKonta1.setVisible(false);
				txtpnNazwaBanku1.setVisible(false);
				txtpnKwota1.setVisible(false);
				txtNrKonta1.setVisible(false);
				txtNazwaBanku1.setVisible(false);
				txtKwota1.setVisible(false);
				btnPlatnosciEKonto.setVisible(false);
				txtWizytaUzytkownik.setVisible(false);
				txtWizytaLekarz.setVisible(false);
				txtWizytaRok.setVisible(false);
				txtWizytaMiesiac.setVisible(false);
				txtWizytaDzien.setVisible(false);
				txtWizytaGodzina.setVisible(false);
				txtpnWizytaUzytkownik.setVisible(false);
				txtpnWizytaLekarz.setVisible(false);
				txtpnWizytaRok.setVisible(false);
				txtpnWizytaMiesiac.setVisible(false);
				txtpnWizytaDzien.setVisible(false);
				txtpnWizytaGodzina.setVisible(false);
				txtWizytaPrev.setVisible(false);
				txtWizytaNext.setVisible(false);
				txtWizytaRejestruj.setVisible(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////
				txtpnImie1.setVisible(true);
				 txtpnNazwisko1.setVisible(true);
				 txtpnAdres1.setVisible(true);
				 txtpnPesel1.setVisible(true);
				 txtpnTelefon11.setVisible(true);
				 
				 textField1.setText(daneOsobowe.getImie());
				 textField_11.setText(daneOsobowe.getNazwisko());
				 textField_21.setText(daneOsobowe.getAdres());
				 textField_31.setText(Integer.toString(daneOsobowe.getPesel()));
				 textField_41.setText(Integer.toString(daneOsobowe.getTel()));
				 
				textField1.setVisible(true);
				textField_11.setVisible(true);
				textField_21.setVisible(true);
				textField_31.setVisible(true);
				textField_41.setVisible(true);
				btnNewButton1.setVisible(true);
			}
		});
		//BUTTON DANYCH OSOBOWYCH  ======================================================================================================================= TODO
		btnNewButton1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
			      int registryPort = conf.getRmiPort();
				
			//connection		
					IPrzychodniaSerwis ps=null;
					 try {
						ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
						
					} catch (MalformedURLException e1) {
						
						e1.printStackTrace();
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						
						e1.printStackTrace();
					}
				
					 daneOsobowe.setImie(textField1.getText());
					 daneOsobowe.setNazwisko(textField_11.getText());
					 daneOsobowe.setAdres(textField_21.getText());
					 daneOsobowe.setPesel(Integer.parseInt(textField_31.getText()));
					 daneOsobowe.setTel(Integer.parseInt(textField_41.getText()));
					 uzytkownik.setDane(daneOsobowe.getPesel());
					 
//					 watek = new Thread(new ButtonZapis(1));
					 	plac=platnosc;
						uzyt=uzytkownik;
						sald=saldo;
						dane=daneOsobowe;

						try {
							FileOutputStream serUzyt = new FileOutputStream("c:/Uzyt.ser");
							ObjectOutputStream objUzyt = new ObjectOutputStream(serUzyt);
							objUzyt.writeObject(uzyt);
							objUzyt.close();
							serUzyt.close();
							
							FileOutputStream serDane = new FileOutputStream("c:/Dane.ser");
							ObjectOutputStream objDane = new ObjectOutputStream(serDane);
							objDane.writeObject(dane);
							objDane.close();
							serDane.close();
							
							FileOutputStream serPlac = new FileOutputStream("c:/Plac.ser");
							ObjectOutputStream objPlac = new ObjectOutputStream(serPlac);
							objPlac.writeObject(plac);
							objPlac.close();
							serPlac.close();
							
							FileOutputStream serSaldo = new FileOutputStream("c:/Saldo.ser");
							ObjectOutputStream objSaldo = new ObjectOutputStream(serSaldo);
							objSaldo.writeObject(sald);
							objSaldo.close();
							serSaldo.close();
							
							ps.update();
							} catch (RemoteException e1) {
								
								e1.printStackTrace();
							} catch (IOException e1) {
								
								e1.printStackTrace();
							} 
					 
						txtz.setText(Double.toString(saldo.getSaldo1()));
						txtFieldz.setText(daneOsobowe.getImie()+" "+daneOsobowe.getNazwisko());
						repaint();
				
				txtpnImie1.setVisible(false);
				 txtpnNazwisko1.setVisible(false);
				 txtpnAdres1.setVisible(false);
				 txtpnPesel1.setVisible(false);
				 txtpnTelefon11.setVisible(false);
				 
				 
				 
				textField1.setVisible(false);
				textField_11.setVisible(false);
				textField_21.setVisible(false);
				textField_31.setVisible(false);
				textField_41.setVisible(false);
				btnNewButton1.setVisible(false);
			}
		});
		//PLATNOSCI OKNO  ======================================================================================================================= TODO
		btnEKonto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//przelaczanie na aktywna strone
				txtpnImie1.setVisible(false);
				 txtpnNazwisko1.setVisible(false);
				 txtpnAdres1.setVisible(false);
				 txtpnPesel1.setVisible(false);
				 txtpnTelefon11.setVisible(false);
				 
				textField1.setVisible(false);
				textField_11.setVisible(false);
				textField_21.setVisible(false);
				textField_31.setVisible(false);
				textField_41.setVisible(false);
				btnNewButton1.setVisible(false);
				txtWizytaUzytkownik.setVisible(false);
				txtWizytaLekarz.setVisible(false);
				txtWizytaRok.setVisible(false);
				txtWizytaMiesiac.setVisible(false);
				txtWizytaDzien.setVisible(false);
				txtWizytaGodzina.setVisible(false);
				txtpnWizytaUzytkownik.setVisible(false);
				txtpnWizytaLekarz.setVisible(false);
				txtpnWizytaRok.setVisible(false);
				txtpnWizytaMiesiac.setVisible(false);
				txtpnWizytaDzien.setVisible(false);
				txtpnWizytaGodzina.setVisible(false);
				txtWizytaPrev.setVisible(false);
				txtWizytaNext.setVisible(false);
				txtWizytaRejestruj.setVisible(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				txtNrKonta1.setText(Integer.toString(platnosc.getNrKonta()));
				txtNazwaBanku1.setText(platnosc.getNazwaBanku());
				txtKwota1.setText(Double.toString(platnosc.getKwota()));
				
				txtpnNrKonta1.setVisible(true);
				txtpnNazwaBanku1.setVisible(true);
				txtpnKwota1.setVisible(true);
				txtNrKonta1.setVisible(true);
				txtNazwaBanku1.setVisible(true);
				txtKwota1.setVisible(true);
				btnPlatnosciEKonto.setVisible(true);
			}
		});
		//BUTTON PLATNOSCI  ======================================================================================================================= TODO
		btnPlatnosciEKonto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				
			      int registryPort = conf.getRmiPort();
				
			//connection		
					IPrzychodniaSerwis ps=null;
					 try {
						ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
						
					} catch (MalformedURLException e1) {
						
						e1.printStackTrace();
					} catch (RemoteException e1) {
					
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						
						e1.printStackTrace();
					}
				platnosc.setKwota(Double.parseDouble(txtKwota1.getText()));
				platnosc.setNazwaBanku(txtNazwaBanku1.getText());
				platnosc.setNrKonta(Integer.parseInt(txtNrKonta1.getText()));
				uzytkownik.setPlatnosc(platnosc.getNrKonta());
				uzytkownik.setSaldo(platnosc.getNrKonta());
				saldo.setSaldo1(saldo.getSaldo1()+platnosc.getKwota());
				
				plac=platnosc;
				uzyt=uzytkownik;
				sald=saldo;
				dane=daneOsobowe;
//				watek = new Thread(new ButtonZapis(1));
//				watek.start();
				try {
					FileOutputStream serUzyt = new FileOutputStream("c:/Uzyt.ser");
					ObjectOutputStream objUzyt = new ObjectOutputStream(serUzyt);
					objUzyt.writeObject(uzyt);
					objUzyt.close();
					serUzyt.close();
					
					FileOutputStream serDane = new FileOutputStream("c:/Dane.ser");
					ObjectOutputStream objDane = new ObjectOutputStream(serDane);
					objDane.writeObject(dane);
					objDane.close();
					serDane.close();
					
					FileOutputStream serPlac = new FileOutputStream("c:/Plac.ser");
					ObjectOutputStream objPlac = new ObjectOutputStream(serPlac);
					objPlac.writeObject(plac);
					objPlac.close();
					serPlac.close();
					
					FileOutputStream serSaldo = new FileOutputStream("c:/Saldo.ser");
					ObjectOutputStream objSaldo = new ObjectOutputStream(serSaldo);
					objSaldo.writeObject(sald);
					objSaldo.close();
					serSaldo.close();
					
					ps.update();
					
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				txtz.setText(Double.toString(saldo.getSaldo1()));
				txtFieldz.setText(daneOsobowe.getImie()+" "+daneOsobowe.getNazwisko());
				repaint();
				
				txtpnNrKonta1.setVisible(false);
				txtpnNazwaBanku1.setVisible(false);
				txtpnKwota1.setVisible(false);
				txtNrKonta1.setVisible(false);
				txtNazwaBanku1.setVisible(false);
				txtKwota1.setVisible(false);
				btnPlatnosciEKonto.setVisible(false);
			}
		});
		//REJESTRACJA WIZYTY OKNO ===================================================================================================== TODO
		btnNewButton_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtpnImie1.setVisible(false);
				 txtpnNazwisko1.setVisible(false);
				 txtpnAdres1.setVisible(false);
				 txtpnPesel1.setVisible(false);
				 txtpnTelefon11.setVisible(false);
				 
				textField1.setVisible(false);
				textField_11.setVisible(false);
				textField_21.setVisible(false);
				textField_31.setVisible(false);
				textField_41.setVisible(false);
				btnNewButton1.setVisible(false);
				txtWizytaPrev.setVisible(false);
				txtWizytaNext.setVisible(false);
				txtpnNrKonta1.setVisible(false);
				txtpnNazwaBanku1.setVisible(false);
				txtpnKwota1.setVisible(false);
				txtNrKonta1.setVisible(false);
				txtNazwaBanku1.setVisible(false);
				txtKwota1.setVisible(false);
				btnPlatnosciEKonto.setVisible(false);
				
				txtWizytaUzytkownik.setVisible(true);
				txtWizytaUzytkownik.setEditable(false);
				txtWizytaUzytkownik.setText(uzytkownik.getNazwa());
				
				txtWizytaLekarz.setVisible(true);
				txtWizytaRok.setVisible(true);
				txtWizytaMiesiac.setVisible(true);
				txtWizytaDzien.setVisible(true);
				txtWizytaGodzina.setVisible(true);
				txtpnWizytaUzytkownik.setVisible(true);
				txtpnWizytaLekarz.setVisible(true);
				txtpnWizytaRok.setVisible(true);
				txtpnWizytaMiesiac.setVisible(true);
				txtpnWizytaDzien.setVisible(true);
				txtpnWizytaGodzina.setVisible(true);
//				txtWizytaPrev.setVisible(true);
//				txtWizytaNext.setVisible(true);
				txtWizytaRejestruj.setVisible(true);
				
			}
		});
		//BUTTON REJESTRACJA WIZYTY ================================================================================================================TODO
		txtWizytaRejestruj.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				int registryPort = conf.getRmiPort();
				
				//connection		
						IPrzychodniaSerwis ps=null;
						 try {
							ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
							
						} catch (MalformedURLException e1) {
							
							e1.printStackTrace();
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							
							e1.printStackTrace();
						}
					
						 //wizyt.setPacjent(uzytkownik.getNazwa());
						 wizyt.setLekarz(txtWizytaLekarz.getText());
						 wizyt.setRok(Integer.parseInt(txtWizytaRok.getText()));
						 wizyt.setMiesiac(Integer.parseInt(txtWizytaMiesiac.getText()));
						 wizyt.setDzien(Integer.parseInt(txtWizytaDzien.getText()));
						 wizyt.setGodzina(Integer.parseInt(txtWizytaGodzina.getText()));
						 
//						 watek = new Thread(new ButtonZapis(1));
							

							try {
								FileOutputStream serWizyt = new FileOutputStream("c:/Wizyt.ser");
								ObjectOutputStream objWizyt = new ObjectOutputStream(serWizyt);
								objWizyt.writeObject(wizyt);
								objWizyt.close();
								serWizyt.close();
								
								
								ps.updateWizyta();
								} catch (RemoteException e1) {
									
									e1.printStackTrace();
								} catch (IOException e1) {
									
									e1.printStackTrace();
								} 
				
				
				
				txtWizytaUzytkownik.setVisible(false);
				txtWizytaLekarz.setVisible(false);
				txtWizytaRok.setVisible(false);
				txtWizytaMiesiac.setVisible(false);
				txtWizytaDzien.setVisible(false);
				txtWizytaGodzina.setVisible(false);
				txtpnWizytaUzytkownik.setVisible(false);
				txtpnWizytaLekarz.setVisible(false);
				txtpnWizytaRok.setVisible(false);
				txtpnWizytaMiesiac.setVisible(false);
				txtpnWizytaDzien.setVisible(false);
				txtpnWizytaGodzina.setVisible(false);
				txtWizytaRejestruj.setVisible(false);
			}
		});
		//ZAPLANOWANE WIZYTY  ======================================================================================================================= TODO
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				licznik=0;
				txtpnImie1.setVisible(false);
				 txtpnNazwisko1.setVisible(false);
				 txtpnAdres1.setVisible(false);
				 txtpnPesel1.setVisible(false);
				 txtpnTelefon11.setVisible(false);
				 
				textField1.setVisible(false);
				textField_11.setVisible(false);
				textField_21.setVisible(false);
				textField_31.setVisible(false);
				textField_41.setVisible(false);
				btnNewButton1.setVisible(false);
				txtWizytaPrev.setVisible(false);
				txtWizytaNext.setVisible(false);
				txtpnNrKonta1.setVisible(false);
				txtpnNazwaBanku1.setVisible(false);
				txtpnKwota1.setVisible(false);
				txtNrKonta1.setVisible(false);
				txtNazwaBanku1.setVisible(false);
				txtKwota1.setVisible(false);
				btnPlatnosciEKonto.setVisible(false);
				
				txtWizytaRejestruj.setVisible(false);
	//////////////////////////////////////////////////////////////////////////////////////////
				txtWizytaUzytkownik.setVisible(true);
				txtWizytaLekarz.setVisible(true);
				txtWizytaRok.setVisible(true);
				txtWizytaMiesiac.setVisible(true);
				txtWizytaDzien.setVisible(true);
				txtWizytaGodzina.setVisible(true);
				txtpnWizytaUzytkownik.setVisible(true);
				txtpnWizytaLekarz.setVisible(true);
				txtpnWizytaRok.setVisible(true);
				txtpnWizytaMiesiac.setVisible(true);
				txtpnWizytaDzien.setVisible(true);
				txtpnWizytaGodzina.setVisible(true);
				txtWizytaPrev.setVisible(true);
				txtWizytaNext.setVisible(true);
				
				txtWizytaUzytkownik.setEditable(false);
				txtWizytaLekarz.setEditable(false);
				txtWizytaRok.setEditable(false);
				txtWizytaMiesiac.setEditable(false);
				txtWizytaDzien.setEditable(false);
				txtWizytaGodzina.setEditable(false);
				txtpnWizytaUzytkownik.setEditable(false);
				txtpnWizytaLekarz.setEditable(false);
				txtpnWizytaRok.setEditable(false);
				txtpnWizytaMiesiac.setEditable(false);
				txtpnWizytaDzien.setEditable(false);
				txtpnWizytaGodzina.setEditable(false);
				
				int registryPort = conf.getRmiPort();
				
				//connection		
						IPrzychodniaSerwis ps=null;
						 try {
							ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
							
						} catch (MalformedURLException e1) {
							
							e1.printStackTrace();
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							
							e1.printStackTrace();
						}
				try {
					list = ps.wizyty(uzytkownik.getNazwa(), uzytkownik.getCzyLekarz());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				funWizyty(licznik);
		}});
		
		//PREV ZAPLANOWANE WIZYTY  ======================================================================================================================= TODO
		txtWizytaPrev.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				licznik--;
				if(licznik==0)
					txtWizytaPrev.setEnabled(false);
				funWizyty(licznik);
				if(licznik+1<list.size())
					txtWizytaNext.setEnabled(true);
				
			}
		});
		
		//NEXT ZAPLANOWANE WIZYTY  ======================================================================================================================= TODO
		txtWizytaNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				licznik++;
				
				if(licznik+1==list.size())
					txtWizytaNext.setEnabled(false);
				funWizyty(licznik);
				if(licznik>0)
					txtWizytaPrev.setEnabled(true);
				
			}
		});
		
		// USTAWIENIA  ======================================================================================================================= TODO
		txtpnLogin.setForeground(Color.BLACK);
		txtpnLogin.setBackground(SystemColor.inactiveCaptionText);
		txtpnLogin.setBounds(150, 190, 35, 20);
		
		
		txtpnLogin.setEditable(false);
		txtpnLogin.setText("Login");
		txtpnHaslo.setForeground(Color.BLACK);
		txtpnHaslo.setBackground(SystemColor.inactiveCaptionText);
		txtpnHaslo.setBounds(150, 220, 35, 20);
		
		
		txtpnHaslo.setEditable(false);
		txtpnHaslo.setText("Haslo");
		
		
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		
		textField_2.setColumns(10);
		setLayout(null);
		add(txtpnLogin);
		add(txtpnHaslo);
		add(textField_2);
		add(textField);
		add(textField_1);
		add(btnNewButton);
		add(btnRejestracja);
		add(rejAdres);
		add(rejImie);
		add(rejNazwisko);
		add(rejPesel);
		add(rejTel);
		add(rejWiek);
		
		
		txtpnAdres.setText("Imie");
		txtpnAdres.setBounds(10, 30, 50, 20);
		add(txtpnAdres);
		
		
		txtpnNazwisko.setText("Nazwisko");
		txtpnNazwisko.setBounds(10, 60, 50, 20);
		add(txtpnNazwisko);
		
		
		txtpnAdres_1.setText("Adres");
		txtpnAdres_1.setBounds(10, 90, 50, 20);
		add(txtpnAdres_1);
		
		
		txtpnPesel.setText("Pesel");
		txtpnPesel.setBounds(10, 120, 50, 20);
		add(txtpnPesel);
		
		
		txtpnTelefon.setText("Telefon");
		txtpnTelefon.setBounds(10, 150, 50, 20);
		add(txtpnTelefon);
		
		
		txtpnWiek.setText("Wiek");
		txtpnWiek.setBounds(10, 180, 50, 20);
		add(txtpnWiek);
		
		
		btnRejestruj.setBounds(70, 300, 100, 23);
		add(btnRejestruj);
		
		//Zalogowany 
		
		
		btnNewButton_5.setBounds(10, 90, 140, 40);
		add(btnNewButton_5);
		
		
		txtz.setHorizontalAlignment(SwingConstants.CENTER);
		txtz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtz.setText("198,55z\u0142");
		txtz.setEditable(false);
		txtz.setBounds(150, 51, 180, 29);
		add(txtz);
		txtz.setColumns(10);
		
		
		txtpnWitaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnWitaj.setBackground(new Color(212, 208, 200));
		txtpnWitaj.setText("Witaj:");
		txtpnWitaj.setEditable(false);
		txtpnWitaj.setBounds(10, 10, 65, 30);
		add(txtpnWitaj);
		

		
		txtFieldz.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldz.setText("Hermenegilda Karczynski");
		txtFieldz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFieldz.setEditable(false);
		txtFieldz.setBounds(85, 10, 245, 30);
		add(txtFieldz);
		txtFieldz.setColumns(10);
		
		txtSpecjalizacja.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpecjalizacja.setText("Hermenegilda Karczynski");
		txtSpecjalizacja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSpecjalizacja.setEditable(false);
		txtSpecjalizacja.setBounds(320, 10, 185, 30);
		add(txtSpecjalizacja);
		txtSpecjalizacja.setColumns(10);
		
		
		txtpnTwojeSaldo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnTwojeSaldo.setBackground(new Color(212, 208, 200));
		txtpnTwojeSaldo.setText("Twoje Saldo:");
		txtpnTwojeSaldo.setEditable(false);
		txtpnTwojeSaldo.setBounds(10, 50, 130, 30);
		add(txtpnTwojeSaldo);
		
		
		btnNewButton_1.setBounds(10, 140, 140, 40);
		add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(10, 310, 140, 40);
		add(btnNewButton_2);
		
		
		btnWyloguj.setBounds(10, 430, 140, 40);
		add(btnWyloguj);
		
		
		btnNewButton_3.setBounds(10, 190, 140, 40);
		add(btnNewButton_3);
		
		
		btnNewButton_4.setBounds(10, 360, 140, 40);
		add(btnNewButton_4);
		
		
		
		
		btnEKonto.setBounds(10, 240, 140, 40);
		add(btnEKonto);
		
		
		
		
		
		
}
	public void funWizyty(int licz)
	{
		int registryPort = conf.getRmiPort();
	
//connection		
		IPrzychodniaSerwis ps=null;
		 try {
			ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
			
		} catch (MalformedURLException e1) {
			
			e1.printStackTrace();
		} catch (RemoteException e1) {
		
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			
			e1.printStackTrace();
		}
		if(!list.isEmpty())
		{
			txtWizytaPrev.setEnabled(false);
			if(licznik==list.size())
				txtWizytaNext.setEnabled(false);
			try {
				wizyt = ps.wizyta(list.get(licz));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					txtWizytaUzytkownik.setText(wizyt.getPacjent());
					txtWizytaLekarz.setText(wizyt.getLekarz());
					txtWizytaRok.setText(Integer.toString((wizyt.getRok())));
					txtWizytaMiesiac.setText(Integer.toString((wizyt.getMiesiac())));
					txtWizytaDzien.setText(Integer.toString((wizyt.getDzien())));
					txtWizytaGodzina.setText(Integer.toString((wizyt.getGodzina())));
				
				}
		else
		{
			txtpnWizytaUzytkownik.setText("Brak Wizyt");
			txtWizytaPrev.setEnabled(false);
			txtWizytaNext.setEnabled(false);
		}
		repaint();
	}

	// WATEK  ======================================================================================================================= TODO
	class RunWizyty implements Runnable
	{
		
		IPrzychodniaSerwis ps;
		int i;
		RunWizyty(int _i)
		{
			i=_i;
		}
		
		@Override
		public void run() 
		{
			
			
			
			
			
			
		}
		
	}

}