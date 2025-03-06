package sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public void sort(Double[] array, double maxValue, int numberOfBuckets) {
        //Create buckets
        List<Double>[] buckets = new ArrayList[numberOfBuckets];
        for (int k = 0; k < numberOfBuckets; k++) {
            buckets[k] = new ArrayList<>();
        }

        //Put the elements of array into the correct bucket
        for (double d : array) {
            int bucketIndex = (int) ((numberOfBuckets * d) / maxValue);
            buckets[bucketIndex].add(d);
        }

        //Sort the buckets using array secondary sorting algorithm
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i].sort(Double::compareTo);
        }

        //Iterate over the buckets and put the values back into array
        int index = 0;
        for (int i = 0; i < numberOfBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }
    }
}
