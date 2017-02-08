public class MainClass {

	public static void main(String [] args){
	
		int[] numbers = {22, 1, 7, 2, 39, 13, 16};
		int temp, swap1= 0;
		int swap2 = 0;
		boolean check = false;
	
		for(int i = 0; i < numbers.length-1; i++){
			check = false;
			swap1++;
			for(int j = 0; j < numbers.length-1-i; j++){
				if(numbers[j] > numbers[j+1]){
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					check = true;
					swap2++;
				}
				
			} if(!check)
				break;
			
		}
		
		System.out.println("SORTED: ");
		for(int i : numbers){
			System.out.print(i + " ");
		}
		
		System.out.println("\n\nTotal Number of iterations through first loop: " + swap1 +  "\nTotal number of iterations through second loop: " + swap2);
	}
}

