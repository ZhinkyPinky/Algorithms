package sort;

public class Validator {
    public static void arraySorted(Integer[] a) {
        int previous = Integer.MIN_VALUE;
        for (int current : a) {
            if (previous > current) {
                System.out.println("Array not sorted. " + previous + " < " + current);
                break;
            }
            previous = current;
        }
    }

    public static void arraySorted(Double[] a) {
        double previous = Double.MIN_VALUE;
        for (double current : a) {
            if (previous > current) {
                System.out.println("Array not sorted. " + previous + " > " + current);
                break;
            }
            previous = current;
        }
    }

    public static void arraySorted(String[] a) {
        String previous = "";
        for (String current : a) {
            if (previous.compareTo(current) > 0) {
                System.out.println("Array not sorted. " + previous + " > " + current);
                break;
            }
            previous = current;
        }
    }
}
