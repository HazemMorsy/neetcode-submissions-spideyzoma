class Solution {

    public String encode(List<String> strs) {
        // lets add info in the end of the string
        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder strResult = new StringBuilder();
        int[] strLengths = new int[strs.size()];
        int totalLength = 0;
        int index = 0;
        for (String str: strs) {
            if (index != 0) {
                strLengths[index] = strLengths[index-1] + str.length();
            } else {
                strLengths[index] = str.length();
            }

            totalLength+= str.length();
            strResult.append(str);
            index++;
        }

        for (int currLength: strLengths) {
            strResult.append(" ").append(currLength);
        }
        strResult.append(" ").append(strs.size());
        return strResult.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }
        String[] arrs = str.split(" ");
        int noOfSections = Integer.parseInt(arrs[arrs.length-1]);
        int wholeLength = Integer.parseInt(arrs[arrs.length-2]);
        List<String> result = new LinkedList<>();
        String wholeStr = str.substring(0, wholeLength);

        for (int i=0;i<noOfSections;i++) {
            if (i==0) {
                result.add(wholeStr.substring(0, Integer.parseInt(arrs[arrs.length - 1 - noOfSections + i])));
            } else {
                result.add(wholeStr.substring(Integer.parseInt(arrs[arrs.length - 2 - noOfSections + i]),
                        Integer.parseInt(arrs[arrs.length - 1 - noOfSections + i])));
            }
        }

        return result;
    }
}
