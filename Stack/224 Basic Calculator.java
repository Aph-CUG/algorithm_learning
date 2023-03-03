class Solution {
    public int calculate(String s) {
        s += " ";
        ArrayList<String> tokensArray =new ArrayList<>();
        String number = "";
        boolean needsZero = true;
        for(char ch : s.toCharArray()){
            if(ch >='0' && ch <= '9'){
                number += ch;
                needsZero = false;
                continue;
            } else{
                if(!number.isEmpty()){
                    tokensArray.add(number);
                    number = "";
                }
            }
            if(ch == ' ') continue;
            if(ch == '(') {
                ops.push(ch);
                needsZero = true;
                continue;
            }
            if(ch == ')'){
                while (ops.peek() !='('){
                    tokensArray.add(String.valueOf(ops.peek()));
                    ops.pop();
                }
                ops.pop();
                needsZero = false;
                continue;
            }
            if((ch == '+' || ch == '-') && needsZero){
                tokensArray.add("0");
            }
            int currRank = getRank(ch);
            while(!ops.isEmpty() && getRank(ops.peek()) >= currRank){
                tokensArray.add(String.valueOf(ops.peek()));
                ops.pop();
            }
            ops.push(ch);
            needsZero = true;
        }
        while(!ops.isEmpty()){
            tokensArray.add(String.valueOf(ops.peek()));
            ops.pop();
        }
        String tokens[]=tokensArray.toArray(new String[tokensArray.size()]);
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