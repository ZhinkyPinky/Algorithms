package sort;

public class BubbleSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int n = a.length;
        int newN;
        do {
            newN = 0;
            for (int i = 1; i < n; i++) {
                if (a[i - 1].compareTo(a[i]) > 0) {
                    swapElements(a, i - 1, i);
                    newN = i;
                }
            }

            n = newN;
        } while (newN > 1);
    }

    private void swapElements(T[] a, int l, int r) {
        T temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
