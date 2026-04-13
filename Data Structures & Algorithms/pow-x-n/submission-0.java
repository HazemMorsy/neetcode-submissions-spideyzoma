class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;

        if (n == 0) {
            return ans;
        }

        int pow = Math.abs(n);

        while (pow > 0) {
            ans *= x;
            pow--;
        }

        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;

    }
}
