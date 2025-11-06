import java.util.ArrayList;
import java.util.List;

public class Smjena {
    public enum Tip { jutarnja, popodnevna, nocna }

    private String datum;
    private String pocetak;
    private String kraj;
    private Tip tip;
    private List<Zaposleni> zaposleni;

    public Smjena(String datum, String pocetak, String kraj, Tip tip) {
        this.datum = datum;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tip = tip;
        this.zaposleni = new ArrayList<>();
    }

    public void dodajZaposlenog(Zaposleni z) {
        if (z != null) zaposleni.add(z);
    }

    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }

        public double trajanjeSati() {
        String[] p = pocetak.split(":");
        String[] k = kraj.split(":");
        int pocetakMin = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        int krajMin = Integer.parseInt(k[0]) * 60 + Integer.parseInt(k[1]);
        if (krajMin < pocetakMin) krajMin += 24 * 60; 
        return (krajMin - pocetakMin) / 60.0;
    }

    public String getDatum() { 
    	return datum; 
    	}
    public String getPocetak() { 
    	return pocetak; 
    	}
    public String getKraj() { 
    	return kraj; 
    	}
    public Tip getTip() { 
    	return tip; 
    	}
}
