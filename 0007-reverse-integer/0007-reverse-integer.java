class Solution {
    public int reverse(int n) {
        int revNum = 0;

        while (n != 0) {

            int lastDigit = n % 10;

            if (revNum > Integer.MAX_VALUE / 10 ||
               (revNum == Integer.MAX_VALUE / 10 && lastDigit > 7))
                return 0;

            if (revNum < Integer.MIN_VALUE / 10 ||
               (revNum == Integer.MIN_VALUE / 10 && lastDigit < -8))
                return 0;

            revNum = revNum * 10 + lastDigit;

            n = n / 10;
        }

        return revNum;
    }
}