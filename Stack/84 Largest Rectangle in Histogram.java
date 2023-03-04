class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        //在末尾补零以简化过程
        int newHeights[] = new int[heights.length + 1];
        for(int i = 0 ; i < heights.length ; i++){
            newHeights[i] = heights[i];
        }
        newHeights[heights.length] = 0;
        for(int height : newHeights){
            int accumlatedWidth = 0;
            //当栈顶height大于当前height，破坏了单调性，确定了栈顶高度的扩展范围，需要删除栈顶
            while(!s.isEmpty() && s.peek().height >= height){
                accumlatedWidth += s.peek().width;
                ans = Math.max(ans,s.peek().height * accumlatedWidth);
                s.pop();
            }
            Rect Rect_push = new Rect(accumlatedWidth + 1,height);
            s.push(Rect_push);
        }
        return ans;
    }

    private class Rect{
        Rect(int width , int height){
            this.width = width;
            this.height = height;
        }
        int width;
        int height;
    }
    private Stack<Rect> s = new Stack<Rect>();
}