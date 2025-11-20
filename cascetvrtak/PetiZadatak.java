package cascetvrtak;
import java.util.Scanner;

public class PetiZadatak {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double xH = sc.nextDouble(), xK = sc.nextDouble(), yH = sc.nextDouble(), yK = sc.nextDouble();

		double xB = xK+2;
		double yB = yK-3;
		
		double HB = Math.sqrt(Math.pow((yB-yH), 2)+Math.pow((xB-xH), 2));
		System.out.printf("Udaljenost od hrasta do blaga je %.2f", HB);
		
		double UDHK = Math.sqrt(Math.pow((yK-yH), 2)+Math.pow((xK-xH), 2));
		double UDKB = Math.sqrt(Math.pow((yB-yK), 2)+Math.pow((xB-xK), 2));
		
		System.out.printf("Udaljenost od hrasta do kuce je %.2f", UDHK);
		System.out.printf("Udaljenost od kuce do blaga je %.2f",UDKB);
		
		double UDHKB = UDHK+UDKB;
		System.out.printf("Udaljenost od hrasta do kuce od blaga je %.2f",UDHKB);
		
		
		
	}
	
	


}
