import java.util.*;

public class MainDostava {
    public static void main(String[] args) {
        double udaljenost = 10.0;
        List<Vozilo> vozila = new ArrayList<>();

        vozila.add(new Bicikl("B1", 15.0, 0.0));  
        vozila.add(new Bicikl("B2", 12.0, 0.0));
        vozila.add(new Motor("M1", 60.0, 0.035));  
        vozila.add(new Motor("M2", 50.0, 0.045));
        vozila.add(new Automobil("A1", 80.0));    
        vozila.add(new Automobil("A2", 60.0));

        System.out.println("Dostava za udaljenost: " + udaljenost + " km\n");

        Map<String, List<Double>> timesByType = new HashMap<>();
        double totalConsumption = 0.0;
        double minTime = Double.POSITIVE_INFINITY;
        Vozilo fastest = null;
        Ekonomican mostEfficient = null;
        double bestConsumptionPerKm = Double.POSITIVE_INFINITY;

        for (Vozilo v : vozila) {
            v.info();
            double hours = v.izracunajVrijemeDostave(udaljenost);
            double minutes = hours * 60.0;

            if (Double.isInfinite(hours)) {
                System.out.println(" -> Vozilo ne može ostvariti dostavu (neispravna brzina).\n");
                continue;
            }

            String type = v.getClass().getSimpleName();
            System.out.printf(" -> Vrijeme dostave: %.2f sati (%.1f minuta)%n", hours, minutes);
            timesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(hours);

            if (hours < minTime) {
                minTime = hours;
                fastest = v;
            }

            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                double pot = e.potrosnjaPoKm() * udaljenost;
                totalConsumption += pot;
                System.out.printf(" -> Potrošnja za %.1f km: %.3f (litri/energ jedinica)%n", udaljenost, pot);

                if (e.potrosnjaPoKm() < bestConsumptionPerKm) {
                    bestConsumptionPerKm = e.potrosnjaPoKm();
                    mostEfficient = e;
                }
            }

            System.out.println();
        }

        System.out.println("Rezime");
        if (fastest != null) {
            System.out.printf("Najbrze vozilo: %s %s (%.1f minuta)%n",
                    fastest.getClass().getSimpleName(), fastest.id, minTime * 60.0);
        }

        for (Map.Entry<String, List<Double>> entry : timesByType.entrySet()) {
            double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
            System.out.printf("Tip %s - prosjecno vrijeme: %.1f minuta%n", entry.getKey(), avg * 60.0);
        }

        System.out.printf("Ukupna potrosnja ekonomicnih vozila za %.1f km: %.3f%n", udaljenost, totalConsumption);
        if (mostEfficient != null) {
            System.out.printf("Najekonomičnije vozilo (po km): %s - %.4f (potrošnja/km)%n",
                    mostEfficient.getClass().getSimpleName(), bestConsumptionPerKm);
        }
    }
}
