public class B29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        int dividendFlag = dividend >>> 31;
        if (divisor == -1) {
            if (dividendFlag == 1) {
                return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            }
            return -dividend;
        }
        int divisorFlag = divisor >>> 31;
        int flag = dividendFlag == divisorFlag ? 0 : 1;
        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;

        int count = 0;
        while (dividend <= divisor) {
            dividend = dividend - divisor;
            count++;
        }

        return flag == 1 ? -count : count;
    }
}
