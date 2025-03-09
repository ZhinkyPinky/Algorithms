package sort;

public class RadixSortMSD {
    public static <T> T[] sort(T[] array, T[] aux, int R, int low, int high, int d, int bits, DigitGetter<T> digitGetter) {
        if (high <= low) return array;

        int[] count = new int[R + 2];

        for (int i = low; i <= high; i++) {
            count[digitGetter.getDigit(array[i], d, bits) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        for (int i = low; i <= high; i++) {
            aux[count[digitGetter.getDigit(array[i], d, bits) + 1]++] = array[i];
        }

        for (int i = low; i <= high; i++) {
            array[i] = aux[i - low];
        }

        for (int r = 0; r < R; r++) {
            sort(array, aux, R, low + count[r], low + count[r + 1] - 1, d + 1, bits, digitGetter);
        }

        return array;
    }
}

