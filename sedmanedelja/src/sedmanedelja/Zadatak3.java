package sedmanedelja;
import java.util.Scanner;
public class Zadatak3 {

	public static void main(String[] args) {
		
			
		String s = "helloo";
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                System.out.println(s.charAt(i) + "" + s.charAt(i + 1));
		
	}

}
