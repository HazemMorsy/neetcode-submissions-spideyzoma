class MedianFinder {

    List<Integer> arrList;

    public MedianFinder() {
        arrList = new ArrayList<>();
    }
    
    public void addNum(int num) {

        if (arrList.isEmpty() || num >= arrList.get(arrList.size() - 1)) {
            arrList.add(num);
        } else {
            // to add 3
            // [1,2,7]
            List<Integer> newList = new ArrayList<>();
            int i = 0;
            while (i < arrList.size() && num >= arrList.get(i)) {
                newList.add(arrList.get(i));
                i++;
            }
            // add new val in the right place
            newList.add(num);

            while (i < arrList.size()) {
                newList.add(arrList.get(i));
                i++;
            }

            arrList = newList;

        }
        
    }
    
    public double findMedian() {
        if (arrList.size() % 2 == 0) {
            return (arrList.get((arrList.size() / 2) - 1) + arrList.get(arrList.size() / 2)) / 2.0;
        }

        return arrList.get(arrList.size() / 2);
    }
}
