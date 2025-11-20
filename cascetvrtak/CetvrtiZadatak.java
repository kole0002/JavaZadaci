package cascetvrtak;
import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		double x1 = sc.nextDouble(), x2 = sc.nextDouble(), y1 = sc.nextDouble(), y2 = sc.nextDouble();
		
		double a = x1-x2;
		double b = y2-y1;
		
		double P = a*b;
		double O = 2*a+2*b;
				
		System.out.printf("Povrsina je:%.2f O=%.2f%n",P,O);
		
	}

}
