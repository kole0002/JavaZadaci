import java.util.Scanner;

public class CijenaProizvoda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price = 0.0;

        while (true) {
            System.out.print("Unesite cijenu proizvoda: ");
            String line = sc.nextLine();

            try {
                double value = Double.parseDouble(line);
                if (value <= 0) {
                    throw new IllegalArgumentException("Cijena mora biti pozitivan broj.");
                }
                price = value;
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Neispravan unos: unesite broj (npr. 12.50). Pokušajte ponovo.");
            } catch (IllegalArgumentException iae) {
                System.out.println("Neispravan unos: " + iae.getMessage() + " Pokušajte ponovo.");
            }
        }

        System.out.printf("Cijena uspješno unesena: %.2f%n", price);
        sc.close();
    }
}
