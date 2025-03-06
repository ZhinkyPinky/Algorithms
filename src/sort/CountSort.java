package sort;

public class CountSort {

    /**
     * Finds the alphabet size and calls the actual count sort algorithm.
     *
     * @param a Unsorted array.
     */
    public static void sort(int[] a) {
        int R = 0;
        for (int i : a) {
            if (i > R) {
                R = i;
            }
        }

        sort(a, R + 1);
    }

    /**
     * Count sort algorithm.
     *
     * @param a Unsorted array.
     * @param R Alphabet size.
     */
    public static void sort(int[] a, int R) {
        int N = a.length;
        int[] count = new int[R + 1];
        int[] aux = new int[N];

        //Count the frequency of the elements
        for (int i = 0; i < N; i++) {
            count[a[i] + 1]++;
        }

        //Calculate at which index each element should be put into aux
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        //Use count to place the values in a on the correct index in aux.
        for (int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
        }

        //Copy the aux array back into the original array
        System.arraycopy(aux, 0, a, 0, N);
    }
}
