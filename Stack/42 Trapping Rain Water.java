class Solution {
    public int trap(int[] height) {
        int ans = 0;
        for(int h : height){
            int accumlatedWidth = 0;
            while(!s.isEmpty() && s.peek().height <= h){
                int bottom = s.peek().height;
                accumlatedWidth += s.peek().width;
                s.pop();
                int up = s.isEmpty() ? 0 : h;
                if(!s.isEmpty() && s.peek().height < up)
                    up = s.peek().height;
                ans += accumlatedWidth *(up - bottom);
            }
            Rect Rect_push = new Rect(accumlatedWidth + 1,h);
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