package sedmanedelja;
import java.util.Scanner;
public class Zadatak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String rijeci = sc.nextLine();
		
		rijeci = rijeci.toLowerCase().replaceAll("\s+","");
		
		String obrnuto = new StringBuilder(rijeci).reverse().toString();
		
		if(rijeci.equals(obrnuto)) {
			System.out.println("rijeci \""+ rijeci +"\"je palindrom");
			
		}else {
			System.out.println("nije palindrom");
		}
		
		
	}

}
