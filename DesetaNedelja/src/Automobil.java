public class Automobil extends Vozilo {
    public Automobil(String id, double maxBrzina) {
        super(id, maxBrzina);
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        if (maxBrzina <= 0) return Double.POSITIVE_INFINITY;
        return udaljenostKm / maxBrzina;
    }
}
