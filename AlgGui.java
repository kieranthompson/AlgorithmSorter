import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.Random;
import java.awt.event.*;
import java.awt.*;

public class AlgGui extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel enterPanel, resultPanel;
	private JLabel bubbleLabel, selectionLabel, insertionLabel, enhancedBubbleLabel,
				   bubbleTime, selectionTime, insertionTime, enhancedBubbleTime,
				   bubbleText, selectionText, insertionText, enhancedBubbleText, enterNo;

	private JButton enterButton;
	
	Integer[] choices = {1000, 10000, 100000};
	String[] orderArray = {"Ascending", "Descending", "Random"};
	long[] numbers;
	long[] tempArray;
	private JComboBox<String> sortOrder = new JComboBox<String>(orderArray);
	private JComboBox<Integer> cb = new JComboBox<Integer>(choices);
	Font font;
	Font timeFont;
	
	public AlgGui() {

        StopWatch stopwatch = new StopWatch();


        font = new Font("Helvetica", Font.BOLD, 30);
        timeFont = new Font("Helvetica", Font.BOLD, 20);
        enterPanel = new JPanel();
        enterPanel.setBorder(new LineBorder(Color.BLACK, 1));
        enterPanel.add(enterNo = new JLabel("Get A Random Array"));
        enterNo.setFont(font);
        enterPanel.add(sortOrder);
        enterPanel.add(cb);
        enterPanel.add(enterButton = new JButton("sort"));

        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(3, 1, 20, 20));
        resultPanel.setBorder(new LineBorder(Color.BLACK, 1));

        resultPanel.add(bubbleLabel = new JLabel("BubbleSort"));
        bubbleLabel.setFont(font);
        resultPanel.add(selectionLabel = new JLabel("SelectionSort"));
        selectionLabel.setFont(font);
        resultPanel.add(insertionLabel = new JLabel("InsertionSort"));
        insertionLabel.setFont(font);
        resultPanel.add(enhancedBubbleLabel = new JLabel("Enhanced BubbleSort"));
        enhancedBubbleLabel.setFont(font);

        resultPanel.add(bubbleText = new JLabel("No BubbleSort Output Yet"));
        resultPanel.add(selectionText = new JLabel("No SelectionSort Output Yet"));
        resultPanel.add(insertionText = new JLabel("No InsertionSort Output Yet"));
        resultPanel.add(enhancedBubbleText = new JLabel("No Enhanced BubbleSort OutputYet"));

        resultPanel.add(bubbleTime = new JLabel("No Output Yet"));
        bubbleTime.setFont(timeFont);
        resultPanel.add(selectionTime = new JLabel("No Output Yet"));
        selectionTime.setFont(timeFont);
        resultPanel.add(insertionTime = new JLabel("No Output Yet"));
        insertionTime.setFont(timeFont);
        resultPanel.add(enhancedBubbleTime = new JLabel("No Output Yet"));
        enhancedBubbleTime.setFont(timeFont);

        add(enterPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.SOUTH);



        enterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetArray();
                getArray(numbers);
                for (int i = 0; i < numbers.length; i++) {
                    tempArray[i] = numbers[i];
                }

                if (sortOrder.getSelectedItem().equals("Ascending")) {
                    Sorters.enhancedBubbleSort(numbers);

                } else if (sortOrder.getSelectedItem().equals("Descending")) {
                    System.out.println("DESCENDING IN PROGRESS");
                    Sorters.enhancedBubbleSortBackwards(numbers);

                } else {
                    resortArray();
                    System.out.println("RANDOM IN PROGRESS");
                }

                stopwatch.start();
                resortArray();
                Sorters.bubbleSort(numbers);
                stopwatch.stop();
                bubbleText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
                swapReset();
                bubbleTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
                stopwatch.reset();

                stopwatch.start();
                resortArray();
                Sorters.selectionSort(numbers);
                stopwatch.stop();
                selectionText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
                swapReset();
                selectionTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
                stopwatch.reset();

                stopwatch.start();
                resortArray();
                Sorters.insertionSort(numbers);
                stopwatch.stop();
                insertionText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
                swapReset();
                insertionTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
                stopwatch.reset();

                stopwatch.start();
                resortArray();
                Sorters.enhancedBubbleSort(numbers);
                stopwatch.stop();
                enhancedBubbleText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
                swapReset();
                enhancedBubbleTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
                stopwatch.reset();
            }
        });
    }
			
//			else{
//				System.out.println("DESCENDING IN PROGRESS");
//				getArray(numbers);
//				for(int i = 0; i < numbers.length; i++){
//					tempArray[i] = numbers[i];
//				}
//
//				stopwatch.start();
//				resortArray();
//				Sorters.bubbleSortBackwards(numbers);
//				stopwatch.stop();
//				bubbleText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
//				swapReset();
//				bubbleTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
//				stopwatch.reset();
//
//				stopwatch.start();
//				resortArray();
//				Sorters.selectionSortBackwards(numbers);
//				stopwatch.stop();
//				selectionText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
//				swapReset();
//				selectionTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
//				stopwatch.reset();
//
//				stopwatch.start();
//				resortArray();
//				Sorters.insertionSortBackwards(numbers);
//				stopwatch.stop();
//				insertionText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
//				swapReset();
//				insertionTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
//				stopwatch.reset();
//
//				stopwatch.start();
//				resortArray();
//				Sorters.enhancedBubbleSortBackwards(numbers);
//				stopwatch.stop();
//				enhancedBubbleText.setText("\tFirst Loop Swaps: " + Sorters.swap + ", Second Loop Swaps: " + Sorters.swap2);
//				swapReset();
//				enhancedBubbleTime.setText("nanoseconds: " + String.valueOf(stopwatch.getTimeElapsed()));
//				stopwatch.reset();
//			}
//		}
//	});
//}
	
	public void getArray(long[] numbers){
		Random random = new Random();
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = random.nextInt(100);
		}	
	}
	
	public void swapReset(){
		Sorters.swap = 0;
		Sorters.swap2 = 0;
	}
	
	public void resortArray(){
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = tempArray[i];
		}
	}
	
	public void resetArray(){
		numbers = new long[(int) cb.getSelectedItem()];
		tempArray = new long[(int) cb.getSelectedItem()];
	}
	
	public static void main(String [] args){
		AlgGui frame = new AlgGui();
		
		frame.pack();
		frame.setTitle("Different Alghorithms");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
