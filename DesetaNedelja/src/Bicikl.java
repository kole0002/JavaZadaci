public class Bicikl extends Vozilo implements Ekonomican {
    private double potrosnjaPerKm; 

    public Bicikl(String id, double maxBrzina, double potrosnjaPerKm) {
        super(id, maxBrzina);
        this.potrosnjaPerKm = potrosnjaPerKm;
    }

    @Override
    public double potrosnjaPoKm() {
        return potrosnjaPerKm;
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        if (maxBrzina <= 0) return Double.POSITIVE_INFINITY;
        return udaljenostKm / maxBrzina;
    }
}
