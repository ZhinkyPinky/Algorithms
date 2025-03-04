import Sorting.BubbleSort;
import Sorting.CountSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};

        System.out.println("Unsorted: " +  Arrays.toString(a));

        new BubbleSort().sort(a);

        System.out.println("Sorted: "+ Arrays.toString(a));
    }
}