public abstract class Vozilo {
    protected String id;
    protected double maxBrzina;

    public Vozilo(String id, double maxBrzina) {
        if (id == null) id = "";
        this.id = id;
        this.maxBrzina = maxBrzina;
    }

    public void info() {
        System.out.printf("Vozilo ID: %s, tip: %s, maxBrzina: %.2f km/h%n", id, this.getClass().getSimpleName(), maxBrzina);
    }

public abstract double izracunajVrijemeDostave(double udaljenostKm);
}
