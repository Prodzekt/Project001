package model;

public class Uzytkownik implements java.io.Serializable
{


	private String nazwa;
	private int czyLekarz;
	private int id;
	private String haslo;
	private int dane;
	private int lekarz;
	private int saldo;
	private int platnosc;
	
	

	
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




	public int getDane() {
		return dane;
	}




	public void setDane(int i) {
		this.dane = i;
	}




	public int getLekarz() {
		return lekarz;
	}




	public void setLekarz(int lekarz) {
		this.lekarz = lekarz;
	}




	public int getSaldo() {
		return saldo;
	}




	public void setSaldo(int d) {
		this.saldo = d;
	}




	public int getPlatnosc() {
		return platnosc;
	}




	public void setPlatnosc(int platnosc) {
		this.platnosc = platnosc;
	}




	public void wyswietl()
	{
		System.out.println("Uzytkownik: "+this.nazwa+" , Id:"+this.id);
	}




	public String getHaslo() {
		return haslo;
	}




	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
}
