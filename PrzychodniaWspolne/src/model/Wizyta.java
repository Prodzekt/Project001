package model;

public class Wizyta implements java.io.Serializable{

	private String pacjent;
	private String lekarz;
	private int rok;
	private int miesiac;
	private int dzien;
	private int godzina;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPacjent() {
		return pacjent;
	}
	public void setPacjent(String pacjent) {
		this.pacjent = pacjent;
	}
	public String getLekarz() {
		return lekarz;
	}
	public void setLekarz(String lekarz) {
		this.lekarz = lekarz;
	}
	public int getRok() {
		return rok;
	}
	public void setRok(int rok) {
		this.rok = rok;
	}
	public int getMiesiac() {
		return miesiac;
	}
	public void setMiesiac(int miesiac) {
		this.miesiac = miesiac;
	}
	public int getDzien() {
		return dzien;
	}
	public void setDzien(int dzien) {
		this.dzien = dzien;
	}
	public int getGodzina() {
		return godzina;
	}
	public void setGodzina(int godzina) {
		this.godzina = godzina;
	}


}
