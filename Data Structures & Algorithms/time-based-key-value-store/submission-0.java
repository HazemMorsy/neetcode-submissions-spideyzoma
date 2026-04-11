class TimeMap {

    HashMap<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            HashMap<Integer, String> snapshots = map.get(key);
            snapshots.put(timestamp, value);
            map.put(key, snapshots);
        } else {
            HashMap<Integer, String> snapshots = new HashMap<>();
            snapshots.put(timestamp, value);
            map.put(key, snapshots);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        HashMap<Integer, String> snapshots = map.get(key);
        if (snapshots.containsKey(timestamp)) {
            return snapshots.get(timestamp);
        } else {
            int currTime = timestamp;
            while (currTime > 0 && !snapshots.containsKey(currTime)) {
                currTime--;
            }

            if (snapshots.containsKey(currTime)) {
                return snapshots.get(currTime);
            } else {
                return "";
            }
            
        }
    }
}
