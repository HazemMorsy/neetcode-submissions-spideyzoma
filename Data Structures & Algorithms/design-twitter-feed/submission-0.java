class Twitter {

    HashMap<Integer, Set<Integer>> followersMap;
    HashMap<Integer, List<int[]>> tweets;
    int count;

    public Twitter() {
        followersMap = new HashMap<>();
        tweets = new HashMap<>();
        // to ensure the sorting globally across users
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            tweets.get(userId).add(new int[]{count, tweetId});
        } else {
            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[]{count, tweetId});
            tweets.put(userId, list);
        }
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = followersMap.getOrDefault(userId, new HashSet<>());
        ArrayList<int[]> allTweets = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : tweets.entrySet()) {
            // if user themself or one of their followers posted a tweet
            if (entry.getKey() == userId || (!followers.isEmpty() &&  followers.contains(entry.getKey()))) {
                allTweets.addAll(entry.getValue());
            }
        }

        Collections.sort(allTweets, new CustomComparator());

        List<Integer> res = new LinkedList<>();
        for (int i = 0;i<allTweets.size();i++) {
            res.add(allTweets.get(i)[1]);
            if (i == 9) {
                break;
            }
        }

        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            followersMap.put(followerId, set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(followeeId);
        }
    }

    class CustomComparator implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2) {
            return arr2[0] - arr1[0];
        }
    }
}
