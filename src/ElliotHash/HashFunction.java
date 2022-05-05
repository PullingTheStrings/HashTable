package ElliotHash;

public class HashFunction {
    static int hash(int key,double decimal,int size){
        double log = Math.log(Math.abs(key) + 1);
        double m = Math.pow(10,decimal) * log - Math.floor(Math.pow(10,decimal) * log);
        // 1: take the absolute value of the number and add 1
        // 2:take the log of this number
        // 3: move the decimal point <decimal> spots to the right
        // 4: delete everything to the left of the decimal point
        int finalNumber = 0;
        int digits = (int) Math.floor(Math.log10(size)); // the number of digits that we take from this number
        for (int digit = 0; digit < digits; digit++) {
            int i = (int) Math.floor(10 * m);
            finalNumber = finalNumber + (int) (i * Math.pow(10, digits - 1 - digit));
            m = 10 * m - i;
        }
        return finalNumber; // this number will be the array index slot
    }
}
