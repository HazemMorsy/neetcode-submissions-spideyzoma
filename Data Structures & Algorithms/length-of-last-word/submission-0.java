class Solution {
    public int lengthOfLastWord(String s) {
        String [] resArr = s.split("\\s+");

        return resArr[resArr.length - 1].length();
    }
}