package klient;

public class Uzytkownik 
{
	public static void main(String[] args) {
		
	}
	private int czyLekarz;
	private int id;
	private String nazwa;
	private DaneOsobowe dane;
	private Lekarz lekarz;
	private Saldo saldo;
	private Platnosc platnosc;
	
	

	
	public int getCzyLekarz() {
		return czyLekarz;
	}




	public void setCzyLekarz(int czyLekarz) {
		this.czyLekarz = czyLekarz;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNazwa() {
		return nazwa;
	}




	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}




	public DaneOsobowe getDane() {
		return dane;
	}




	public void setDane(DaneOsobowe dane) {
		this.dane = dane;
	}




	public Lekarz getLekarz() {
		return lekarz;
	}




	public void setLekarz(Lekarz lekarz) {
		this.lekarz = lekarz;
	}




	public Saldo getSaldo() {
		return saldo;
	}




	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}




	public Platnosc getPlatnosc() {
		return platnosc;
	}




	public void setPlatnosc(Platnosc platnosc) {
		this.platnosc = platnosc;
	}




	public void wyswietl()
	{
		System.out.println("Uzytkownik: "+this.nazwa+" , Id:"+this.id);
	}
}
