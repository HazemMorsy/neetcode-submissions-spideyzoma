class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map of the num and its freq
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int [] res = new int[k];
        ArrayList<Integer> [] count = new ArrayList[nums.length + 1];
        for (int i=0;i<count.length;i++) {
            count[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count[entry.getValue()].add(entry.getKey());
        }

        int resIndex = k-1;
        for (int i=count.length-1;i>=0;i--) {
            ArrayList<Integer> currArr = count[i];
            for (int j=0;j<currArr.size();j++) {
                res[resIndex] = currArr.get(j);
                resIndex--;
                if (resIndex < 0) {
                    break;
                }
            }
            if (resIndex < 0) {
                    break;
                }
        }

        return res;

    }
}
