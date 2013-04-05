package klient;

public class Platnosc {

	private int nrKonta;
	private String nazwaBanku;
	private double kwota;
	public int getNrKonta() {
		return nrKonta;
	}
	public void setNrKonta(int nrKonta) {
		this.nrKonta = nrKonta;
	}
	public String getNazwaBanku() {
		return nazwaBanku;
	}
	public void setNazwaBanku(String nazwaBanku) {
		this.nazwaBanku = nazwaBanku;
	}
	public double getKwota() {
		return kwota;
	}
	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public void wyswietl()
	{
		System.out.println(nrKonta+nazwaBanku+kwota);
	}
}
