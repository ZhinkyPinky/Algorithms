package Sorting;

public class BubbleSort{
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < (n - 1); i++) {
            boolean swapped = false;
            for (int j = 0; j < (n - i - 1); j++) {
                if (a[j] > a[j + 1]) {
                    swapElements(a, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    private void swapElements(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
