import sort.BubbleSort;
import sort.BucketSort;
import sort.InsertionSort;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Integer[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        double[] b = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};

        //testInsertionSort(100000);
        //testBucketSort(Integer.MAX_VALUE);
        testBubbleSort(50000);
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
        validateArraySorted(doubles);
    }

    private static void testInsertionSort(int numberOfElementsToSort) {
        Integer[] testData = fileToIntArray("C:\\Users\\jonat\\Programming\\Java\\Algorithmic_methods_for_search_and_storage\\Radix Sort\\ints.txt", numberOfElementsToSort);

        Long timeBefore = System.currentTimeMillis();
        new InsertionSort<Integer>().sort(testData);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("InsertionSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + testData.length + " elements.");
        validateArraySorted(testData);
    }

    private static void testBubbleSort(int numberOfIntsToSort) {
        Integer[] intTestData = fileToIntArray("src\\testdata\\ints.txt", numberOfIntsToSort);

        Long timeBefore = System.currentTimeMillis();
        new BubbleSort<Integer>().sort(intTestData);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("BubbleSort took " + ((timeAfter - timeBefore) / 1000.0) + " seconds to sort " + intTestData.length + " integers.");
        validateArraySorted(intTestData);
    }

    private static void validateArraySorted(Integer[] a) {
        int previousInt = Integer.MIN_VALUE;
        for (int currentInt : a) {
            if (previousInt > currentInt) {
                System.out.println("Array not sorted.");
                break;
            }
            previousInt = currentInt;
        }
    }

    private static void validateArraySorted(Double[] a) {
        double previous = Double.MIN_VALUE;
        for (double current : a) {
            if (previous > current) {
                System.out.println("Array not sorted. " + previous + " > " + current);
                break;
            }
            previous = current;
        }
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