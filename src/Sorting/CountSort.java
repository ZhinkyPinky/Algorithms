package Sorting;

public class CountSort{
    public void sort(int[] a, int R) {
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

        //
        for (int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
        }

        //Copy the aux array back into the original array
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }
    }
}
