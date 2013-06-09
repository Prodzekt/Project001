package wspolne;

public class Harmonogram {
	private int id;
	private String nazwa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void wyswietl()
	{
		System.out.println(id);
		//wyswietlanie mysql elementu?
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
