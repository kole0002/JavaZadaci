public class Konobar extends Zaposleni {
    private double prekovremeniSati;

    public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSati = prekovremeniSati;
    }

    public double getPrekovremeniSati() { 
    	return prekovremeniSati; 
    	}
    public void setPrekovremeniSati(double s) { 
    	this.prekovremeniSati = s; 
    	}

    @Override
    public String getTip() { return "Konobar"; }

    @Override
    public double izracunajMjesecnuPlatu() {
        double regularnoNedeljno = ukupanBrojSati * plataPoSatu;
        double prekovremenoNedeljno = prekovremeniSati * (plataPoSatu * 1.2);
        double nedeljnoUkupno = regularnoNedeljno + prekovremenoNedeljno;
        return nedeljnoUkupno * 4;
    }
}
