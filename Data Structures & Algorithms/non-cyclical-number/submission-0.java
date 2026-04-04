class Solution {
    public boolean isHappy(int n) {
        int res = getRes(n);
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(res)) {
            set.add(res);
            res = getRes(res);
            if (res == 1) {
                return true;
            }
        }
        return false;
    }

    private int getRes(int n) {
        int totalVal = 0;
        while (n > 0) {
            int currDigit = n % 10;
            totalVal += (currDigit * currDigit);
            n = n / 10;
        }

        return totalVal;
    }


}
