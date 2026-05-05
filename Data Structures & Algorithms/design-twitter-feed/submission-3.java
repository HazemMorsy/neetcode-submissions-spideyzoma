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
        List<Integer> res = new ArrayList<>();

        Set<Integer> followees = followersMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomComparator());
        
        for (int currUser : followees) {
            if (tweets.containsKey(currUser)){
                List<int[]> currTweets = tweets.get(currUser);
                int lastIndex = currTweets.size()-1;
                int [] mostRecentTweet = currTweets.get(lastIndex);
                pq.offer(new int[]{mostRecentTweet[0], mostRecentTweet[1], currUser, lastIndex});
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {
            int[] onTop = pq.poll();
            res.add(onTop[1]);
            int lastIndex = onTop[3];
            if (lastIndex > 0) {
                int[] newTweet = tweets.get(onTop[2]).get(lastIndex - 1);
                pq.offer(new int[]{newTweet[0], newTweet[1], onTop[2], lastIndex - 1});
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
