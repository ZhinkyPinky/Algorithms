package sort;

public class RadixSortLSD {
    /**
     * @param array Unsorted array.
     * @param R     Alphabet size.
     */
    public void sort(String[] array, int R) {
        sort(array, R, array[0].length(), array.length);
    }

    /**
     * @param array Unsorted array.
     * @param R     Alphabet size.
     * @param W     String length.
     * @param N     Number of strings.
     */
    public void sort(String[] array, int R, int W, int N) {
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++) {
                count[array[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                aux[count[array[i].charAt(d)]++] = array[i];
            }

            System.arraycopy(aux, 0, array, 0, N);
        }
    }
}
