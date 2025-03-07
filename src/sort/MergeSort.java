package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
    public void sort(T[] array) {
        divide(array, 0, array.length - 1);
    }

    public void divide(T[] array, int left, int right) {
        if (left < right) { //Can we divide further?
            //Find middle
            int middle = left + (right - left) / 2;

            //Divide left half
            divide(array, left, middle);
            //Divide right half
            divide(array, middle + 1, right);

            //Merge the halves
            merge(array, left, middle, right);
        }
    }

    private void merge(T[] array, int left, int middle, int right) {
        //Create and copy data to left partition
        T[] leftPartition = (T[]) new Comparable[middle - left + 1];
        //for (int i = 0; i < leftPartition.length; i++) leftPartition[i] = array[left + i];
        System.arraycopy(array, left, leftPartition, 0, leftPartition.length);

        //Create and copy data to right partition
        T[] rightPartition = (T[]) new Comparable[right - middle];
        //for (int i = 0; i < rightPartition.length; i++) rightPartition[i] = array[middle + 1 + i];
        System.arraycopy(array, middle + 1, rightPartition, 0, rightPartition.length);

        //Insert data from the partitions into the array in the correct order
        int i = 0, j = 0, k = left;
        while (i < leftPartition.length && j < rightPartition.length) {
            if (leftPartition[i].compareTo(rightPartition[j]) <= 0) {
                array[k++] = leftPartition[i++];
            } else {
                array[k++] = rightPartition[j++];
            }
        }

        //Add remaining elements from the left partition to the array.
        while (i < leftPartition.length) array[k++] = leftPartition[i++];

        //Add remaining elements from the right partition to the array.
        while (j < rightPartition.length) array[k++] = rightPartition[j++];
    }
}
