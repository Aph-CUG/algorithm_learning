class Solution {
    public boolean isValid(String s) {
        //stack 的创建方法
        Stack<Character> stack = new Stack<Character>();
        //for each中先把String变为Array数组
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;
                if(ch == ')' && stack.peek() != '(') return false;
                if(ch == ']' && stack.peek() != '[') return false;
                if(ch == '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}