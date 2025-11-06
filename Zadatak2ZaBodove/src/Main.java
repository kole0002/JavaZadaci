public class Main {
    public static void main(String[] args) {
        Restoran r = new Restoran("Masa Restoran", "Ulica Zivojina Perica, Podgorica", "020223700");

        Konobar k1 = new Konobar(1, "Marko", "Jovanovic", 6, 40, 5);
        Kuvar ku1 = new Kuvar(2, "Ana", "Jankovic", 8, 38);
        Menadzer m1 = new Menadzer(3, "Maja", "Andjelic", 10, 35, 200);
        Konobar k2 = new Konobar(4, "Ivan", "Novovic", 5.5, 30, 0);
        Kuvar ku2 = new Kuvar(5, "Petar", "Burzanovic", 7.5, 42);

        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(ku1);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(ku2);

        m1.setBonus(250.0);
        k2.setPrekovremeniSati(2.0);

        r.generisiMjesecniObracun(11, 2025);

        double ukupno = r.ukupniTrosakZaMjesec(11, 2025);
        System.out.printf("\nUkupan trosak koji metoda vraca: %.2f EUR\n", ukupno);
    }
}
