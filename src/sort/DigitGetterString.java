package sort;

public class DigitGetterString implements DigitGetter<String> {
    @Override
    public int getDigit(String element, int d, int bits) {
        int bytes = element.length();
        int elementBits = bytes * 8;

        int bitsTo = elementBits - (d * bits);
        if (bitsTo <= 0) return -1;

        int bitsFrom = elementBits - ((d + 1) * bits);
        if (bitsFrom < 0) bitsFrom = 0;

        int bytesTo = (bitsTo / 8) - 1;
        int bytesFrom = bitsFrom / 8;

        int bitsToAdd = 0;
        int outputBits = 0;
        for (int i = bytesTo; i >= bytesFrom; i--) {
            char currentByte = element.charAt(bytes - 1 - i);
            if (i == bytesTo && i == bytesFrom) {
                bitsToAdd = (8 - (bitsTo % 8)) - (bitsFrom % 8);
                outputBits = (-1 >>> 32 - (32 - (bitsTo % 8))) & currentByte >>> (bitsFrom % 8);
            }

            //First bits - Since it's the first bits we add we don't need to shift.
            if (i == bytesTo && i != bytesFrom) {
                bitsToAdd = (8 - (bitsTo % 8));
                outputBits = currentByte;
            }

            //Last bits - We shift the output by the number of bits we are adding, then we shift the current byte
            //so that it only contains the bits we want. Finally, we add the bits to the output.
            if (i == bytesFrom && i != bytesTo) {
                bitsToAdd = 8 - (bitsFrom % 8);
                outputBits = (outputBits << bitsToAdd) | (currentByte >>> (bitsFrom % 8));
            }

            //Full byte - We are adding a full byte, so we shift by 8 and then add the byte.
            if (i != bytesTo && i != bytesFrom) {
                bitsToAdd = 8;
                outputBits = (outputBits << bitsToAdd) | currentByte;
            }

            bits -= bitsToAdd;
        }


//        System.out.println("out: " + outputBits);
//        System.out.println("bits: " + bits);
//        System.out.println();
        return outputBits << bits;
    }

//    @Override
//    public int getDigit(String element, int d, int bits) {
//        int bytes = element.length();
//        int elementBits = bytes * 8;
//
//        int bitsFrom = d * bits;
//        if (bitsFrom >= elementBits) return -1;
//        int bytesFrom = bitsFrom / 8;
//
//        int bitsTo = ((d + 1) * bits) - 1;
//        if (bitsTo > elementBits) bitsTo = elementBits - 1;
//        int bytesTo = bitsTo / 8;
//
//        if (bytesFrom == bytesTo) {
//            return ((-1 >>> 32 - (bitsTo % 8)) & element.charAt(bytesTo)) >>> (bitsFrom % 8);
//        }
//
//        int outputBits = 0;
//        for (int i = bytesFrom; i <= bytesTo; i++) {
//            if (i == bytesFrom) {
//                outputBits = element.charAt(bitsFrom / 8) >>> ((bitsFrom % 8));
//            } else if (i == bytesTo) {
//                outputBits = (outputBits << ((bitsTo % 8))) | (element.charAt(bitsTo / 8) >>> (7 - (bitsTo % 8)));
//            } else { //Take all bits from current byte
//                outputBits = (outputBits << 8) | element.charAt(i);
//            }
//        }
//
//        return outputBits;
//    }
}
