package cascetvrtakdrugi;
import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long D = sc.nextLong();
		long HD = sc.nextLong();
		long KA = sc.nextLong();
		int brojPrijetnji = 0;
		
		for(int i=0; i<N; i++) {
			
			long x = sc.nextLong();
			long y = sc.nextLong();
			
			long menhetn = Math.abs(x)+Math.abs(y);
			
			if(menhetn <= D) {
				
				brojPrijetnji++;
				
			}
			
		}
				
		long totalDamage = brojPrijetnji*KA;
		
		System.out.printf("Nas dvorac ukupno ugrozava%f", brojPrijetnji);
		if(totalDamage>HD) {
				System.out.printf("Dvorac je srusen, ukupan dmg je %f", totalDamage);
		}
		else { 
			System.out.printf("Dvorac nije srusen, ukupan dmg je %f", totalDamage);
		}
		
				
		
		
	}

}
