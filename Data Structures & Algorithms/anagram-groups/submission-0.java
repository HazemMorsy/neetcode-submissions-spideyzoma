class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();

        HashMap<String, LinkedList<String>> mapResult = new HashMap<>();

        for (String str: strs) {
            int[] stringRep = new int[26];
            char[] ch = str.toCharArray();

            // logic for modifying the string representation
            for (char c : ch) {
                stringRep[c - 'a']++;
            }

            String currRep = Arrays.toString(stringRep);
            LinkedList<String> currList = mapResult.getOrDefault(currRep, new LinkedList<>());
            currList.add(str);
            mapResult.put(currRep, currList);
        }

        for (Map.Entry<String, LinkedList<String>> entry: mapResult.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
