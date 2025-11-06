public class ObracunPlate {
    private int mjesec;
    private int godina;
    private Zaposleni zaposleni;
    private double iznos;
    private String napomena;

    public ObracunPlate(int mjesec, int godina, Zaposleni zaposleni, double iznos, String napomena) {
        this.mjesec = mjesec;
        this.godina = godina;
        this.zaposleni = zaposleni;
        this.iznos = iznos;
        this.napomena = napomena;
    }

    public int getMjesec() {
    	return mjesec;
    	}
    public int getGodina() {
    	return godina; 
    	}
    public Zaposleni getZaposleni() { 
    	return zaposleni; 
    	}
    public double getIznos() { 
    	return iznos; 
    	}
    public String getNapomena() { 
    	return napomena; 
    	}

    @Override
    public String toString() {
        return zaposleni.getId() + " - " + zaposleni.getIme() + " " + zaposleni.getPrezime() + ": " + iznos + " EUR" + (napomena != null && !napomena.isEmpty() ? " (" + napomena + ")" : "");
    }
}
