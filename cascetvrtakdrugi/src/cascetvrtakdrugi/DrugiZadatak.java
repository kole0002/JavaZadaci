package cascetvrtakdrugi;
import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Unesite poluprecnike prvog pa drugog kruga");
		double r1 = sc.nextDouble();
		double r2 = sc.nextDouble();
		
		System.out.printf("Unesite koordinate centra");
		double cx = sc.nextDouble();
		double cy = sc.nextDouble();
		
		System.out.printf("Unesite broj trkaca");
		int N = sc.nextInt();
		
		int naStazi = 0;
		
		for(int i=0; i<N; i++) {
			
			System.out.printf("Unesite x trkaca");
			double x = sc.nextDouble();
			System.out.printf("Unesite y trkaca");
			double y = sc.nextDouble();
			
			double d = Math.sqrt(Math.pow(x-cx, 2)+Math.pow(y-cy, 2));
			
			if(d>=r1 && d<=r2) {
				naStazi++;
			}
			
		}
	
	
	}

}
