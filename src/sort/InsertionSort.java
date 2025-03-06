package sort;

public class InsertionSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int n = a.length;

        //The outer loop controls the boundary between the sorted and unsorted partition of the array.
        for (int i = 1; i < n; i++) {
            //The first element of the unsorted partition is selected to be added to the sorted partition.
            T currentElement = a[i];

            //Inner loop iterates over the sorted partition from end to beginning as long as the elements are larger
            //than the one that's to be added.
            int j = i;
            while ((j > 0) && (a[j - 1].compareTo(currentElement) > 0)) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = currentElement;
        }
    }
}
