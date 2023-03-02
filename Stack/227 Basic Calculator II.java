class Solution {
    public int calculate(String s) {
        //为了把最后一个数加上，需要增加一个空字符
        s += " ";
        ArrayList<String> tokensArray =new ArrayList<>();
        String number = "";
        for(char ch : s.toCharArray()){
            if(ch >='0' && ch <= '9'){
                number += ch;
                continue;
            } else{
                if(!number.isEmpty()){
                    //添加数字后重置
                    tokensArray.add(number);
                    number = "";
                }
            }
            if(ch == ' ') continue;
            //设置算数优先级
            int currRank = getRank(ch);
            while(!ops.isEmpty() && getRank(ops.peek()) >= currRank){
                //转为String
                tokensArray.add(String.valueOf(ops.peek()));
                ops.pop();
            }
            ops.push(ch);
        }
        while(!ops.isEmpty()){
            tokensArray.add(String.valueOf(ops.peek()));
            ops.pop();
        }
        String tokens[]=tokensArray.toArray(new String[tokensArray.size()]);
        //复用之前的函数
        return evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        for(String str : tokens){
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

    int getRank(char op){
        if(op == '*' || op == '/') return 2;
        if(op == '+' || op == '-') return 1;
        return 0;
    }
    Stack<Character> ops = new Stack<Character>();
}