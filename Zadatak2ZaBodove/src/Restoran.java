import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private List<Zaposleni> zaposleni;

    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.zaposleni = new ArrayList<>();
    }

    public void dodajZaposlenog(Zaposleni z) {
        if (z != null) zaposleni.add(z);
    }

    public boolean ukloniZaposlenogPoId(int id) {
        return zaposleni.removeIf(z -> z.getId() == id);
    }

    public Zaposleni pronadjiPoId(int id) {
        for (Zaposleni z : zaposleni) if (z.getId() == id) return z;
        return null;
    }

    public List<ObracunPlate> generisiMjesecniObracun(int mjesec, int godina) {
        List<ObracunPlate> lista = new ArrayList<>();

        System.out.println("\nObracun plata za " + mjesec + "/" + godina + " - Restoran: " + naziv);
        System.out.printf("%4s | %-12s | %-10s | %6s | %-18s | %10s\n", "ID", "Ime Prezime", "Tip", "Sati", "Prekovremeni/bonus", "Plata(EUR)");

        double ukupno = 0.0;
        for (Zaposleni z : zaposleni) {
            String napomena = "";
            double iznos = 0.0;

            if (z instanceof Konobar) {
                Konobar k = (Konobar) z;
                iznos = k.izracunajMjesecnuPlatu();
                if (k.getPrekovremeniSati() > 0) napomena = "prekovremeni: " + k.getPrekovremeniSati() + "h";
            } else if (z instanceof Menadzer) {
                Menadzer m = (Menadzer) z;
                iznos = m.izracunajMjesecnuPlatu();
                if (m.getBonus() > 0) napomena = "bonus: " + m.getBonus() + " EUR";
            } else if (z instanceof Kuvar) {
                Kuvar ku = (Kuvar) z;
                iznos = ku.izracunajMjesecnuPlatu();
            } else {
                iznos = z.izracunajMjesecnuPlatu();
            }

            ObracunPlate op = new ObracunPlate(mjesec, godina, z, iznos, napomena);
            lista.add(op);
            ukupno += iznos;

            System.out.printf("%4d | %-12s | %-10s | %6.1f | %-18s | %10.2f\n",
                    z.getId(), (z.getIme() + " " + z.getPrezime()), z.getTip(), z.getUkupanBrojSati(), napomena, iznos);
        }

        System.out.printf("Ukupan trosak plata: %.2f EUR\n", ukupno);

        return lista;
    }

    public double ukupniTrosakZaMjesec(int mjesec, int godina) {
        double ukupno = 0.0;
        for (ObracunPlate o : generisiMjesecniObracun(mjesec, godina)) {
            ukupno += o.getIznos();
        }
        return ukupno;
    }
}
