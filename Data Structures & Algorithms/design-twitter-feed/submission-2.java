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
        Set<Integer> followees = followersMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomComparator());
        
        for (int currUser : followees) {
            if (tweets.containsKey(currUser)){
                List<int[]> currTweets = tweets.get(currUser);
                for (int[] currTweet : currTweets) {
                    pq.offer(currTweet);

                    if (pq.size() > 10) {
                        pq.poll();
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.reverse(res);
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
            return arr1[0] - arr2[0];
        }
    }
}
