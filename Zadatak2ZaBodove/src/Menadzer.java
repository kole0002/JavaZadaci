public class Menadzer extends Zaposleni {
    private static double osnovica = 1300.0;
    private double bonus;

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.bonus = bonus;
    }

    public double getBonus() { 
    	return bonus; 
    	}
    public void setBonus(double bonus) { 
    	this.bonus = bonus; 
    	}

    @Override
    public String getTip() { 
    	return "Menadzer"; 
    	}

    @Override
    public double izracunajMjesecnuPlatu() {
        return osnovica + 4.0 * ukupanBrojSati * plataPoSatu + bonus;
    }
}
