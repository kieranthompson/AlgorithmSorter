public class Sorters {
	static long swap = 0;
	static long swap2 = 0;
	
	public static long[] bubbleSort(long[] numbers) {
		
		for(int i = 0; i < numbers.length-1; i++) {
			long temp;
			swap++;
			for(int j = 0; j < numbers.length-1; j++){
				
				if(numbers[j] > numbers[j+1]){
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swap2++;
				}
			}
		}
		return numbers;
		
	}
	
	public static long[] enhancedBubbleSort(long[] numbers) {
		boolean check = false;
		
		for(int i = 0; i < numbers.length-1; i++) {
			check = false;
			swap++;
			long temp;
			for(int j = 0; j < numbers.length-1-i; j++){
				
				if(numbers[j] > numbers[j+1]){
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swap2++;
					check = true;
				}
			} if(!check)
				break;
			
		}
		return numbers;
		
	}
	
	public static long[] selectionSort (long[] numbers)
	{
	     int i, j, first;
		long temp;  
	     for (i = numbers.length-1; i > 0; i--){
	          first = 0;
	          swap++;
	          for(j = 1; j <= i; j++) {
	               if( numbers[j] > numbers[first])         
	                 first = j;
	               	 swap2++;
	          }
	          temp = numbers[first];
	          numbers[first] = numbers[i];
	          numbers[i] = temp; 
	      }
	     return numbers;
	}
	
	public static long[] insertionSort(long[] numbers) {
		
		for(int i = 1; i < numbers.length; i++){
			swap++;
			long next = numbers[i];
			
			int j = i;
			while(j > 0 && numbers[j-1] > next){
				swap2++;
				numbers[j] = numbers[j-1];
				j--;
			}
			numbers[j] = next;
		}
		return numbers;
	}
	
	public static long[] bubbleSortBackwards(long[] numbers){
		for(int i = 0; i < numbers.length-1; i++) {
			long temp;
			swap++;
			for(int j = 0; j < numbers.length-1; j++){
				
				if(numbers[j] < numbers[j+1]){
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swap2++;
				}
			}
		}
		return numbers;
	}
	
	public static long[] enhancedBubbleSortBackwards(long[] numbers){
		boolean check = false;
		
		for(int i = 0; i < numbers.length-1; i++) {
			check = false;
			long temp;
			swap++;
			for(int j = 0; j < numbers.length-1-i; j++){
				
				if(numbers[j] < numbers[j+1]){
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swap2++;
					check = true;
				}
			} if(!check)
				break;
			
		}
		return numbers;
	}
	
	public static long[] selectionSortBackwards(long[] numbers){
		int i, j, first;
		long temp;  
	     for (i = numbers.length-1; i > 0; i--){
	          first = 0;
	          swap++;
	          for(j = 1; j <= i; j++) {
	               if( numbers[j] < numbers[first])         
	                 first = j;
	               	 swap2++;	
	          }
	          temp = numbers[first];
	          numbers[first] = numbers[i];
	          numbers[i] = temp; 
	      }
	     return numbers;
	}
	
	public static long[] insertionSortBackwards(long[] numbers){
		for(int i = 1; i < numbers.length; i++){
			long next = numbers[i];
			swap++;
			int j = i;
			while(j > 0 && numbers[j-1] < next){
				numbers[j] = numbers[j-1];
				j--;
				swap2++;
			}
			numbers[j] = next;
		}
		return numbers;
	}

}
