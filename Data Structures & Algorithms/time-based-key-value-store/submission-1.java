class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair(timestamp, value));
        } else {
            Pair newPair = new Pair(timestamp, value);
            ArrayList<Pair> pairList = new ArrayList<>();
            pairList.add(newPair);
            map.put(key, pairList);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> pairList = map.get(key);

        int l = 0;
        int r = pairList.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair currPair = pairList.get(m);
            if (currPair.getCurrTime() <= timestamp) {
                res = currPair.getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }


    class Pair {
        int currTime;
        String value;

        Pair(int currTime, String value) {
            this.currTime = currTime;
            this.value = value;
        }

        int getCurrTime() {
            return this.currTime;
        }

        String getValue() {
            return this.value;
        }
    }
}
