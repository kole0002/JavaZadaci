package cascetvrtak;
import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double P = sc.nextDouble();
		
		double r = Math.sqrt(P/Math.PI);
		
		double O = 2*r*Math.PI;
		
		System.out.printf("%.2f%n",O);
		
		
		
	}

}
