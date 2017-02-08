import java.util.Random;

public class RandomTest {
	
	public static void main (String [] args) {

		long[] numbers = new long[10];
		
		Random random = new Random();
		
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = random.nextInt(100);
		}
		
		Sorters.selectionSort(numbers);
		
		for(int i = 0; i < numbers.length; i++){
			System.out.print(" " + numbers[i]);
		}
	}
}
