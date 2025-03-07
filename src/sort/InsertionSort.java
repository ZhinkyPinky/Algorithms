package sort;

public class InsertionSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int n = a.length;

        //The outer loop controls the boundary between the sorted and unsorted partition of the array.
        for (int i = 1; i < n; i++) {
            //The first element of the unsorted partition is selected to be added to the sorted partition.
            T currentElement = a[i];

            // The inner loop iterates over the sorted partition from the end as long as the elements are larger than
            // the new element. While doing this every element we move over is moved one step to the right to make
            // room for the new element.
            int j = i;
            while ((j > 0) && (a[j - 1].compareTo(currentElement) > 0)) {
                a[j] = a[j - 1];
                j--;
            }

            // The new element is added to the sorted partition.
            a[j] = currentElement;
        }
    }
}
