public class Kuvar extends Zaposleni {
    private static double dodatni_fiksni = 1500.0;

    public Kuvar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    @Override
    public String getTip() { 
    	return "Kuvar"; 
    	}

    @Override
    public double izracunajMjesecnuPlatu() {
        return dodatni_fiksni + 4.0 * ukupanBrojSati * plataPoSatu;
    }
}
