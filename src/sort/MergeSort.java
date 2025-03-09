package sort;

public class MergeSort<T extends Comparable<T>> {
    public void sort(T[] array) {
        divide(array, 0, array.length - 1);
    }

    public void divide(T[] array, int left, int right) {
        if (left < right) { //Can we divide further?
            int middle = left + (right - left) / 2;

            //Divide into smaller partitions
            divide(array, left, middle);
            divide(array, middle + 1, right);

            //Merge the halves
            merge(array, left, middle, right);
        }
    }

    private void merge(T[] array, int left, int middle, int right) {
        //Create left partition and copy data to it
        int leftSize = middle - left + 1;
        T[] leftPartition = (T[]) new Comparable[leftSize];
        System.arraycopy(array, left, leftPartition, 0, leftSize);

        //Create right partition and copy data to it
        int rightSize = right - middle;
        T[] rightPartition = (T[]) new Comparable[rightSize];
        System.arraycopy(array, middle + 1, rightPartition, 0, rightSize);

        //Insert data from the partitions into the array in the correct order
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftPartition[i].compareTo(rightPartition[j]) <= 0) {
                array[k++] = leftPartition[i++];
            } else {
                array[k++] = rightPartition[j++];
            }
        }

        //Add remaining elements from the partitions to the array.
        while (i < leftSize) array[k++] = leftPartition[i++];
        while (j < rightSize) array[k++] = rightPartition[j++];
    }
}
