class MinStack {


    ArrayList<Integer> stack;
    ArrayList<Integer> trackMin;

    public MinStack() {
        stack = new ArrayList<>();
        trackMin = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (trackMin.isEmpty()) {
            trackMin.add(val);
        } else {
            trackMin.add(Math.min(val, trackMin.get(trackMin.size()-1)));
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        trackMin.remove(trackMin.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return trackMin.get(trackMin.size()-1);
    }
}
