package sort;

public class BubbleSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int n = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int j = 0; j < (n - 1); j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swapElements(a, j, j + 1);
                    swapped = true;
                }
            }

            n--;
        } while (swapped);
    }

    private void swapElements(T[] a, int l, int r) {
        T temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
