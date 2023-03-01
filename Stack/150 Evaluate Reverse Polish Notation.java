class Solution {
    public int evalRPN(String[] tokens) {
        for(String str : tokens){
            //注意要用equals()函数
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int y = s.peek();
                s.pop();
                int x = s.peek();
                s.pop();
                int z = calc(x,y,str);
                s.push(z);
            } else{
                s.push(Integer.valueOf(str));
            }
        }
        return s.peek();
    }
    private Stack<Integer> s= new Stack<Integer>(); 
    private int calc(int x ,int y, String op){
        if(op.equals("+")) return x + y;
        if(op.equals("-")) return x - y;
        if(op.equals("*")) return x * y;
        if(op.equals("/")) return x / y;
        return 0;
    }
}