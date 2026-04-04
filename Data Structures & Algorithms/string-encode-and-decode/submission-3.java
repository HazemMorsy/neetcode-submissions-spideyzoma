class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String str : strs) {
            res += (str.length() + "#" + str);
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        // 3#abc4#abcd2#ab
        int i = 0;
        while (i < str.length()) {
            String currSize = "";
            while (str.charAt(i) != '#') {
                currSize += str.charAt(i);
                i++;
            }
            int endIndex = i+1+Integer.parseInt(currSize);
            res.add(str.substring(i+1, endIndex));

            i = endIndex;
        }

        return res;
    }
}
