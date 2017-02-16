import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kieran on 16/02/2017.
 */
public class tester {

    public static void main(String [] args){

        long[] numbers = new long[0];
        long[] temp = new long[0];
        int size;
        Scanner keyIn = new Scanner(System.in);

        do{
            System.out.println("\nChoose One Of The Following Array Sizes: ");
            System.out.println("1.\t 1,000");
            System.out.println("2.\t 10,000");
            System.out.println("3.\t 100,000");
            System.out.println("4.\t Quit.");
            size = keyIn.nextInt();


            switch(size) {
                case 1:
                    numbers = new long[1000];
                    temp = new long[1000];
                    System.out.println("\n1,000 Selected");
                    break;
                case 2:
                    numbers = new long[10000];
                    temp = new long[10000];
                    System.out.println("\n10,000 Selected");
                    break;
                case 3:
                    numbers = new long[100000];
                    temp = new long[100000];
                    System.out.println("\n100,000 Selected");
                    break;
                case 4:
                    System.out.println("Closing.....");
                    System.exit(0);
                default:
                    System.out.println("\nChoose 1, 2, or 3");
                    break;
            }


            Random random = new Random();
            for(int i = 0; i < numbers.length; i++){
                numbers[i] = random.nextInt(100);
            }

            setArray(numbers, temp);
            StopWatch stopwatch = new StopWatch();

            System.out.println("\nChoose a Sorting Arrangement");
            System.out.println("1.\t Ascending");
            System.out.println("2.\t Descending");
            System.out.println("3.\t Random");
            int choice = keyIn.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAscending Selected, Please Wait...");
                    Sorters.enhancedBubbleSort(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.bubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSort(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.enhancedBubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nEnhancedBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSort(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.selectionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nSelectionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSort(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.insertionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nInsertionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);
                    break;

                case 2:
                    Sorters.enhancedBubbleSortBackwards(numbers);
                    resetSwaps();
                    System.out.println("Descending Selected, Please Wait...");
                    stopwatch.start();
                    Sorters.bubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSortBackwards(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.enhancedBubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nEnhancedBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSortBackwards(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.selectionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nSelectionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    Sorters.enhancedBubbleSortBackwards(numbers);
                    resetSwaps();
                    stopwatch.start();
                    Sorters.insertionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nInsertionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);
                    break;

                case 3:
                    resetArray(numbers, temp);
                    System.out.println("Descending Selected, Please Wait...");
                    stopwatch.start();
                    Sorters.bubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    stopwatch.start();
                    Sorters.enhancedBubbleSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nEnhancedBubbleSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    stopwatch.start();
                    Sorters.selectionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nSelectionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);

                    stopwatch.start();
                    Sorters.insertionSort(numbers);
                    stopwatch.stop();
                    System.out.println("\nInsertionSort Time: " + stopwatch.getTimeElapsed() + " n/s\nNumbers of Comparrisons: " + Sorters.swap + "\nNumber of Swaps: " + Sorters.swap2);
                    stopwatch.reset();
                    resetSwaps();
                    resetArray(numbers, temp);
                    break;

                default:
                    System.out.println("\nChoose between 1, 2 or 3");
            }
        }while(size != 4);
    }

    public static long[] resetArray(long[] numbers, long[] temp){
        for(int i =0; i < numbers.length; i++) {
            numbers[i] = temp[i];
        }return numbers;
    }

    public static long[] setArray(long[] numbers, long[] temp){
        for(int i = 0; i < numbers.length; i++){
            temp[i] = numbers[i];
        }return numbers;
    }

    public static void resetSwaps(){
        Sorters.swap = 0;
        Sorters.swap2 = 0;
    }
}
