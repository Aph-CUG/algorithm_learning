class MinStack {
    //定义一个记录数组，记录当前位置的最小值
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> preMin = new Stack<Integer>();

    public MinStack() {

    }
    
    public void push(int val) {
        stack.push(val);
        if(preMin.isEmpty()) preMin.push(val);
        else preMin.push(Math.min(preMin.peek(),val));
    }
    
    public void pop() {
        stack.pop();
        preMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return preMin.peek();
    }

    
}

