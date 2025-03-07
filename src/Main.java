import sort.*;

import java.io.*;
import java.util.ArrayList;

import static sort.Validator.arraySorted;

public class Main {
    public static void main(String[] args) {

        Integer[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        double[] b = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};

        String intTestDataPath = "src\\testdata\\ints.txt";

        testMergeSort(intTestDataPath, Integer.MAX_VALUE);
        //testInsertionSort(intTestDataPath, 100000);
        //testBucketSort(Integer.MAX_VALUE);
        //testBubbleSort(100000);
    }

    private static void testBucketSort(int numberOfElementsToSort) {
        Integer[] integers = fileToIntArray("C:\\Users\\jonat\\Programming\\Java\\Algorithmic_methods_for_search_and_storage\\Radix Sort\\ints.txt", numberOfElementsToSort);

        Double[] doubles = new Double[integers.length];
        for (int i = 0; i < integers.length; i++) {
            doubles[i] = integers[i] / 100.0;
        }

        double largestValue = Double.MIN_VALUE;
        double smallestValue = Double.MAX_VALUE;
        for (double d : doubles) {
            if (d > largestValue) largestValue = d;
            if (d < largestValue) smallestValue = d;
        }

        int numberOfBuckets = (int) ((largestValue - smallestValue) + 1);

        Long timeBefore = System.currentTimeMillis();
        new BucketSort().sort(doubles, largestValue + 1, numberOfBuckets);
        Long timeAfter = System.currentTimeMillis();

        System.out.println("BucketSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + integers.length + " elements with " + numberOfBuckets + " buckets.");
        arraySorted(doubles);
    }

    private static void testMergeSort(String filePath, int numberOfElementsToSort) {
        Integer[] testData = fileToIntArray(filePath, numberOfElementsToSort);

        //Arrays.stream(doubleTestData).forEach(d -> System.out.println("Before: " + d));

        Long timeBefore = System.currentTimeMillis();
        new MergeSort<Integer>().sort(testData);
        Long timeAfter = System.currentTimeMillis();

        //Arrays.stream(doubleTestData).forEach(d -> System.out.println("After: " + d));

        System.out.println("MergeSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + testData.length + " elements.");
        arraySorted(testData);
    }

    private static void testInsertionSort(String filePath, int numberOfElementsToSort) {
        Integer[] testData = fileToIntArray(filePath, numberOfElementsToSort);
        Double[] doubleTestData = new Double[testData.length];
        for (int i = 0; i < testData.length; i++) {
            doubleTestData[i] = testData[i] / 100.0;
        }

        //Arrays.stream(doubleTestData).forEach(d -> System.out.println("Before: " + d));

        Long timeBefore = System.currentTimeMillis();
        new InsertionSort<Double>().sort(doubleTestData);
        Long timeAfter = System.currentTimeMillis();

        //Arrays.stream(doubleTestData).forEach(d -> System.out.println("After: " + d));

        System.out.println("InsertionSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + testData.length + " elements.");
        arraySorted(doubleTestData);
    }

    private static void testBubbleSort(int numberOfIntsToSort) {
        Integer[] testData = fileToIntArray("src\\testdata\\ints.txt", numberOfIntsToSort);

        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

        Long timeBefore = System.currentTimeMillis();
        bubbleSort.sort(testData);
        Long timeAfter = System.currentTimeMillis();

        System.out.println("BubbleSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + testData.length + " integers.");
        arraySorted(testData);
    }


    private static Integer[] fileToIntArray(String filePath, int numberOfIntsToRead) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((((line = bufferedReader.readLine())) != null) && (arrayList.size() < numberOfIntsToRead)) {
                arrayList.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList.toArray(new Integer[0]);
    }
}