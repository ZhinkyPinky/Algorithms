package sort;

public class DigitGetterInt implements DigitGetter<Integer> {
    @Override
    public int getDigit(Integer element, int d, int bits) {
        int bitsTo = 32 - (d * bits);
        if (bitsTo <= 0) return -1;

        int bitsFrom = (32 - ((d + 1) * bits));
        if (bitsFrom < 0) bitsFrom = 0;

        return ((-1 >>> 32 - (bitsTo)) & element) >>> (bitsFrom);
    }
}
