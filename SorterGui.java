import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Random;

/**
 * Created by Kieran on 13/02/2017.
 */
public class SorterGui extends JFrame {
    private JPanel enterPanel, resultPanel;
    private JLabel ascBubbleLabel, ascEnhancedLabel, ascInsertionLabel, ascSelectionLabel, descBubbleLabel, descEnhancedLabel,
            descInsertionLabel, descSelectionLabel, randBubbleLabel, randEnhancedLabel, randInsertionLabel, randSelectionLabel;

    private JButton getArrayButton, ascButton, descButton, randButton;
    private Integer[]arraySizes = {1000, 10000, 100000};
    private JComboBox<Integer> options = new JComboBox<Integer>(arraySizes);

    private long[] numbers;
    private long[] temp;
    private long bubbleTime, enhancedTime, selectionTime, insertionTime, bubblecomparrison, bubbleSwap, enhancedComparrison, enhancedSwap,
                 selectionComparrison, selectionSwap, insertionComparrison, insertionSwap;


    Font font, timeFont;

    public SorterGui(){

        font = new Font("Helvetica", Font.BOLD, 15);
        timeFont = new Font("Helvetica", Font.BOLD, 20);
        StopWatch stopwatch = new StopWatch();
        enterPanel = new JPanel();
        enterPanel.add(getArrayButton = new JButton("Get Array"));
        enterPanel.add(options);

        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(3, 5, 40, 20));
        resultPanel.add(ascButton = new JButton("ASCENDING"));
        resultPanel.add(ascBubbleLabel = new JLabel("No Output Yet"));
        ascBubbleLabel.setFont(font);
        resultPanel.add(ascEnhancedLabel = new JLabel("No Output Yet"));
        ascEnhancedLabel.setFont(font);
        resultPanel.add(ascSelectionLabel = new JLabel("No Output Yet"));
        ascSelectionLabel.setFont(font);
        resultPanel.add(ascInsertionLabel = new JLabel("No Output Yet"));
        ascInsertionLabel.setFont(font);

        resultPanel.add(descButton = new JButton("DESCENDING"));
        resultPanel.add(descBubbleLabel = new JLabel("No Output Yet"));
        descBubbleLabel.setFont(font);
        resultPanel.add(descEnhancedLabel = new JLabel("No Output Yet"));
        descEnhancedLabel.setFont(font);
        resultPanel.add(descSelectionLabel = new JLabel("No Output Yet"));
        descSelectionLabel.setFont(font);
        resultPanel.add(descInsertionLabel = new JLabel("No Output Yet"));
        descInsertionLabel.setFont(font);

        resultPanel.add(randButton = new JButton("RANDOM"));
        resultPanel.add(randBubbleLabel = new JLabel("No Output Yet"));
        randBubbleLabel.setFont(font);
        resultPanel.add(randEnhancedLabel = new JLabel("No Output Yet"));
        randEnhancedLabel.setFont(font);
        resultPanel.add(randSelectionLabel = new JLabel("No Output Yet"));
        randSelectionLabel.setFont(font);
        resultPanel.add(randInsertionLabel = new JLabel("No Output Yet"));
        randInsertionLabel.setFont(font);

        add(resultPanel, BorderLayout.SOUTH);
        add(enterPanel, BorderLayout.NORTH);

        getArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numbers = new long[(int) options.getSelectedItem()];
                temp = new long[(int) options.getSelectedItem()];
                setArray();
            }
        });

        ascButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorters.enhancedBubbleSort(numbers);
                resetTime();
                sort();
                ascBubbleLabel.setText("Time(ns): " + bubbleTime + " swaps: " + bubblecomparrison + "  " + bubbleSwap);
                ascEnhancedLabel.setText("Time(ns): " + enhancedTime + " swaps: " + enhancedComparrison + "  " + enhancedSwap);
                ascSelectionLabel.setText("Time(ns): " + selectionTime + " swaps: " + selectionComparrison + "  " + selectionSwap);
                ascInsertionLabel.setText("Time(ns): " + insertionTime + " swaps: " + insertionComparrison + "  " + insertionSwap);
            }
        });

        descButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorters.enhancedBubbleSortBackwards(numbers);
                resetTime();
                sort();
                descBubbleLabel.setText("Time(ns): " + bubbleTime + " swaps: " + bubblecomparrison + "  " + bubbleSwap);
                descEnhancedLabel.setText("Time(ns): " + enhancedTime + " swaps: " + enhancedComparrison + "  " + enhancedSwap);
                descSelectionLabel.setText("Time(ns): " + selectionTime + " swaps: " + selectionComparrison + "  " + selectionSwap);
                descInsertionLabel.setText("Time(ns): " + insertionTime + " swaps: " + insertionComparrison + "  " + insertionSwap);
            }
        });

        randButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetArray();
                resetTime();
                sort();
                randBubbleLabel.setText("Time(ns): " + bubbleTime + " swaps: " + bubblecomparrison + "  " + bubbleSwap);
                randEnhancedLabel.setText("Time(ns): " + enhancedTime + " swaps: " + enhancedComparrison + "  " + enhancedSwap);
                randSelectionLabel.setText("Time(ns): " + selectionTime + " swaps: " + selectionComparrison + "  " + selectionSwap);
                randInsertionLabel.setText("Time(ns): " + insertionTime + " swaps: " + insertionComparrison + "  " + insertionSwap);
            }
        });
    }

    public void sort(){
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Sorters.bubbleSort(numbers);
        stopwatch.stop();
        bubblecomparrison = Sorters.swap;
        bubbleSwap = Sorters.swap2;
        bubbleTime = stopwatch.getTimeElapsed();
        stopwatch.reset();
        swapReset();
        resetArray();

        stopwatch.start();
        Sorters.enhancedBubbleSort(numbers);
        stopwatch.stop();
        enhancedComparrison = Sorters.swap;
        enhancedSwap = Sorters.swap2;
        enhancedTime = stopwatch.getTimeElapsed();
        stopwatch.reset();
        swapReset();
        resetArray();

        stopwatch.start();
        Sorters.selectionSort(numbers);
        stopwatch.stop();
        selectionComparrison = Sorters.swap;
        selectionSwap = Sorters.swap2;
        selectionTime = stopwatch.getTimeElapsed();
        stopwatch.reset();
        swapReset();
        resetArray();

        stopwatch.start();
        Sorters.insertionSort(numbers);
        stopwatch.stop();
        insertionComparrison = Sorters.swap;
        insertionSwap = Sorters.swap2;
        insertionTime = stopwatch.getTimeElapsed();
        stopwatch.reset();
        swapReset();
        resetArray();
    }

    public void setArray(){
        Random random = new Random();
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
            temp[i] = numbers[i];
        }
    }

    public void swapReset(){
        Sorters.swap = 0;
        Sorters.swap2 = 0;
    }

    public void resetArray(){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = temp[i];
        }
    }

    public void resetTime(){
        bubbleTime = 0;
        enhancedTime = 0;
        selectionTime = 0;
        insertionTime = 0;
    }

    public static void main(String [] args){

        SorterGui frame = new SorterGui();
        frame.setSize(1500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
