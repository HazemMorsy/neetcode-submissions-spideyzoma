class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        int expectedMaxFreq = hand.length / groupSize;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int currHand : hand) {
            if (map.containsKey(currHand)) {
                map.put(currHand, map.get(currHand) + 1);
            } else {
                map.put(currHand, 1);
            }

            if (map.get(currHand) > expectedMaxFreq) {
                return false;
            }
        }

        Arrays.sort(hand);

        for (int currHand : hand) {
            if (map.get(currHand) > 0) {
            for (int i=currHand;i<currHand + groupSize;i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i)-1);
            }
            }
        }

        return true;
    }
}
