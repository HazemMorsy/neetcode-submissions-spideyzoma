class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int half = (totalLen + 1) / 2;
        int [] shortArr = nums1;
        int [] longArr = nums2;
        if (nums2.length < nums1.length) {
            shortArr = nums2;
            longArr = nums1;
        }

        int l = 0;
        int r = shortArr.length;

        // [1,2,5,6]
        // [4,7,8]
        // [1,2,4,5,6,7,8]

        // [1,5,6]
        // [2,3,4]
        // [1,2,3,4,5,6]
        while (l <= r) {
            int m = l + (r - l) / 2; // 0
            int remaining = half - m; // 0

            int shortLeft = m > 0 ? shortArr[m - 1] : Integer.MIN_VALUE; // 3
            int shortRight = m <= shortArr.length - 1 ?  shortArr[m] : Integer.MAX_VALUE;
            int longLeft = remaining > 0 ? longArr[remaining - 1] : Integer.MIN_VALUE;
            int longRight = remaining <= longArr.length - 1 ? longArr[remaining] : Integer.MAX_VALUE;
            if (shortLeft <= longRight && longLeft <= shortRight) {
                if (totalLen % 2 == 0) {
                    // even
                    return (Math.max(shortLeft, longLeft) + Math.min(shortRight, longRight)) / 2.0;
                } else {
                    // odd
                    return Math.max(shortLeft, longLeft);
                }
            } else if (shortLeft > longRight) {
                r = m - 1;
            } else {
                l = m + 1;
            }

        } 

        return -1;
    }
}
