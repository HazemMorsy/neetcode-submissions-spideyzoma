class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> mapToList = new LinkedList<>(frequencyMap.entrySet());

        Collections.sort(
            mapToList, (i, j) -> i.getValue().compareTo(j.getValue())
        );

        int[] res = new int[k];
        int iteratorK = k-1;
        for (int i=mapToList.size()-1;i>=mapToList.size()-k;i--) {
            res[iteratorK] = mapToList.get(i).getKey();
            iteratorK--;
        }

        return res;

    }
}
