package model;

import wspolne.Harmonogram;

public class Lekarz implements java.io.Serializable{
	
	private String specjalizacja;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecjalizacja() {
		return specjalizacja;
	}

	public void setSpecjalizacja(String specjalizacja) {
		this.specjalizacja = specjalizacja;
	}
	
}
