package a;

public class A {

	public static void main(String[] args) {
String plate = "";
		
		while(plate.length() < 7) {
			
			
			String[] leters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","U","V","X","W","Y","Z"};
			String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
			Integer selectedLeter = Integer.parseInt(String.format("%.0f", Math.floor(Math.random() * (23 - 0) + 0))); 
			Integer selectedNumber =  Integer.parseInt(String.format("%.0f", Math.floor(Math.random() * (9 - 0) + 0)));

			
			
			if(plate.length() < 3) {
				plate = leters[selectedLeter];
			}
			
			if(plate.length() > 3) {
				plate = numbers[selectedNumber];
			}
			
		}

		
		System.out.println(plate);
	}

}
