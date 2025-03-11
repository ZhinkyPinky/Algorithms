package sort;

public class RadixSortMSD {
    /**
     * @param array       Elements to sort.
     * @param aux         Auxiliary space.
     * @param R           Alphabet size.
     * @param low         Lower boundary of current sub-array.
     * @param high        Upper boundary of current sub-array.
     * @param d           Current digit.
     * @param bits        Bits per digit.
     * @param digitGetter
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] sort(T[] array, T[] aux, int R, int low, int high, int d, int bits, DigitGetter<T> digitGetter) {
        if (high <= low) return array;

        int[] count = new int[R + 2];

        //Count the frequency of the digits.
        for (int i = low; i <= high; i++) {
            count[digitGetter.getDigit(array[i], d, bits) + 2]++;
        }

        //Calculate at which index each element should be put into aux.
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        //Get the digit from the element in the array, and use it together with
        //count to find the index at which the element should be into aux.
        for (int i = low; i <= high; i++) {
            aux[count[digitGetter.getDigit(array[i], d, bits) + 1]++] = array[i];
        }

        //Copy the elements of aux into the correct position in the array.
        System.arraycopy(aux, 0, array, low, high + 1 - low);

        int newLow, newHigh;
        for (int r = 0; r < R; r++) {
            newLow = low + count[r];
            newHigh = low + count[r + 1] - 1;

            if ((newHigh - newLow) < 20) { //Sort small sub-arrays using insertion sort.
                insertionSort(array, newLow, newHigh);
            } else {
                sort(array, aux, R, newLow, newHigh, d + 1, bits, digitGetter);
            }
        }

        return array;
    }

    private static <T extends Comparable<T>> void insertionSort(T[] a, int low, int high) {
        //The outer loop controls the boundary between the sorted and unsorted partition of the array.
        for (int i = low + 1; i <= high; i++) {
            T currentElement = a[i];

            int j = i;
            while ((j > 0) && (a[j - 1].compareTo(currentElement) > 0)) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = currentElement;
        }
    }
}

