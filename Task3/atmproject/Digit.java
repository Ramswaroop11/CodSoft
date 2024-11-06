package atmproject;

public class Digit {
    // method to count digits in a long  card number
    static long digitCount(long cardNo) {
        long count = 0;
        while (cardNo != 0) {
            cardNo = cardNo / 10;
            count++;
        }
        return count;
    }

    // method to count digits in an integer  PIN
    static int digitCount(int pin) {
        int count = 0;
        while (pin != 0) {
            pin = pin / 10;
            count++;
        }
        return count;
    }
}
