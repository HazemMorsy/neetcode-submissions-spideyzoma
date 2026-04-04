class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> sortedMap = freqMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        int [] res = new int [k];
        int index = 0;
        int targetIndex = sortedMap.size() - k;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (index >= targetIndex) {
                res[index - targetIndex] = entry.getKey(); 
            }
            index++;
        } 

        return res;

    }
}
