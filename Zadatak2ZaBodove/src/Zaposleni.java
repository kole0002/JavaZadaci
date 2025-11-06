public class Zaposleni {
    protected int id;
    protected String ime;
    protected String prezime;
    protected double plataPoSatu;
    protected double ukupanBrojSati;

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public int getId() { 
    	return id; 
    	}
    public String getIme() { 
    	return ime; 
    	}
    public String getPrezime() { 
    	return prezime; 
    	}
    public double getPlataPoSatu() { 
    	return plataPoSatu; 
    	}
    public double getUkupanBrojSati() { 
    	return ukupanBrojSati; 
    	}
    public void setUkupanBrojSati(double s) { 
    	this.ukupanBrojSati = s; 
    	}

    public String getTip() {
		return null;
	}
    public double izracunajMjesecnuPlatu() {
		return 0;
	}
}
