import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EquaçãoDoSegundoGrau {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Read the coeficients separeted by space");
		String[] numbersString = sc.nextLine().split(" ");
		List<Double> list = new ArrayList<>();
		
		for(String number: numbersString ) {
			list.add(Double.parseDouble(number));
			
		}
		System.out.println(realizar(list));
		
		
		
		sc.close();
		
	}
	
	//-b +- raiz de b*b - 4ac/2a
	
	public static String realizar(List<Double> list) {
		Double a = list.get(0);
		Double b = list.get(1);
		Double c = list.get(2);
		List<Double> results = new ArrayList<>();
		
		Double x1 = (-b + Math.sqrt(b*b-4*a*c))/2*a ;
		Double x2 = (-b - Math.sqrt(b*b-4*a*c))/2*a;
		results.addAll(Arrays.asList(x1,x2));
		
		return results.toString(); 
	}
}
